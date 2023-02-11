package com.arma.uetds_boot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ulke_listesi")
public class UlkeListesi {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String kod;
	
	private String ulke_adi;

	public UlkeListesi( String kod, String ulke_adi) {
		super();
		this.kod = kod;
		this.ulke_adi = ulke_adi;
	}
	

	public UlkeListesi() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKod() {
		return kod;
	}

	public void setKod(String kod) {
		this.kod = kod;
	}

	public String getUlke_adi() {
		return ulke_adi;
	}

	public void setUlke_adi(String ulke_adi) {
		this.ulke_adi = ulke_adi;
	}
	
	
}
