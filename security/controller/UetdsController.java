package com.arma.uetds_boot.security.controller;

import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arma.uetds_boot.UetdsBootApplication;
import com.arma.uetds_boot.implement.ServiceSetMethodsImpl;
import com.arma.uetds_boot.model.CargoNotification;
import com.arma.uetds_boot.model.PlakaListModel;
import com.arma.uetds_boot.model.UetdsCompanies;
import com.arma.uetds_boot.model.YeniYukKaydi_iExcell;
import com.arma.uetds_boot.repository.CargoRepository;
import com.arma.uetds_boot.service.DenemeConnective;
import com.arma.uetds_boot.service.UetdsYtsUser_Fill;
import com.arma.uetds_boot.soap.interfaces.PageInputMethodsInterface;
import com.arma.uetds_boot.soap.interfaces.ServiceGetMethodsInterface;
import com.arma.uetds_boot.soap.interfaces.ServiceSetMethodsInterface;
import com.arma.uetds_boot.soapConfig.UetdsClient;
import com.arma.uetds_boot.wsdl.IptalTurleri;
import com.arma.uetds_boot.wsdl.IptalTurleriResponse;
import com.arma.uetds_boot.wsdl.ObjectFactory;
import com.arma.uetds_boot.wsdl.ParamTehlikeliMaddeTasimaSekli;
import com.arma.uetds_boot.wsdl.ParamTehlikeliMaddeTasimaSekliResponse;
import com.arma.uetds_boot.wsdl.ParamYukBirimi;
import com.arma.uetds_boot.wsdl.ParamYukTuru;
import com.arma.uetds_boot.wsdl.UetdsEsyaParamEsyaTurSonuc;
import com.arma.uetds_boot.wsdl.UetdsEsyaParamIptalTuruSonuc;
import com.arma.uetds_boot.wsdl.UetdsEsyaParamTehlikeliMaddeTasimaSekliSonuc;
import com.arma.uetds_boot.wsdl.UetdsEsyaParamYukBirimiSonuc;
import com.arma.uetds_boot.wsdl.UetdsEsyaWsBildirimListesiSonuc;
import com.arma.uetds_boot.wsdl.UetdsEsyaWsYukBildirimDetayiSonuc;
import com.arma.uetds_boot.wsdl.UetdsEsyaYeniYukKaydiBildirSonuc;
import com.arma.uetds_boot.wsdl.UetdsGenelIslemSonuc;
import com.arma.uetds_boot.wsdl.UetdsYtsUser;
import com.arma.uetds_boot.wsdl.WsUetdsEsyaAracBilgileriInput;
import com.arma.uetds_boot.wsdl.WsUetdsEsyaYukBilgileriInput;
import com.arma.uetds_boot.wsdl.YeniYukKaydiBildir;
import com.arma.uetds_boot.wsdl.YukBildirimiDetayi;
import com.arma.uetds_boot.wsdl.YukBildirimiDetayiResponse;
import com.arma.uetds_boot.wsdl.YukBildirimiGuncelle;
import com.arma.uetds_boot.wsdl.YukBildirimiGuncelleResponse;
import com.arma.uetds_boot.wsdl.YukBildirimiIptalEt;
import com.arma.uetds_boot.wsdl.YukBildirimiIptalEtResponse;
import com.arma.uetds_boot.wsdl.YukBildirimiListesi;
import com.arma.uetds_boot.wsdl.YukBildirimiListesiResponse;

//user.setKullaniciAdi("922571");
// user.setSifre("0OKYGH0PVB");

@CrossOrigin("*")
@RestController
@RequestMapping("/deneme")
public class UetdsController {

	private static final Logger logger = LoggerFactory.getLogger(UetdsBootApplication.class);

	@SuppressWarnings("unused")
	private ObjectFactory factory = new ObjectFactory();

	@Autowired
	@Qualifier("pageInputClient")
	private PageInputMethodsInterface pageInputMethodsImpl;

	@Autowired
	@Qualifier("serviceGetClient")
	private ServiceGetMethodsInterface serviceGetMethodsImpl;

	@Autowired
	@Qualifier("serviceSetClient")
	private ServiceSetMethodsInterface serviceSetMethodsImpl;

	@Autowired
	private UetdsYtsUser_Fill userFill;

	@Autowired
	private DenemeConnective connect;

	@Autowired
	private CargoRepository cargoRepo;

	@CrossOrigin("*")
	@RequestMapping("/paramYukBirimi/{firma_id}")
	public UetdsEsyaParamYukBirimiSonuc paramYukBirimi(@RequestBody ParamYukBirimi yukBirimi,
			@PathVariable Long firma_id) {
		 yukBirimi.setWsuser(userFill.fill(firma_id));

		return pageInputMethodsImpl.paramYukBir(yukBirimi).getReturn();
	}

	@CrossOrigin("*")
	@RequestMapping("/yukTuru/{firma_id}")
	public UetdsEsyaParamEsyaTurSonuc paramYukTuru(@RequestBody ParamYukTuru tur, @PathVariable Long firma_id) {
		tur.setWsuser(userFill.fill(firma_id));
		return pageInputMethodsImpl.paramYukTuru(tur).getReturn();
	}

	@CrossOrigin("*")
	@RequestMapping("/yukBildir/{firma_id}")
	public UetdsEsyaYeniYukKaydiBildirSonuc yeniYukKaydi(@RequestBody YeniYukKaydiBildir yeniYuk,
			@PathVariable Long firma_id) {
		System.out.println("########################### " + yeniYuk.getYukBilgileriListInput().size());
		yeniYuk.setWsuser(userFill.fill(firma_id));

		UetdsCompanies company = new UetdsCompanies(); // Local vt ye kayıt için company id içeren değişken
		company.setId(firma_id);

		UetdsEsyaYeniYukKaydiBildirSonuc sonuc = serviceSetMethodsImpl.yeniYukKaydi(yeniYuk).getReturn();

		if (sonuc.getSonucKodu() == 0)
			connect.yeniKargoKaydi(yeniYuk, company, sonuc.getUetdsEsyaSonuc());

		return sonuc;
	}

	@CrossOrigin("*")
	@RequestMapping("/yukBildirExcell/{firma_id}")
	public List<UetdsEsyaYeniYukKaydiBildirSonuc> yeniYukKaydiExcell(@RequestBody List<YeniYukKaydi_iExcell> excellList,
			@PathVariable Long firma_id) {
		List<UetdsEsyaYeniYukKaydiBildirSonuc> listSonuc = new ArrayList<UetdsEsyaYeniYukKaydiBildirSonuc>();

			for (YeniYukKaydi_iExcell excell : excellList) {
				WsUetdsEsyaYukBilgileriInput yuk = factory.createWsUetdsEsyaYukBilgileriInput();
				YeniYukKaydiBildir bildir = factory.createYeniYukKaydiBildir();
				WsUetdsEsyaAracBilgileriInput arac = factory.createWsUetdsEsyaAracBilgileriInput();

				UetdsCompanies company = new UetdsCompanies(); // Local vt ye kayıt için company id içeren değişken
				company.setId(firma_id);

				arac.setPlaka1(excell.getPlaka1());
				arac.setPlaka2(excell.getPlaka2());
				arac.setSofor1TcNo(excell.getSofor1TcNo());
				arac.setSofor2TcNo(excell.getSofor2TcNo());
				arac.setTasimaTuruKodu(excell.getTasimaTuruKodu());

				yuk.setAliciUnvan(excell.getAliciUnvan());
				yuk.setAliciVergiNo(excell.getAliciVergiNo());
				yuk.setBosaltmaIlceMernisKodu(excell.getBosaltmaIlceMernisKodu());
				yuk.setBosaltmaIlMernisKodu(excell.getBosaltmaIlMernisKodu());
				yuk.setBosaltmaSaati(excell.getBosaltmaSaati());
				yuk.setBosaltmaTarihi(excell.getBosaltmaTarihi());
				yuk.setBosaltmaUlkeKodu(excell.getBosaltmaUlkeKodu());
				yuk.setGonderenUnvan(excell.getGonderenUnvan());
				yuk.setGonderenVergiNo(excell.getGonderenVergiNo());
				yuk.setTasimaBedeli(excell.getTasimaBedeli());
				yuk.setTehlikeliMaddeTasimaSekli(excell.getTehlikeliMaddeTasimaSekli());
				yuk.setUnNumarasi(excell.getUnNumarasi());
				yuk.setYukBirimi(excell.getYukBirimi());
				yuk.setYukCinsId(excell.getYukCinsId());
				yuk.setYuklemeIlceMernisKodu(excell.getYuklemeIlceMernisKodu());
				yuk.setYuklemeIlMernisKodu(excell.getYuklemeIlMernisKodu());
				yuk.setYuklemeSaati(excell.getYuklemeSaati());
				yuk.setYuklemeTarihi(excell.getYuklemeTarihi());
				yuk.setYuklemeUlkeKodu(excell.getYuklemeUlkeKodu());
				yuk.setYukMiktari(excell.getYukMiktari());

				bildir.getYukBilgileriListInput().add(yuk);
				bildir.setWsuser(userFill.fill(firma_id));
				bildir.setAracBilgileriInput(arac);

				UetdsEsyaYeniYukKaydiBildirSonuc sonuc = serviceSetMethodsImpl.yeniYukKaydi(bildir).getReturn();

				if (sonuc.getSonucKodu() == 0)
					connect.yeniKargoKaydi(bildir, company, sonuc.getUetdsEsyaSonuc());
				else
					listSonuc.add(sonuc);
			}
		

		return listSonuc;
	}

	@CrossOrigin("*")
	@RequestMapping("/yukGuncelle/{firma_id}")
	public UetdsGenelIslemSonuc guncelleResponse(@RequestBody YukBildirimiGuncelle bildirimiGuncelle,
			@PathVariable Long firma_id) {
		bildirimiGuncelle.setWsuser(userFill.fill(firma_id));
		UetdsGenelIslemSonuc sonuc = serviceSetMethodsImpl.guncelleResponse(bildirimiGuncelle).getReturn();

		UetdsCompanies company = new UetdsCompanies();
		company.setId(firma_id);

		if (sonuc.getSonucKodu() == 0)
			connect.kargoGuncelle(bildirimiGuncelle, company);

		return sonuc;

	}

	@CrossOrigin("*")
	@RequestMapping("/tasimaSekli/{firma_id}")
	public UetdsEsyaParamTehlikeliMaddeTasimaSekliSonuc maddeTasimaSekliResponse(
			@RequestBody ParamTehlikeliMaddeTasimaSekli maddeTasimaSekli, @PathVariable Long firma_id) {
		maddeTasimaSekli.setWsuser(userFill.fill(firma_id));
		return pageInputMethodsImpl.maddeTasimaSekliResponse(maddeTasimaSekli).getReturn();
	}

	@CrossOrigin("*")
	@RequestMapping("/iptalTurleri/{firma_id}")
	public UetdsEsyaParamIptalTuruSonuc iptalTurleriResponse(@RequestBody IptalTurleri iptalTurleri,
			@PathVariable Long firma_id) {
		iptalTurleri.setWsuser(userFill.fill(firma_id));
		return pageInputMethodsImpl.iptalTurleriResponse(iptalTurleri).getReturn();
	}

	// Verilen Referans no'ya göre yük bilgisini dönüyor
	@CrossOrigin("*")
	@RequestMapping("/bildirimDetay/{firma_id}")
	public UetdsEsyaWsYukBildirimDetayiSonuc bildirimiDetayiResponse(@RequestBody YukBildirimiDetayi bildirimiDetayi,
			@PathVariable Long firma_id) {
		bildirimiDetayi.setWsuser(userFill.fill(firma_id));
		return serviceGetMethodsImpl.bildirimiDetayiResponse(bildirimiDetayi).getReturn();
	}

	@CrossOrigin("*")
	@RequestMapping("/bildirimIptal/{firma_id}")
	public UetdsGenelIslemSonuc bildirimiIptalEtResponse(@RequestBody YukBildirimiIptalEt yukBildirimiIptalEt,
			@PathVariable Long firma_id) {

		yukBildirimiIptalEt.setWsuser(userFill.fill(firma_id));

		CargoNotification cargo = cargoRepo.findByuetdsBildirimReferansNo(yukBildirimiIptalEt.getBildirimId());
		cargo.setYukDurum("iptal");

		UetdsGenelIslemSonuc sonuc = serviceGetMethodsImpl.bildirimiIptalEtResponse(yukBildirimiIptalEt).getReturn();
		if (sonuc.getSonucKodu() == 0)
			cargoRepo.save(cargo);

		return sonuc;
	}

	// Return Class'ı içinde liste halinde referans numaraları dönüyor
	@CrossOrigin("*")
	@RequestMapping("/bildirimListesi/{firma_id}")
	public UetdsEsyaWsBildirimListesiSonuc yukBildirimiListesiResponse(
			@RequestBody YukBildirimiListesi yukBildirimiListesi, @PathVariable Long firma_id) {
		yukBildirimiListesi.setWsuser(userFill.fill(firma_id));
		return serviceGetMethodsImpl.yukBildirimiListesiResponse(yukBildirimiListesi).getReturn();
	}

	@CrossOrigin("*")
	@RequestMapping("/bildirimDetayList/{firma_id}")
	public List<YukBildirimiDetayiResponse> bildirimiDetayiResponseList(
			@RequestBody List<YukBildirimiDetayi> bildirimiDetayiList, @PathVariable Long firma_id) {

		List<UetdsEsyaWsYukBildirimDetayiSonuc> returnList = new ArrayList<UetdsEsyaWsYukBildirimDetayiSonuc>();

		for (int i = 0; i < bildirimiDetayiList.size(); i++)
			bildirimiDetayiList.get(i).setWsuser(userFill.fill(firma_id));

		return serviceGetMethodsImpl.YukBildirimDetayiResponseList(bildirimiDetayiList);
	}

}
