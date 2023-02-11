package com.arma.uetds_boot.security.controller;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arma.uetds_boot.model.TopluKayitClass;
import com.arma.uetds_boot.model.UetdsCompanies;
import com.arma.uetds_boot.model.User;
import com.arma.uetds_boot.model.YolcuSeferBilgileriInput;
import com.arma.uetds_boot.model.Yolcu_GrupInput;
import com.arma.uetds_boot.model.Yolcu_PersonelInput;
import com.arma.uetds_boot.model.Yolcu_YolcuBilgileriInput;
import com.arma.uetds_boot.repository.YolcuSeferRepository;
import com.arma.uetds_boot.repository.Yolcu_GrupRepo;
import com.arma.uetds_boot.repository.Yolcu_PersonelRepository;
import com.arma.uetds_boot.repository.Yolcu_YolcuRepository;
import com.arma.uetds_boot.security.repository.UserRepository;
import com.arma.uetds_boot.service.DenemeConnective;
import com.arma.uetds_boot.service.UetdsYtsUser_Fill;
import com.arma.uetds_boot.soap.interfaces.YolcuGetMethods;
import com.arma.uetds_boot.yolcu.wsdl.AracMuayeneSorgula;
import com.arma.uetds_boot.yolcu.wsdl.AracMuayeneSorgulaResponse;
import com.arma.uetds_boot.yolcu.wsdl.PersonelEkle;
import com.arma.uetds_boot.yolcu.wsdl.PersonelEkleResponse;
import com.arma.uetds_boot.yolcu.wsdl.SeferDetayCiktisiAl;
import com.arma.uetds_boot.yolcu.wsdl.SeferDetayCiktisiAlResponse;
import com.arma.uetds_boot.yolcu.wsdl.SeferEkle;
import com.arma.uetds_boot.yolcu.wsdl.SeferEkleResponse;
import com.arma.uetds_boot.yolcu.wsdl.SeferGrupEkle;
import com.arma.uetds_boot.yolcu.wsdl.SeferGrupEkleResponse;
import com.arma.uetds_boot.yolcu.wsdl.SeferGuncelle;
import com.arma.uetds_boot.yolcu.wsdl.SeferGuncelleResponse;
import com.arma.uetds_boot.yolcu.wsdl.SeferIptal;
import com.arma.uetds_boot.yolcu.wsdl.SeferIptalResponse;
import com.arma.uetds_boot.yolcu.wsdl.UetdsAriziSeferPersonelBilgileriInput;
import com.arma.uetds_boot.yolcu.wsdl.UetdsAriziSeferYolcuBilgileriInput;
import com.arma.uetds_boot.yolcu.wsdl.UetdsYolcuSonuc;
import com.arma.uetds_boot.yolcu.wsdl.UetdsYtsUser;
import com.arma.uetds_boot.yolcu.wsdl.YolcuBildirimSorgula;
import com.arma.uetds_boot.yolcu.wsdl.YolcuBildirimSorgulaResponse;
import com.arma.uetds_boot.yolcu.wsdl.YolcuEkle;
import com.arma.uetds_boot.yolcu.wsdl.YolcuEkleCoklu;
import com.arma.uetds_boot.yolcu.wsdl.YolcuEkleCokluResponse;
import com.arma.uetds_boot.yolcu.wsdl.YolcuEkleResponse;
import com.arma.uetds_boot.yolcu.wsdl.YolcuIptal;
import com.arma.uetds_boot.yolcu.wsdl.YolcuIptalResponse;

@CrossOrigin("*")
@RestController
@RequestMapping("/denemey")
public class YolcuDenemeController {

	@Autowired
	@Qualifier("getYolcuClient")
	private YolcuGetMethods deneme;

	@Autowired
	private DenemeConnective connect;

	@Autowired
	private UetdsYtsUser_Fill userFill;

	@Autowired
	private YolcuSeferRepository seferRepo;

	@Autowired
	private Yolcu_YolcuRepository yolcuRepo;

	@Autowired
	private Yolcu_PersonelRepository personelRepo;

	@Autowired
	private Yolcu_GrupRepo grupRepo;

	@Autowired
	private UserRepository userRepo;

	@CrossOrigin
	@RequestMapping("/yolcu")
	private AracMuayeneSorgulaResponse bibak(@RequestBody AracMuayeneSorgula bilgiler) {
		return deneme.aracMuayeneSorgula(bilgiler);
	}

	@CrossOrigin("*")
	@RequestMapping("/yeniSeferEkle/{firma_id}")
	private TopluKayitClass TopluSave(@RequestBody TopluKayitClass ekle, @PathVariable Long firma_id) {

		TopluKayitClass response = new TopluKayitClass();
		YolcuDenemeController controller = this;
		SeferEkleResponse responseSefer = new SeferEkleResponse();
		Long seferId;
		Long grupId;
		// Sefer Kaydı
		responseSefer = controller.seferEkle(ekle.getSeferEkle(), firma_id);
		response.setSeferResponse(responseSefer);
		// Grup Kaydı ve Personel Kaydı
		if (response.getSeferResponse().getReturn().getSonucKodu() == 0) {
			// Eklenen Sefer id
			seferId = seferRepo.findByRefNofromId(response.getSeferResponse().getReturn().getUetdsSeferReferansNo());
			// Grup EKleme
			ekle.getGrupEkle()
					.setUetdsSeferReferansNo(response.getSeferResponse().getReturn().getUetdsSeferReferansNo());
			response.setGrupResponse(controller.grupEkle(ekle.getGrupEkle(), firma_id, seferId));
			// Çoklu Personel Ekleme
			List<UetdsAriziSeferPersonelBilgileriInput> personeller = new ArrayList<UetdsAriziSeferPersonelBilgileriInput>();
			if(ekle.getPersonelCoklu()!=null)
				personeller=ekle.getPersonelCoklu();
			
			if(ekle.getIds().size() > 0)
			{
				for (Long id : ekle.getIds()) {
					User user = userRepo.findById(id).get();
					UetdsAriziSeferPersonelBilgileriInput personel = new UetdsAriziSeferPersonelBilgileriInput();
					personel.setAdi(user.getName());
					personel.setAdres(user.getAdres());
					personel.setCinsiyet(user.getCinsiyet());
					personel.setSoyadi(user.getLast_name());
					personel.setTcKimlikPasaportNo(user.getTcno());
					personel.setTelefon(user.getTelno());
					personel.setTurKodu(user.getTurid().getTurKodu());
					personel.setUyrukUlke(user.getUyruk());
					personeller.add(personel);

				}
				response.setPersonelCokluResponse(controller.personelEkleExcell(personeller, firma_id, seferId));
			}
		} else {
			response.setHataMesaj("Sefer Kaydı Esnasında Hata Meydana Geldi !"
					+ response.getSeferResponse().getReturn().getSonucMesaji());
			return response;

		} // Yolcu Kaydı
		if (response.getGrupResponse().getReturn().getSonucKodu() == 0) {
			grupId = grupRepo.findByuetdsGrupRefNo(response.getGrupResponse().getReturn().getUetdsGrupRefNo()).getId();
			response.setYolcuCokluResponse(controller.yolcuEkleCoklu(ekle.getYolcuCoklu(), firma_id, grupId, seferId));
		} else {
			response.setHataMesaj("Grup Kaydı Esnasında Hata Meydana Geldi !"
					+ response.getGrupResponse().getReturn().getSonucMesaji());
			return response;
		}
		return response;

	}

	@CrossOrigin("*")
	@RequestMapping("/seferEkle/{firma_id}")
	private SeferEkleResponse seferEkle(@RequestBody SeferEkle ekle, @PathVariable Long firma_id) {
		ekle.setWsuser(userFill.fill_yolcu(firma_id));

		// GregorianCalender Trasnlate
		ekle.getAriziSeferBilgileriInput().setHareketTarihi(ekle.getAriziSeferBilgileriInput().getHareketTarihi());
		ekle.getAriziSeferBilgileriInput()
				.setSeferBitisTarihi(ekle.getAriziSeferBilgileriInput().getSeferBitisTarihi());

		System.out.println(ekle.getWsuser().getKullaniciAdi());
		SeferEkleResponse response = deneme.seferEkle(ekle);

		UetdsCompanies company = new UetdsCompanies(); // Local vt ye kayıt için company id içeren değişken
		company.setId(firma_id);

		if (response.getReturn().getSonucKodu() == 0)
			connect.yeniSeferEkle(ekle, company, response.getReturn().getUetdsSeferReferansNo());

		return response;

	}

	@CrossOrigin("*")
	@RequestMapping("/yolcuEkle/{firma_id}/{grup_id}/{sefer_id}")
	private YolcuEkleResponse yolcuEkle(@RequestBody YolcuEkle ekle, @PathVariable Long firma_id,
			@PathVariable Long grup_id, @PathVariable Long sefer_id) {
		ekle.setWsuser(userFill.fill_yolcu(firma_id));

		// Local vt ye kayıt için gerekli
		YolcuSeferBilgileriInput seferNo = new YolcuSeferBilgileriInput();
		seferNo.setUetdsSeferReferansNo(ekle.getUetdsSeferReferansNo());
		seferNo.setId(sefer_id);

		Yolcu_GrupInput grup = new Yolcu_GrupInput();
		grup.setId(grup_id);

		YolcuEkleResponse response = deneme.yolcuEkle(ekle);

		if (response.getReturn().getSonucKodu() == 0)
			connect.YeniYolcuEkle(ekle.getSeferYolcuBilgileriInput(), seferNo, grup,
					response.getReturn().getUetdsYolcuRefNo());

		return response;

	}

	@CrossOrigin("*")
	@RequestMapping("/yolcuEkleExcell/{firma_id}/{grup_id}/{sefer_id}")
	private List<YolcuEkleResponse> yolcuEkleCoklu(@RequestBody List<UetdsAriziSeferYolcuBilgileriInput> ekle,
			@PathVariable Long firma_id, @PathVariable Long grup_id, @PathVariable Long sefer_id) {

		Long refNo = seferRepo.findByIdChange(sefer_id);
		// Local vt ye kayıt için gerekli
		YolcuSeferBilgileriInput seferNo = new YolcuSeferBilgileriInput();

		List<YolcuEkleResponse> responseList = new ArrayList<YolcuEkleResponse>();
		Optional<Yolcu_GrupInput> grupRef = grupRepo.findById(grup_id);
		Yolcu_GrupInput grup = new Yolcu_GrupInput();
		grup.setId(grup_id);

		for (UetdsAriziSeferYolcuBilgileriInput bilgiler : ekle) {

			YolcuEkle yolcu = new YolcuEkle();

			bilgiler.setGrupId(Long.parseLong(grupRef.get().getUetdsGrupRefNo()));

			yolcu.setSeferYolcuBilgileriInput(bilgiler);
			yolcu.setUetdsSeferReferansNo(refNo);
			yolcu.setWsuser(userFill.fill_yolcu(firma_id));

			seferNo.setUetdsSeferReferansNo(yolcu.getUetdsSeferReferansNo());
			seferNo.setId(sefer_id);

			YolcuEkleResponse response = deneme.yolcuEkle(yolcu);
			responseList.add(response);

			if (response.getReturn().getSonucKodu() == 0)
				connect.YeniYolcuEkle(yolcu.getSeferYolcuBilgileriInput(), seferNo, grup,
						response.getReturn().getUetdsYolcuRefNo());

		}

		return responseList;

	}

	@CrossOrigin("*")
	@RequestMapping("/grupEkle/{firma_id}/{sefer_id}")
	private SeferGrupEkleResponse grupEkle(@RequestBody SeferGrupEkle ekle, @PathVariable Long firma_id,
			@PathVariable Long sefer_id) {
		ekle.setWsuser(userFill.fill_yolcu(firma_id));

		YolcuSeferBilgileriInput seferNo = new YolcuSeferBilgileriInput();
		seferNo.setUetdsSeferReferansNo(ekle.getUetdsSeferReferansNo());
		seferNo.setId(sefer_id);

		SeferGrupEkleResponse response = deneme.grupEkle(ekle);
		if (response.getReturn().getSonucKodu() == 0)
			connect.yeniGrupEkle(ekle, seferNo, response.getReturn().getUetdsGrupRefNo());

		return response;

	}

	@CrossOrigin("*")
	@RequestMapping("/personelEkle/{firma_id}/{sefer_id}")
	private PersonelEkleResponse personelEkle(@RequestBody PersonelEkle ekle, @PathVariable Long firma_id,
			@PathVariable Long sefer_id) {
		ekle.setWsuser(userFill.fill_yolcu(firma_id));

		// Local vt ye kayıt için gerekli
		YolcuSeferBilgileriInput seferNo = new YolcuSeferBilgileriInput();
		seferNo.setUetdsSeferReferansNo(ekle.getUetdsSeferReferansNo());
		seferNo.setId(sefer_id);

		PersonelEkleResponse response = deneme.personelEkle(ekle);

		if (response.getReturn().getSonucKodu() == 0)
			connect.yeniPersonelEkle(ekle, seferNo);

		return response;

	}

	@CrossOrigin("*")
	@RequestMapping("/personelEkleExcell/{firma_id}/{sefer_id}")
	private List<PersonelEkleResponse> personelEkleExcell(@RequestBody List<UetdsAriziSeferPersonelBilgileriInput> ekle,
			@PathVariable Long firma_id, @PathVariable Long sefer_id) {
		List<PersonelEkleResponse> responseList = new ArrayList<PersonelEkleResponse>();
		YolcuSeferBilgileriInput seferNo = new YolcuSeferBilgileriInput();
		Long seferId = seferRepo.findByIdChange(sefer_id);

		for (UetdsAriziSeferPersonelBilgileriInput one : ekle) {
			PersonelEkle personel = new PersonelEkle();

			personel.getSeferPersonelBilgileriInput().add(one);
			personel.setWsuser(userFill.fill_yolcu(firma_id));
			personel.setUetdsSeferReferansNo(seferId);

			seferNo.setUetdsSeferReferansNo(seferId);
			seferNo.setId(sefer_id);

			PersonelEkleResponse response = deneme.personelEkle(personel);
			responseList.add(response);

			if (response.getReturn().getSonucKodu() == 0)
				connect.yeniPersonelEkle(personel, seferNo);

		}

		return responseList;

	}

	@CrossOrigin("*")
	@RequestMapping("/seferListesi")
	private List<YolcuSeferBilgileriInput> seferListesi(@RequestBody UetdsCompanies firma_id) {
		return seferRepo.findBycompanieOrderByHareketTarihiDesc(firma_id);
	}

	@CrossOrigin("*")
	@RequestMapping("/yolcuListesi")
	private List<Yolcu_YolcuBilgileriInput> yolcuListesi(@RequestBody YolcuSeferBilgileriInput sefer_id) {
		return yolcuRepo.findBysefer(sefer_id);
	}

	@CrossOrigin("*")
	@RequestMapping("/getSeferId")
	private YolcuSeferBilgileriInput seferRefNo(@RequestBody YolcuSeferBilgileriInput refNo) {
		return seferRepo.findByuetdsSeferReferansNo(refNo.getUetdsSeferReferansNo());
	}

	@CrossOrigin("*")
	@RequestMapping("/getGrupId")
	private Yolcu_GrupInput grupRefNo(@RequestBody Yolcu_GrupInput refNo) {
		return grupRepo.findByuetdsGrupRefNo(refNo.getUetdsGrupRefNo());
	}

	@CrossOrigin("*")
	@RequestMapping("/getByFirmaId")
	private List<YolcuSeferBilgileriInput> grupRefNo(@RequestBody UetdsCompanies refNo) {
		return seferRepo.findByFirmaId(refNo.getId());
	}

	@CrossOrigin("*")
	@RequestMapping("/seferIptal/{firma_id}")
	private SeferIptalResponse seferIptal(@RequestBody SeferIptal iptal, @PathVariable Long firma_id) {
		iptal.setWsuser(userFill.fill_yolcu(firma_id));
		YolcuSeferBilgileriInput seferBilgisi = seferRepo.findByuetdsSeferReferansNo(iptal.getUetdsSeferReferansNo());
		SeferIptalResponse response = deneme.seferIptal(iptal);
		if (response.getReturn().getSonucKodu() == 0) {
			seferBilgisi.setDurum("Iptal");
			seferRepo.save(seferBilgisi);
		}

		return response;
	}

	@CrossOrigin("*")
	@RequestMapping("/yolcuSorgula/{firma_id}")
	private YolcuBildirimSorgulaResponse bildirimSorgu(@RequestBody YolcuBildirimSorgula sorgula,
			@PathVariable Long firma_id) {
		sorgula.setWsuser(userFill.fill_yolcu(firma_id));
		return deneme.bildirimSorgula(sorgula);
	}

	@CrossOrigin("*")
	@RequestMapping("/yolcuIptal/{firma_id}/{yolcu_id}")
	private YolcuIptalResponse seferIptal(@RequestBody YolcuIptal iptal, @PathVariable Long firma_id,
			@PathVariable Long yolcu_id) {
		iptal.setWsuser(userFill.fill_yolcu(firma_id));
		Optional<Yolcu_YolcuBilgileriInput> yolcu = yolcuRepo.findById(yolcu_id);
		YolcuIptalResponse response = deneme.yolcuIptal(iptal);
		if (response.getReturn().getSonucKodu() == 0) {
			yolcu.get().setDurum("Iptal");
			yolcuRepo.save(yolcu.get());
		}
		return response;

	}

	@CrossOrigin("*")
	@RequestMapping("/seferGuncelle/{sefer_id}")
	private SeferGuncelleResponse seferGuncelle(@RequestBody SeferGuncelle guncelle, @PathVariable Long sefer_id) {
		UetdsCompanies company = new UetdsCompanies();
		company.setId(seferRepo.findBySeferId(sefer_id));

		SeferGuncelleResponse response = deneme.seferGuncelle(guncelle);

		if (response.getReturn().getSonucKodu() == 0)
			connect.seferGuncelle(guncelle, company, guncelle.getGuncellenecekSeferReferansNo(), sefer_id);

		return response;
	}

	@CrossOrigin("*")
	@RequestMapping("/LikeSeferNo/{firma_id}")
	private List<YolcuSeferBilgileriInput> seferLike(@RequestBody YolcuSeferBilgileriInput seferNo,
			@PathVariable Long firma_id) {
		return seferRepo.findByLikeSefer(seferNo.getFirmaSeferNo(), firma_id);
	}

	@CrossOrigin("*")
	@RequestMapping("/LikePlaka/{firma_id}")
	private List<YolcuSeferBilgileriInput> plakaLike(@RequestBody YolcuSeferBilgileriInput plaka,
			@PathVariable Long firma_id) {
		return seferRepo.findByLikePlaka(plaka.getAracPlaka(), firma_id);
	}

	// sefere göre grup getiren metod
	@CrossOrigin("*")
	@RequestMapping("/getGrupList")
	private List<Yolcu_GrupInput> getListGrup(@RequestBody YolcuSeferBilgileriInput seferId) {
		return grupRepo.findBySeferNo(seferId.getId());
	}

	// sefere göre personel getiren metot
	@CrossOrigin("*")
	@RequestMapping("/getPersonelList")
	private List<Yolcu_PersonelInput> getListPersonel(@RequestBody Yolcu_PersonelInput seferId) {
		return personelRepo.findByrefNo(seferId.getId());
	}

	@CrossOrigin("*")
	@RequestMapping("/seferDetayCikti/{firma_id}")
	private SeferDetayCiktisiAlResponse getPdf(@RequestBody SeferDetayCiktisiAl al, @PathVariable Long firma_id) {
		al.setWsuser(userFill.fill_yolcu(firma_id));
		return deneme.cikti(al);
	}

}
