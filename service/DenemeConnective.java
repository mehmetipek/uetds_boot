package com.arma.uetds_boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.arma.uetds_boot.model.CargoNotification;
import com.arma.uetds_boot.model.UetdsCompanies;
import com.arma.uetds_boot.model.YolcuSeferBilgileriInput;
import com.arma.uetds_boot.model.Yolcu_GrupInput;
import com.arma.uetds_boot.model.Yolcu_PersonelInput;
import com.arma.uetds_boot.model.Yolcu_YolcuBilgileriInput;
import com.arma.uetds_boot.repository.CargoRepository;
import com.arma.uetds_boot.repository.YolcuSeferRepository;
import com.arma.uetds_boot.repository.Yolcu_GrupRepo;
import com.arma.uetds_boot.repository.Yolcu_PersonelRepository;
import com.arma.uetds_boot.repository.Yolcu_YolcuRepository;
import com.arma.uetds_boot.wsdl.UetdsEsyaSonuc;
import com.arma.uetds_boot.wsdl.WsUetdsEsyaAracBilgileriInput;
import com.arma.uetds_boot.wsdl.WsUetdsEsyaYukBilgileriInput;
import com.arma.uetds_boot.wsdl.YeniYukKaydiBildir;
import com.arma.uetds_boot.wsdl.YukBildirimiGuncelle;
import com.arma.uetds_boot.yolcu.wsdl.PersonelEkle;
import com.arma.uetds_boot.yolcu.wsdl.SeferEkle;
import com.arma.uetds_boot.yolcu.wsdl.SeferGrupEkle;
import com.arma.uetds_boot.yolcu.wsdl.SeferGuncelle;
import com.arma.uetds_boot.yolcu.wsdl.UetdsAriziGrupBilgileriInput;
import com.arma.uetds_boot.yolcu.wsdl.UetdsAriziSeferBilgileriInput;
import com.arma.uetds_boot.yolcu.wsdl.UetdsAriziSeferPersonelBilgileriInput;
import com.arma.uetds_boot.yolcu.wsdl.UetdsAriziSeferYolcuBilgileriInput;
import com.arma.uetds_boot.yolcu.wsdl.UetdsYolcuSonuc;
import com.arma.uetds_boot.yolcu.wsdl.YolcuEkle;
import com.arma.uetds_boot.yolcu.wsdl.YolcuEkleCoklu;

@Component
public class DenemeConnective {

	@Autowired
	private CargoRepository cargoRepository;

	@Autowired
	private YolcuSeferRepository yolcuRepository;

	@Autowired
	private Yolcu_GrupRepo grupRepo;

	@Autowired
	private Yolcu_PersonelRepository personelRepo;

	@Autowired
	private Yolcu_YolcuRepository yolcu_YolcuRepo;

	/*
	 * public void YeniYolcuCokluEkle(YolcuEkleCoklu ekle, YolcuSeferBilgileriInput
	 * seferid, Yolcu_GrupInput grupId, List<UetdsYolcuSonuc> uetdsYolcuRefNo) {
	 * List<UetdsAriziSeferYolcuBilgileriInput> a = ekle.getYolcuBilgileri(); int
	 * b=0; for(UetdsAriziSeferYolcuBilgileriInput i:a) { Yolcu_YolcuBilgileriInput
	 * yolcu=new Yolcu_YolcuBilgileriInput(seferid, i.getUyrukUlke(),
	 * i.getTcKimlikPasaportNo(), i.getCinsiyet(), i.getAdi(), i.getSoyadi(),
	 * i.getKoltukNo(), i.getTelefonNo(), grupId,
	 * uetdsYolcuRefNo.get(b).getUetdsBiletRefNo().toString());
	 * yolcu_YolcuRepo.save(yolcu); b++; }
	 * 
	 * }
	 */
	public void yeniPersonelEkle(PersonelEkle ekle, YolcuSeferBilgileriInput seferid) {
			UetdsAriziSeferPersonelBilgileriInput i = ekle.getSeferPersonelBilgileriInput().get(0);
			Yolcu_PersonelInput personel = new Yolcu_PersonelInput(seferid, i.getTurKodu(), i.getUyrukUlke(),
					i.getTcKimlikPasaportNo(), i.getCinsiyet(), i.getAdi(), i.getSoyadi(), i.getTelefon(), i.getAdres(),
					"Geçerli");
			personelRepo.save(personel);
		
	}

	public void yeniGrupEkle(SeferGrupEkle ekle, YolcuSeferBilgileriInput seferid, String uetdsGrupRefNo) {
		UetdsAriziGrupBilgileriInput i = ekle.getSeferGrupBilgileriInput();
		Yolcu_GrupInput grup = new Yolcu_GrupInput(i.getGrupAciklama(), i.getBaslangicUlke(), i.getBaslangicIl(),
				i.getBaslangicIlce(), i.getBaslangicYer(), i.getBitisUlke(), i.getBitisIl(), i.getBitisIlce(),
				i.getBitisYer(), i.getGrupAdi(), i.getGrupUcret(), "Geçerli", seferid, uetdsGrupRefNo);
		grupRepo.save(grup);
	}

	public void YeniYolcuEkle(UetdsAriziSeferYolcuBilgileriInput i, YolcuSeferBilgileriInput seferid,
			Yolcu_GrupInput grupId, String uetdsYolcuRefNo) {

		Yolcu_YolcuBilgileriInput yolcu = new Yolcu_YolcuBilgileriInput(seferid, i.getUyrukUlke(),
				i.getTcKimlikPasaportNo(), i.getCinsiyet(), i.getAdi(), i.getSoyadi(), i.getKoltukNo(),
				i.getTelefonNo(), "Geçerli", grupId, uetdsYolcuRefNo);
		yolcu_YolcuRepo.save(yolcu);
	}

	public void yeniSeferEkle(SeferEkle ekle, UetdsCompanies company, Long seferid) {

		UetdsAriziSeferBilgileriInput i = ekle.getAriziSeferBilgileriInput();
		YolcuSeferBilgileriInput sefer = new YolcuSeferBilgileriInput(company, i.getAracPlaka(), i.getSeferAciklama(),
				i.getHareketTarihi().toString(), i.getHareketSaati(), i.getAracTelefonu(), i.getFirmaSeferNo(),
				i.getSeferBitisTarihi().toString(), i.getSeferBitisSaati(), "Geçerli", seferid);

		yolcuRepository.save(sefer);

	}
	public void seferGuncelle(SeferGuncelle ekle, UetdsCompanies company, Long seferRefNo, Long seferId) {

		UetdsAriziSeferBilgileriInput i = ekle.getAriziSeferBilgileriInput();
		YolcuSeferBilgileriInput sefer = new YolcuSeferBilgileriInput(seferId,company, i.getAracPlaka(), i.getSeferAciklama(),
				i.getHareketTarihi().toString(), i.getHareketSaati(), i.getAracTelefonu(), i.getFirmaSeferNo(),
				i.getSeferBitisTarihi().toString(), i.getSeferBitisSaati(), "Geçerli", seferRefNo);

		yolcuRepository.save(sefer);

	}

	public void yeniKargoKaydi(YeniYukKaydiBildir yeniYukKaydiBildir, UetdsCompanies company,
			List<UetdsEsyaSonuc> referansNoLong) {
		try {
			List<WsUetdsEsyaYukBilgileriInput> esyaBilgileri = yeniYukKaydiBildir.getYukBilgileriListInput();
			WsUetdsEsyaAracBilgileriInput arac = yeniYukKaydiBildir.getAracBilgileriInput();
			for (WsUetdsEsyaYukBilgileriInput esya : esyaBilgileri) {
				CargoNotification cargoNotification = new CargoNotification(company,
						referansNoLong.get(0).getUetdsBildirimReferansNo(), esya.getAliciUnvan(),
						esya.getYuklemeUlkeKodu(), esya.getYuklemeIlMernisKodu(), esya.getYuklemeIlceMernisKodu(),
						esya.getBosaltmaUlkeKodu(), esya.getBosaltmaIlMernisKodu(), esya.getBosaltmaIlceMernisKodu(),
						esya.getGonderenUnvan(), esya.getGonderenVergiNo(), esya.getTasimaBedeli(), esya.getYukCinsId(),
						arac.getTasimaTuruKodu(), arac.getPlaka1(), arac.getSofor1TcNo(), arac.getPlaka2(),
						arac.getSofor2TcNo(), "Yeni Kayıt", esya.getYuklemeTarihi());

				cargoRepository.save(cargoNotification);
			}

		} catch (Exception e) {
			System.out.println("############" + e);
		}

	}

	public void kargoGuncelle(YukBildirimiGuncelle yeniYukKaydiBildir, UetdsCompanies company) {

		WsUetdsEsyaYukBilgileriInput esyaBilgileri = yeniYukKaydiBildir.getYukBilgileriInput();
		WsUetdsEsyaAracBilgileriInput arac = yeniYukKaydiBildir.getAracBilgileriInput();

		CargoNotification id = cargoRepository.findByuetdsBildirimReferansNo(yeniYukKaydiBildir.getBildirimId());

		CargoNotification cargoNotification = new CargoNotification(id.getId(), company,
				yeniYukKaydiBildir.getBildirimId(), esyaBilgileri.getAliciUnvan(), esyaBilgileri.getYuklemeUlkeKodu(),
				esyaBilgileri.getYuklemeIlMernisKodu(), esyaBilgileri.getYuklemeIlceMernisKodu(),
				esyaBilgileri.getBosaltmaUlkeKodu(), esyaBilgileri.getBosaltmaIlMernisKodu(),
				esyaBilgileri.getBosaltmaIlceMernisKodu(), esyaBilgileri.getGonderenUnvan(),
				esyaBilgileri.getGonderenVergiNo(), esyaBilgileri.getTasimaBedeli(), esyaBilgileri.getYukCinsId(),
				arac.getTasimaTuruKodu(), arac.getPlaka1(), arac.getSofor1TcNo(), arac.getPlaka2(),
				arac.getSofor2TcNo(), "Guncellendi", esyaBilgileri.getYuklemeTarihi());

		cargoRepository.save(cargoNotification);
	}

}
