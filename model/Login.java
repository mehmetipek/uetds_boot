package com.arma.uetds_boot.model;

public class Login {
	
	private String kullaniciAdi;
	private String sifre;
	public Login(String kullaniciAdi, String sifre) {
		super();
		this.kullaniciAdi = kullaniciAdi;
		this.sifre = sifre;
	}
	public Login() {
		super();
	}
	public String getKullaniciAdi() {
		return kullaniciAdi;
	}
	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	
	

}
