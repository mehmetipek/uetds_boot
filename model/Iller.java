package com.arma.uetds_boot.model;

public class Iller {
	
	private  String il_adi;
	
	private String il_kod;

	public Iller(String il_adi, String il_kod) {
		super();
		this.il_adi = il_adi;
		this.il_kod = il_kod;
	}

	public Iller() {
		super();
	}

	public String getIl_adi() {
		return il_adi;
	}

	public void setIl_adi(String il_adi) {
		this.il_adi = il_adi;
	}

	public String getIl_kod() {
		return il_kod;
	}

	public void setIl_kod(String il_kod) {
		this.il_kod = il_kod;
	}
	
	

}
