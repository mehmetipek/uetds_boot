package com.arma.uetds_boot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ilce_listesi")
public class IlceListesi {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String kodu;

	@Column(name = "il_kod")
	private String ilkod;
	
	private String ad;
	
	@Column(name = "il_adi")
	private String iladi;

	
	
	public IlceListesi() {
		super();
	}

	public IlceListesi(String kodu, String ilkod, String ad, String iladi) {
		super();
		this.kodu = kodu;
		this.ilkod = ilkod;
		this.ad = ad;
		this.iladi = iladi;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getKodu() {
		return kodu;
	}

	public void setKodu(String kodu) {
		this.kodu = kodu;
	}
	
	public String getIlkod() {
		return ilkod;
	}


	public void setIlkod(String ilkod) {
		this.ilkod = ilkod;
	}


	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}





	public String getIladi() {
		return iladi;
	}





	public void setIladi(String iladi) {
		this.iladi = iladi;
	}
	
	
	
}
