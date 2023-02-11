package com.arma.uetds_boot.model;

import java.util.List;

import com.arma.uetds_boot.yolcu.wsdl.PersonelEkle;
import com.arma.uetds_boot.yolcu.wsdl.PersonelEkleResponse;
import com.arma.uetds_boot.yolcu.wsdl.SeferEkle;
import com.arma.uetds_boot.yolcu.wsdl.SeferEkleResponse;
import com.arma.uetds_boot.yolcu.wsdl.SeferGrupEkle;
import com.arma.uetds_boot.yolcu.wsdl.SeferGrupEkleResponse;
import com.arma.uetds_boot.yolcu.wsdl.UetdsAriziSeferPersonelBilgileriInput;
import com.arma.uetds_boot.yolcu.wsdl.UetdsAriziSeferYolcuBilgileriInput;
import com.arma.uetds_boot.yolcu.wsdl.YolcuEkle;
import com.arma.uetds_boot.yolcu.wsdl.YolcuEkleResponse;

public class TopluKayitClass {

	private SeferEkle seferEkle;
	private SeferGrupEkle grupEkle;
	private YolcuEkle yolcuEkle;
	private PersonelEkle personelEkle;
	private List<UetdsAriziSeferYolcuBilgileriInput> yolcuCoklu;
	private List<UetdsAriziSeferPersonelBilgileriInput> personelCoklu;

	private SeferEkleResponse seferResponse;
	private SeferGrupEkleResponse grupResponse;
	private YolcuEkleResponse yolcuResponse;
	private PersonelEkleResponse personelResponse;
	private List<YolcuEkleResponse> yolcuCokluResponse;
	private List<PersonelEkleResponse> personelCokluResponse;
	private List<Long> ids;

	private String hataMesaj;

	public TopluKayitClass() {
		super();
	}

	public TopluKayitClass(SeferEkleResponse seferResponse, SeferGrupEkleResponse grupResponse,
			YolcuEkleResponse yolcuResponse, PersonelEkleResponse personelResponse,
			List<YolcuEkleResponse> yolcuCokluResponse, List<PersonelEkleResponse> personelCokluResponse) {
		super();
		this.seferResponse = seferResponse;
		this.grupResponse = grupResponse;
		this.yolcuResponse = yolcuResponse;
		this.personelResponse = personelResponse;
		this.yolcuCokluResponse = yolcuCokluResponse;
		this.personelCokluResponse = personelCokluResponse;
	}

	public TopluKayitClass(SeferEkle seferEkle, SeferGrupEkle grupEkle, YolcuEkle yolcuEkle, PersonelEkle personelEkle,
			List<UetdsAriziSeferYolcuBilgileriInput> yolcuCoklu,
			List<UetdsAriziSeferPersonelBilgileriInput> personelCoklu) {
		super();
		this.seferEkle = seferEkle;
		this.grupEkle = grupEkle;
		this.yolcuEkle = yolcuEkle;
		this.personelEkle = personelEkle;
		this.yolcuCoklu = yolcuCoklu;
		this.personelCoklu = personelCoklu;
	}

	public TopluKayitClass(SeferEkle seferEkle, SeferGrupEkle grupEkle, YolcuEkle yolcuEkle, PersonelEkle personelEkle,
			List<UetdsAriziSeferYolcuBilgileriInput> yolcuCoklu,
			List<UetdsAriziSeferPersonelBilgileriInput> personelCoklu, SeferEkleResponse seferResponse,
			SeferGrupEkleResponse grupResponse, YolcuEkleResponse yolcuResponse, PersonelEkleResponse personelResponse,
			List<YolcuEkleResponse> yolcuCokluResponse, List<PersonelEkleResponse> personelCokluResponse) {
		super();
		this.seferEkle = seferEkle;
		this.grupEkle = grupEkle;
		this.yolcuEkle = yolcuEkle;
		this.personelEkle = personelEkle;
		this.yolcuCoklu = yolcuCoklu;
		this.personelCoklu = personelCoklu;
		this.seferResponse = seferResponse;
		this.grupResponse = grupResponse;
		this.yolcuResponse = yolcuResponse;
		this.personelResponse = personelResponse;
		this.yolcuCokluResponse = yolcuCokluResponse;
		this.personelCokluResponse = personelCokluResponse;
	}

	public SeferEkle getSeferEkle() {
		return seferEkle;
	}

	public void setSeferEkle(SeferEkle seferEkle) {
		this.seferEkle = seferEkle;
	}

	public SeferGrupEkle getGrupEkle() {
		return grupEkle;
	}

	public void setGrupEkle(SeferGrupEkle grupEkle) {
		this.grupEkle = grupEkle;
	}

	public YolcuEkle getYolcuEkle() {
		return yolcuEkle;
	}

	public void setYolcuEkle(YolcuEkle yolcuEkle) {
		this.yolcuEkle = yolcuEkle;
	}

	public PersonelEkle getPersonelEkle() {
		return personelEkle;
	}

	public void setPersonelEkle(PersonelEkle personelEkle) {
		this.personelEkle = personelEkle;
	}

	public SeferEkleResponse getSeferResponse() {
		return seferResponse;
	}

	public void setSeferResponse(SeferEkleResponse seferResponse) {
		this.seferResponse = seferResponse;
	}

	public SeferGrupEkleResponse getGrupResponse() {
		return grupResponse;
	}

	public void setGrupResponse(SeferGrupEkleResponse grupResponse) {
		this.grupResponse = grupResponse;
	}

	public YolcuEkleResponse getYolcuResponse() {
		return yolcuResponse;
	}

	public void setYolcuResponse(YolcuEkleResponse yolcuResponse) {
		this.yolcuResponse = yolcuResponse;
	}

	public PersonelEkleResponse getPersonelResponse() {
		return personelResponse;
	}

	public void setPersonelResponse(PersonelEkleResponse personelResponse) {
		this.personelResponse = personelResponse;
	}

	public List<UetdsAriziSeferYolcuBilgileriInput> getYolcuCoklu() {
		return yolcuCoklu;
	}

	public void setYolcuCoklu(List<UetdsAriziSeferYolcuBilgileriInput> yolcuCoklu) {
		this.yolcuCoklu = yolcuCoklu;
	}

	public List<YolcuEkleResponse> getYolcuCokluResponse() {
		return yolcuCokluResponse;
	}

	public void setYolcuCokluResponse(List<YolcuEkleResponse> yolcuCokluResponse) {
		this.yolcuCokluResponse = yolcuCokluResponse;
	}

	public List<UetdsAriziSeferPersonelBilgileriInput> getPersonelCoklu() {
		return personelCoklu;
	}

	public void setPersonelCoklu(List<UetdsAriziSeferPersonelBilgileriInput> personelCoklu) {
		this.personelCoklu = personelCoklu;
	}

	public List<PersonelEkleResponse> getPersonelCokluResponse() {
		return personelCokluResponse;
	}

	public void setPersonelCokluResponse(List<PersonelEkleResponse> personelCokluResponse) {
		this.personelCokluResponse = personelCokluResponse;
	}

	public String getHataMesaj() {
		return hataMesaj;
	}

	public void setHataMesaj(String hataMesaj) {
		this.hataMesaj = hataMesaj;
	}

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

}
