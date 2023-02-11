package com.arma.uetds_boot.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.datatype.XMLGregorianCalendar;

@Entity
@Table(name = "yolcu_sefer_bilgileri")
public class YolcuSeferBilgileriInput {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@ManyToOne
	@JoinColumn(name = "yolcu_cargo_not")
	private UetdsCompanies companie;

	private String aracPlaka;
	private String seferAciklama;

	private String hareketTarihi;

	private String hareketSaati;
	private String aracTelefonu;

	private String firmaSeferNo;

	private String seferBitisTarihi;

	private String seferBitisSaati;
	
	private String durum;

	private Long uetdsSeferReferansNo;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "sefer")
	private List<Yolcu_YolcuBilgileriInput> ref_id;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "refNo")
	private List<Yolcu_PersonelInput> referans_id;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "seferNo")
	private List<Yolcu_GrupInput> sefer_id;

	

	public YolcuSeferBilgileriInput(Long id, UetdsCompanies companie, String aracPlaka, String seferAciklama,
			String hareketTarihi, String hareketSaati, String aracTelefonu, String firmaSeferNo,
			String seferBitisTarihi, String seferBitisSaati, String durum, Long uetdsSeferReferansNo) {
		super();
		Id = id;
		this.companie = companie;
		this.aracPlaka = aracPlaka;
		this.seferAciklama = seferAciklama;
		this.hareketTarihi = hareketTarihi;
		this.hareketSaati = hareketSaati;
		this.aracTelefonu = aracTelefonu;
		this.firmaSeferNo = firmaSeferNo;
		this.seferBitisTarihi = seferBitisTarihi;
		this.seferBitisSaati = seferBitisSaati;
		this.durum = durum;
		this.uetdsSeferReferansNo = uetdsSeferReferansNo;
	}

	

	public YolcuSeferBilgileriInput(UetdsCompanies companie, String aracPlaka, String seferAciklama,
			String hareketTarihi, String hareketSaati, String aracTelefonu, String firmaSeferNo,
			String seferBitisTarihi, String seferBitisSaati, String durum, Long uetdsSeferReferansNo) {
		super();
		this.companie = companie;
		this.aracPlaka = aracPlaka;
		this.seferAciklama = seferAciklama;
		this.hareketTarihi = hareketTarihi;
		this.hareketSaati = hareketSaati;
		this.aracTelefonu = aracTelefonu;
		this.firmaSeferNo = firmaSeferNo;
		this.seferBitisTarihi = seferBitisTarihi;
		this.seferBitisSaati = seferBitisSaati;
		this.durum = durum;
		this.uetdsSeferReferansNo = uetdsSeferReferansNo;
	}



	public YolcuSeferBilgileriInput() {
		super();
	}

	public String getAracPlaka() {
		return aracPlaka;
	}

	public void setAracPlaka(String aracPlaka) {
		this.aracPlaka = aracPlaka;
	}

	public String getSeferAciklama() {
		return seferAciklama;
	}

	public void setSeferAciklama(String seferAciklama) {
		this.seferAciklama = seferAciklama;
	}

	
	public String getHareketTarihi() {
		return hareketTarihi;
	}

	public String getHareketSaati() {
		return hareketSaati;
	}

	public void setHareketSaati(String hareketSaati) {
		this.hareketSaati = hareketSaati;
	}

	public String getAracTelefonu() {
		return aracTelefonu;
	}

	public void setAracTelefonu(String aracTelefonu) {
		this.aracTelefonu = aracTelefonu;
	}

	public String getFirmaSeferNo() {
		return firmaSeferNo;
	}

	public void setFirmaSeferNo(String firmaSeferNo) {
		this.firmaSeferNo = firmaSeferNo;
	}
	

	public String getSeferBitisTarihi() {
		return seferBitisTarihi;
	}

	public void setSeferBitisTarihi(String seferBitisTarihi) {
		this.seferBitisTarihi = seferBitisTarihi;
	}

	public void setHareketTarihi(String hareketTarihi) {
		this.hareketTarihi = hareketTarihi;
	}

	public String getSeferBitisSaati() {
		return seferBitisSaati;
	}

	public void setSeferBitisSaati(String seferBitisSaati) {
		this.seferBitisSaati = seferBitisSaati;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}


	public UetdsCompanies getCompanie() {
		return companie;
	}

	public void setCompanie(UetdsCompanies companie) {
		this.companie = companie;
	}

	public Long getUetdsSeferReferansNo() {
		return uetdsSeferReferansNo;
	}

	public void setUetdsSeferReferansNo(Long uetdsSeferReferansNo) {
		this.uetdsSeferReferansNo = uetdsSeferReferansNo;
	}



	public String getDurum() {
		return durum;
	}



	public void setDurum(String durum) {
		this.durum = durum;
	}
	
	
	
	

}
