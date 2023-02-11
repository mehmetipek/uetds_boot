package com.arma.uetds_boot.implement;

import javax.xml.bind.JAXBElement;

import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.arma.uetds_boot.soap.interfaces.YolcuGetMethods;
import com.arma.uetds_boot.yolcu.wsdl.AracMuayeneSorgula;
import com.arma.uetds_boot.yolcu.wsdl.AracMuayeneSorgulaResponse;
import com.arma.uetds_boot.yolcu.wsdl.ObjectFactory;
import com.arma.uetds_boot.yolcu.wsdl.PersonelEkle;
import com.arma.uetds_boot.yolcu.wsdl.PersonelEkleResponse;
import com.arma.uetds_boot.yolcu.wsdl.SeferAktif;
import com.arma.uetds_boot.yolcu.wsdl.SeferAktifResponse;
import com.arma.uetds_boot.yolcu.wsdl.SeferDetayCiktisiAl;
import com.arma.uetds_boot.yolcu.wsdl.SeferDetayCiktisiAlResponse;
import com.arma.uetds_boot.yolcu.wsdl.SeferEkle;
import com.arma.uetds_boot.yolcu.wsdl.SeferEkleResponse;
import com.arma.uetds_boot.yolcu.wsdl.SeferGrupEkle;
import com.arma.uetds_boot.yolcu.wsdl.SeferGrupEkleResponse;
import com.arma.uetds_boot.yolcu.wsdl.SeferGrupGuncelle;
import com.arma.uetds_boot.yolcu.wsdl.SeferGrupGuncelleResponse;
import com.arma.uetds_boot.yolcu.wsdl.SeferGrupIptal;
import com.arma.uetds_boot.yolcu.wsdl.SeferGrupIptalResponse;
import com.arma.uetds_boot.yolcu.wsdl.SeferGuncelle;
import com.arma.uetds_boot.yolcu.wsdl.SeferGuncelleResponse;
import com.arma.uetds_boot.yolcu.wsdl.SeferIptal;
import com.arma.uetds_boot.yolcu.wsdl.SeferIptalResponse;
import com.arma.uetds_boot.yolcu.wsdl.SeferPlakaDegistir;
import com.arma.uetds_boot.yolcu.wsdl.SeferPlakaDegistirResponse;
import com.arma.uetds_boot.yolcu.wsdl.YolcuBagajEkle;
import com.arma.uetds_boot.yolcu.wsdl.YolcuBagajEkleResponse;
import com.arma.uetds_boot.yolcu.wsdl.YolcuBagajIptal;
import com.arma.uetds_boot.yolcu.wsdl.YolcuBagajIptalResponse;
import com.arma.uetds_boot.yolcu.wsdl.YolcuBildirimSorgula;
import com.arma.uetds_boot.yolcu.wsdl.YolcuBildirimSorgulaResponse;
import com.arma.uetds_boot.yolcu.wsdl.YolcuEkle;
import com.arma.uetds_boot.yolcu.wsdl.YolcuEkleCoklu;
import com.arma.uetds_boot.yolcu.wsdl.YolcuEkleCokluResponse;
import com.arma.uetds_boot.yolcu.wsdl.YolcuEkleResponse;
import com.arma.uetds_boot.yolcu.wsdl.YolcuGelmeyenBildir;
import com.arma.uetds_boot.yolcu.wsdl.YolcuGelmeyenBildirResponse;
import com.arma.uetds_boot.yolcu.wsdl.YolcuIptal;
import com.arma.uetds_boot.yolcu.wsdl.YolcuIptalResponse;

@Component
public class YolcuGetMethodsImpl extends WebServiceGatewaySupport implements YolcuGetMethods {

	private ObjectFactory factory = new ObjectFactory();

	@SuppressWarnings("unchecked")
	@Override
	public AracMuayeneSorgulaResponse aracMuayeneSorgula(AracMuayeneSorgula sorgula) {

		JAXBElement<?> request = null;
		JAXBElement<?> response = null;

		AracMuayeneSorgula muayene = factory.createAracMuayeneSorgula();
		muayene = sorgula;
		request = factory.createAracMuayeneSorgula(muayene);
		response = (JAXBElement<AracMuayeneSorgulaResponse>) getWebServiceTemplate().marshalSendAndReceive(request);
		return (AracMuayeneSorgulaResponse) response.getValue();

	}

	@SuppressWarnings("unchecked")
	@Override
	public SeferEkleResponse seferEkle(SeferEkle ekle) {
		JAXBElement<?> request = null;
		JAXBElement<?> response = null;

		SeferEkle sefer = factory.createSeferEkle();
		sefer = ekle;

		request = factory.createSeferEkle(sefer);
		response = (JAXBElement<SeferEkleResponse>) getWebServiceTemplate().marshalSendAndReceive(request);
		return (SeferEkleResponse) response.getValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public YolcuEkleResponse yolcuEkle(YolcuEkle ekle) {
		JAXBElement<?> request = null;
		JAXBElement<?> response = null;

		YolcuEkle yolcu = factory.createYolcuEkle();
		yolcu = ekle;

		request = factory.createYolcuEkle(yolcu);
		response = (JAXBElement<YolcuEkleResponse>) getWebServiceTemplate().marshalSendAndReceive(request);
		return (YolcuEkleResponse) response.getValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public SeferGrupEkleResponse grupEkle(SeferGrupEkle ekle) {
		JAXBElement<?> request = null;
		JAXBElement<?> response = null;

		SeferGrupEkle grup = factory.createSeferGrupEkle();
		grup = ekle;
		request = factory.createSeferGrupEkle(grup);
		response = (JAXBElement<SeferGrupEkleResponse>) getWebServiceTemplate().marshalSendAndReceive(request);
		return (SeferGrupEkleResponse) response.getValue();

	}

	@SuppressWarnings("unchecked")
	@Override
	public PersonelEkleResponse personelEkle(PersonelEkle ekle) {
		JAXBElement<?> request = null;
		JAXBElement<?> response = null;

		PersonelEkle personel = factory.createPersonelEkle();
		personel = ekle;
		request = factory.createPersonelEkle(personel);
		response = (JAXBElement<PersonelEkleResponse>) getWebServiceTemplate().marshalSendAndReceive(request);
		return (PersonelEkleResponse) response.getValue();
	}

	@Override
	public YolcuEkleCokluResponse cokluEkle(YolcuEkleCoklu ekle) {
		JAXBElement<?> request = null;
		JAXBElement<?> response = null;

		YolcuEkleCoklu yolcu = factory.createYolcuEkleCoklu();
		yolcu = ekle;
		request = factory.createYolcuEkleCoklu(yolcu);
		response = (JAXBElement<?>) getWebServiceTemplate().marshalSendAndReceive(request);
		return (YolcuEkleCokluResponse) response.getValue();

	}

	@Override
	public SeferIptalResponse seferIptal(SeferIptal iptal) {
		// TODO Auto-generated method stub

		JAXBElement<?> request = null;
		JAXBElement<?> response = null;

		request = factory.createSeferIptal(iptal);
		response = (JAXBElement<SeferIptalResponse>) getWebServiceTemplate().marshalSendAndReceive(request);
		return (SeferIptalResponse) response.getValue();
	}

	@Override
	public YolcuIptalResponse yolcuIptal(YolcuIptal iptal) {
		// TODO Auto-generated method stub
		JAXBElement<?> request = null;
		JAXBElement<?> response = null;

		request = factory.createYolcuIptal(iptal);
		response = (JAXBElement<YolcuIptalResponse>) getWebServiceTemplate().marshalSendAndReceive(request);
		return (YolcuIptalResponse) response.getValue();
	}

	@Override
	public YolcuBagajEkleResponse bagajEkle(YolcuBagajEkle ekle) {
		// TODO Auto-generated method stub
		JAXBElement<?> request = null;
		JAXBElement<?> response = null;

		request = factory.createYolcuBagajEkle(ekle);
		response = (JAXBElement<YolcuBagajEkleResponse>) getWebServiceTemplate().marshalSendAndReceive(request);
		return (YolcuBagajEkleResponse) response.getValue();
	}

	@Override
	public YolcuBagajIptalResponse bagajIptal(YolcuBagajIptal iptal) {
		// TODO Auto-generated method stub
		JAXBElement<?> request = null;
		JAXBElement<?> response = null;

		request = factory.createYolcuBagajIptal(iptal);
		response = (JAXBElement<YolcuBagajIptalResponse>) getWebServiceTemplate().marshalSendAndReceive(request);
		return (YolcuBagajIptalResponse) response.getValue();
	}

	@Override
	public YolcuGelmeyenBildirResponse gelmeyenBildir(YolcuGelmeyenBildir bildir) {
		// TODO Auto-generated method stub
		JAXBElement<?> request = null;
		JAXBElement<?> response = null;
		request = factory.createYolcuGelmeyenBildir(bildir);
		response = (JAXBElement<YolcuGelmeyenBildirResponse>) getWebServiceTemplate().marshalSendAndReceive(request);
		return (YolcuGelmeyenBildirResponse) response.getValue();
	}

	@Override
	public YolcuBildirimSorgulaResponse bildirimSorgula(YolcuBildirimSorgula sorgula) {
		// TODO Auto-generated method stub
		JAXBElement<?> request = null;
		JAXBElement<?> response = null;

		request = factory.createYolcuBildirimSorgula(sorgula);
		response = (JAXBElement<YolcuBildirimSorgulaResponse>) getWebServiceTemplate().marshalSendAndReceive(request);
		return (YolcuBildirimSorgulaResponse) response.getValue();
	}

	@Override
	public SeferGrupIptalResponse grupIptal(SeferGrupIptal iptal) {
		// TODO Auto-generated method stub
		JAXBElement<?> request = null;
		JAXBElement<?> response = null;

		request = factory.createSeferGrupIptal(iptal);
		response = (JAXBElement<SeferGrupIptalResponse>) getWebServiceTemplate().marshalSendAndReceive(request);

		return (SeferGrupIptalResponse) response.getValue();
	}

	@Override
	public SeferPlakaDegistirResponse plakaDegistir(SeferPlakaDegistir degistir) {
		// TODO Auto-generated method stub
		JAXBElement<?> request = null;
		JAXBElement<?> response = null;

		request = factory.createSeferPlakaDegistir(degistir);
		response = (JAXBElement<SeferPlakaDegistirResponse>) getWebServiceTemplate().marshalSendAndReceive(request);
		return (SeferPlakaDegistirResponse) response.getValue();
	}

	@Override
	public SeferGuncelleResponse seferGuncelle(SeferGuncelle guncelle) {
		// TODO Auto-generated method stub
		JAXBElement<?> request = null;
		JAXBElement<?> response = null;

		request = factory.createSeferGuncelle(guncelle);
		response = (JAXBElement<SeferGuncelleResponse>) getWebServiceTemplate().marshalSendAndReceive(request);

		return (SeferGuncelleResponse) response.getValue();
	}

	@Override
	public SeferGrupGuncelleResponse grupGuncelle(SeferGrupGuncelle guncelle) {
		// TODO Auto-generated method stub
		JAXBElement<?> request = null;
		JAXBElement<?> response = null;
		request = factory.createSeferGrupGuncelle(guncelle);
		response = (JAXBElement<SeferGrupGuncelleResponse>) getWebServiceTemplate().marshalSendAndReceive(request);
		return (SeferGrupGuncelleResponse) response.getValue();
	}

	@Override
	public SeferDetayCiktisiAlResponse detay(SeferDetayCiktisiAl detay) {
		// TODO Auto-generated method stub
		JAXBElement<?> request = null;
		JAXBElement<?> response = null;

		request = factory.createSeferDetayCiktisiAl(detay);
		response = (JAXBElement<SeferDetayCiktisiAlResponse>) getWebServiceTemplate().marshalSendAndReceive(request);
		return (SeferDetayCiktisiAlResponse) response.getValue();
	}

	@Override
	public SeferAktifResponse aktif(SeferAktif aktif) {
		// TODO Auto-generated method stub
		JAXBElement<?> request = null;
		JAXBElement<?> response = null;

		request = factory.createSeferAktif(aktif);
		response = (JAXBElement<SeferAktifResponse>) getWebServiceTemplate().marshalSendAndReceive(request);
		return (SeferAktifResponse) response.getValue();
	}

	@Override
	public SeferDetayCiktisiAlResponse cikti(SeferDetayCiktisiAl al) {
		JAXBElement<?> request = null;
		JAXBElement<?> response = null;
		
		request=factory.createSeferDetayCiktisiAl(al);
		response=(JAXBElement<SeferDetayCiktisiAlResponse>) getWebServiceTemplate().marshalSendAndReceive(request);
		return (SeferDetayCiktisiAlResponse) response.getValue();
	}

}
