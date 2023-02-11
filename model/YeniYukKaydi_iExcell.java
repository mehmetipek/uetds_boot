package com.arma.uetds_boot.model;

import javax.xml.bind.annotation.XmlElement;

import com.arma.uetds_boot.wsdl.WsUetdsEsyaAracBilgileriInput;
import com.arma.uetds_boot.wsdl.WsUetdsEsyaYukBilgileriInput;

public class YeniYukKaydi_iExcell extends WsUetdsEsyaYukBilgileriInput {
	//Araç Bilgileri
	protected String plaka1;
    protected String plaka2;
    protected String sofor1TcNo;
    protected String sofor2TcNo;
    protected String tasimaTuruKodu;
    
   
    //Yuk Bilgileri(List)
    protected String gonderenVergiNo;
    protected String gonderenUnvan;
    protected String aliciVergiNo;
    protected String aliciUnvan;
    protected String yuklemeUlkeKodu;
    protected String yuklemeIlMernisKodu;
    protected String yuklemeIlceMernisKodu;	
    protected String bosaltmaUlkeKodu;
    protected String bosaltmaIlMernisKodu;
    protected String bosaltmaIlceMernisKodu;
    protected String yuklemeTarihi;
    protected String yuklemeSaati;
    protected String bosaltmaTarihi;
    protected String bosaltmaSaati;
    protected String yukCinsId;
    protected String yukBirimi;
    protected String yukMiktari;
    protected String tasimaBedeli;
    protected String unNumarasi;
    protected String tehlikeliMaddeTasimaSekli;
    
    
	public YeniYukKaydi_iExcell(String plaka1, String plaka2, String sofor1TcNo, String sofor2TcNo,
			String tasimaTuruKodu, String gonderenVergiNo, String gonderenUnvan, String aliciVergiNo, String aliciUnvan,
			String yuklemeUlkeKodu, String yuklemeIlMernisKodu, String yuklemeIlceMernisKodu, String bosaltmaUlkeKodu,
			String bosaltmaIlMernisKodu, String bosaltmaIlceMernisKodu, String yuklemeTarihi, String yuklemeSaati,
			String bosaltmaTarihi, String bosaltmaSaati, String yukCinsId, String yukBirimi, String yukMiktari,
			String tasimaBedeli, String unNumarasi, String tehlikeliMaddeTasimaSekli) {
		super();
		this.plaka1 = plaka1;
		this.plaka2 = plaka2;
		this.sofor1TcNo = sofor1TcNo;
		this.sofor2TcNo = sofor2TcNo;
		this.tasimaTuruKodu = tasimaTuruKodu;
		this.gonderenVergiNo = gonderenVergiNo;
		this.gonderenUnvan = gonderenUnvan;
		this.aliciVergiNo = aliciVergiNo;
		this.aliciUnvan = aliciUnvan;
		this.yuklemeUlkeKodu = yuklemeUlkeKodu;
		this.yuklemeIlMernisKodu = yuklemeIlMernisKodu;
		this.yuklemeIlceMernisKodu = yuklemeIlceMernisKodu;
		this.bosaltmaUlkeKodu = bosaltmaUlkeKodu;
		this.bosaltmaIlMernisKodu = bosaltmaIlMernisKodu;
		this.bosaltmaIlceMernisKodu = bosaltmaIlceMernisKodu;
		this.yuklemeTarihi = yuklemeTarihi;
		this.yuklemeSaati = yuklemeSaati;
		this.bosaltmaTarihi = bosaltmaTarihi;
		this.bosaltmaSaati = bosaltmaSaati;
		this.yukCinsId = yukCinsId;
		this.yukBirimi = yukBirimi;
		this.yukMiktari = yukMiktari;
		this.tasimaBedeli = tasimaBedeli;
		this.unNumarasi = unNumarasi;
		this.tehlikeliMaddeTasimaSekli = tehlikeliMaddeTasimaSekli;
	}
	public YeniYukKaydi_iExcell() {
		super();
	}
	public String getPlaka1() {
		return plaka1;
	}
	public void setPlaka1(String plaka1) {
		this.plaka1 = plaka1;
	}
	public String getPlaka2() {
		return plaka2;
	}
	public void setPlaka2(String plaka2) {
		this.plaka2 = plaka2;
	}
	public String getSofor1TcNo() {
		return sofor1TcNo;
	}
	public void setSofor1TcNo(String sofor1TcNo) {
		this.sofor1TcNo = sofor1TcNo;
	}
	public String getSofor2TcNo() {
		return sofor2TcNo;
	}
	public void setSofor2TcNo(String sofor2TcNo) {
		this.sofor2TcNo = sofor2TcNo;
	}
	public String getTasimaTuruKodu() {
		return tasimaTuruKodu;
	}
	public void setTasimaTuruKodu(String tasimaTuruKodu) {
		this.tasimaTuruKodu = tasimaTuruKodu;
	}
	public String getGonderenVergiNo() {
		return gonderenVergiNo;
	}
	public void setGonderenVergiNo(String gonderenVergiNo) {
		this.gonderenVergiNo = gonderenVergiNo;
	}
	public String getGonderenUnvan() {
		return gonderenUnvan;
	}
	public void setGonderenUnvan(String gonderenUnvan) {
		this.gonderenUnvan = gonderenUnvan;
	}
	public String getAliciVergiNo() {
		return aliciVergiNo;
	}
	public void setAliciVergiNo(String aliciVergiNo) {
		this.aliciVergiNo = aliciVergiNo;
	}
	public String getAliciUnvan() {
		return aliciUnvan;
	}
	public void setAliciUnvan(String aliciUnvan) {
		this.aliciUnvan = aliciUnvan;
	}
	public String getYuklemeUlkeKodu() {
		return yuklemeUlkeKodu;
	}
	public void setYuklemeUlkeKodu(String yuklemeUlkeKodu) {
		this.yuklemeUlkeKodu = yuklemeUlkeKodu;
	}
	public String getYuklemeIlMernisKodu() {
		return yuklemeIlMernisKodu;
	}
	public void setYuklemeIlMernisKodu(String yuklemeIlMernisKodu) {
		this.yuklemeIlMernisKodu = yuklemeIlMernisKodu;
	}
	public String getYuklemeIlceMernisKodu() {
		return yuklemeIlceMernisKodu;
	}
	public void setYuklemeIlceMernisKodu(String yuklemeIlceMernisKodu) {
		this.yuklemeIlceMernisKodu = yuklemeIlceMernisKodu;
	}
	public String getBosaltmaUlkeKodu() {
		return bosaltmaUlkeKodu;
	}
	public void setBosaltmaUlkeKodu(String bosaltmaUlkeKodu) {
		this.bosaltmaUlkeKodu = bosaltmaUlkeKodu;
	}
	public String getBosaltmaIlMernisKodu() {
		return bosaltmaIlMernisKodu;
	}
	public void setBosaltmaIlMernisKodu(String bosaltmaIlMernisKodu) {
		this.bosaltmaIlMernisKodu = bosaltmaIlMernisKodu;
	}
	public String getBosaltmaIlceMernisKodu() {
		return bosaltmaIlceMernisKodu;
	}
	public void setBosaltmaIlceMernisKodu(String bosaltmaIlceMernisKodu) {
		this.bosaltmaIlceMernisKodu = bosaltmaIlceMernisKodu;
	}
	public String getYuklemeTarihi() {
		return yuklemeTarihi;
	}
	public void setYuklemeTarihi(String yuklemeTarihi) {
		this.yuklemeTarihi = yuklemeTarihi;
	}
	public String getYuklemeSaati() {
		return yuklemeSaati;
	}
	public void setYuklemeSaati(String yuklemeSaati) {
		this.yuklemeSaati = yuklemeSaati;
	}
	public String getBosaltmaTarihi() {
		return bosaltmaTarihi;
	}
	public void setBosaltmaTarihi(String bosaltmaTarihi) {
		this.bosaltmaTarihi = bosaltmaTarihi;
	}
	public String getBosaltmaSaati() {
		return bosaltmaSaati;
	}
	public void setBosaltmaSaati(String bosaltmaSaati) {
		this.bosaltmaSaati = bosaltmaSaati;
	}
	public String getYukCinsId() {
		return yukCinsId;
	}
	public void setYukCinsId(String yukCinsId) {
		this.yukCinsId = yukCinsId;
	}
	public String getYukBirimi() {
		return yukBirimi;
	}
	public void setYukBirimi(String yukBirimi) {
		this.yukBirimi = yukBirimi;
	}
	public String getYukMiktari() {
		return yukMiktari;
	}
	public void setYukMiktari(String yukMiktari) {
		this.yukMiktari = yukMiktari;
	}
	public String getTasimaBedeli() {
		return tasimaBedeli;
	}
	public void setTasimaBedeli(String tasimaBedeli) {
		this.tasimaBedeli = tasimaBedeli;
	}
	public String getUnNumarasi() {
		return unNumarasi;
	}
	public void setUnNumarasi(String unNumarasi) {
		this.unNumarasi = unNumarasi;
	}
	public String getTehlikeliMaddeTasimaSekli() {
		return tehlikeliMaddeTasimaSekli;
	}
	public void setTehlikeliMaddeTasimaSekli(String tehlikeliMaddeTasimaSekli) {
		this.tehlikeliMaddeTasimaSekli = tehlikeliMaddeTasimaSekli;
	}
    
    

}
