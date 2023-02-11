package com.arma.uetds_boot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "personel_input")
public class Yolcu_PersonelInput {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne
	@JoinColumn(name = "referans_id")
	private YolcuSeferBilgileriInput refNo;
	
	private int turKodu;
    
    private String uyrukUlke;
    
    private String tcKimlikPasaportNo;
    
    private String cinsiyet;
    
    private String adi;
    
    private String soyadi;
    private String telefon;
    private String adres;
    private String durum;
    
    
	public Yolcu_PersonelInput() {
		super();
	}
	
	public Yolcu_PersonelInput(Long id, YolcuSeferBilgileriInput refNo, int turKodu, String uyrukUlke,
			String tcKimlikPasaportNo, String cinsiyet, String adi, String soyadi, String telefon, String adres,
			String durum) {
		super();
		Id = id;
		this.refNo = refNo;
		this.turKodu = turKodu;
		this.uyrukUlke = uyrukUlke;
		this.tcKimlikPasaportNo = tcKimlikPasaportNo;
		this.cinsiyet = cinsiyet;
		this.adi = adi;
		this.soyadi = soyadi;
		this.telefon = telefon;
		this.adres = adres;
		this.durum = durum;
	}

	
	public Yolcu_PersonelInput(YolcuSeferBilgileriInput refNo, int turKodu, String uyrukUlke,
			String tcKimlikPasaportNo, String cinsiyet, String adi, String soyadi, String telefon, String adres,
			String durum) {
		super();
		this.refNo = refNo;
		this.turKodu = turKodu;
		this.uyrukUlke = uyrukUlke;
		this.tcKimlikPasaportNo = tcKimlikPasaportNo;
		this.cinsiyet = cinsiyet;
		this.adi = adi;
		this.soyadi = soyadi;
		this.telefon = telefon;
		this.adres = adres;
		this.durum = durum;
	}

	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	
	public YolcuSeferBilgileriInput getRefNo() {
		return refNo;
	}

	public void setRefNo(YolcuSeferBilgileriInput refNo) {
		this.refNo = refNo;
	}

	public int getTurKodu() {
		return turKodu;
	}
	public void setTurKodu(int turKodu) {
		this.turKodu = turKodu;
	}
	public String getUyrukUlke() {
		return uyrukUlke;
	}
	public void setUyrukUlke(String uyrukUlke) {
		this.uyrukUlke = uyrukUlke;
	}
	public String getTcKimlikPasaportNo() {
		return tcKimlikPasaportNo;
	}
	public void setTcKimlikPasaportNo(String tcKimlikPasaportNo) {
		this.tcKimlikPasaportNo = tcKimlikPasaportNo;
	}
	public String getCinsiyet() {
		return cinsiyet;
	}
	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	public String getSoyadi() {
		return soyadi;
	}
	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getDurum() {
		return durum;
	}

	public void setDurum(String durum) {
		this.durum = durum;
	}
	
	
    
    

}
