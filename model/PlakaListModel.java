package com.arma.uetds_boot.model;

import java.math.BigInteger;

public class PlakaListModel {
	
	private BigInteger yukSayisi;
	
	private String plaka;

	public PlakaListModel(BigInteger yukSayisi, String plaka) {
		super();
		this.yukSayisi = yukSayisi;
		this.plaka = plaka;
	}

	public PlakaListModel() {
		super();
	}

	public BigInteger getYukSayisi() {
		return yukSayisi;
	}

	public void setYukSayisi(BigInteger yukSayisi) {
		this.yukSayisi = yukSayisi;
	}

	public String getPlaka() {
		return plaka;
	}

	public void setPlaka(String plaka) {
		this.plaka = plaka;
	}
	
	

}
