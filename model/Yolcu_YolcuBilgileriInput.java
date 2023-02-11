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
@Table(name = "yolcu_input")
public class Yolcu_YolcuBilgileriInput {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@ManyToOne
	@JoinColumn(name = "ref_id")
	private YolcuSeferBilgileriInput sefer;

	private String uyrukUlke;
	private String tcKimlikPasaportNo;
	private String cinsiyet;
	private String adi;
	private String soyadi;
	private String koltukNo;
	private String telefonNo;
	private String durum;

	@ManyToOne
	@JoinColumn(name = "grup_id")
	private Yolcu_GrupInput grup_no;

	private String uetdsYolcuRefNo;

	public Yolcu_YolcuBilgileriInput() {
		super();
	}

	

	public Yolcu_YolcuBilgileriInput(Long id, YolcuSeferBilgileriInput sefer, String uyrukUlke,
			String tcKimlikPasaportNo, String cinsiyet, String adi, String soyadi, String koltukNo, String telefonNo,
			String durum, Yolcu_GrupInput grup_no, String uetdsYolcuRefNo) {
		super();
		Id = id;
		this.sefer = sefer;
		this.uyrukUlke = uyrukUlke;
		this.tcKimlikPasaportNo = tcKimlikPasaportNo;
		this.cinsiyet = cinsiyet;
		this.adi = adi;
		this.soyadi = soyadi;
		this.koltukNo = koltukNo;
		this.telefonNo = telefonNo;
		this.durum = durum;
		this.grup_no = grup_no;
		this.uetdsYolcuRefNo = uetdsYolcuRefNo;
	}

	
	public Yolcu_YolcuBilgileriInput(YolcuSeferBilgileriInput sefer, String uyrukUlke, String tcKimlikPasaportNo,
			String cinsiyet, String adi, String soyadi, String koltukNo, String telefonNo, String durum,
			Yolcu_GrupInput grup_no, String uetdsYolcuRefNo) {
		super();
		this.sefer = sefer;
		this.uyrukUlke = uyrukUlke;
		this.tcKimlikPasaportNo = tcKimlikPasaportNo;
		this.cinsiyet = cinsiyet;
		this.adi = adi;
		this.soyadi = soyadi;
		this.koltukNo = koltukNo;
		this.telefonNo = telefonNo;
		this.durum = durum;
		this.grup_no = grup_no;
		this.uetdsYolcuRefNo = uetdsYolcuRefNo;
	}



	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public YolcuSeferBilgileriInput getSefer() {
		return sefer;
	}

	public void setSefer(YolcuSeferBilgileriInput sefer) {
		this.sefer = sefer;
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

	public String getKoltukNo() {
		return koltukNo;
	}

	public void setKoltukNo(String koltukNo) {
		this.koltukNo = koltukNo;
	}

	public String getTelefonNo() {
		return telefonNo;
	}

	public void setTelefonNo(String telefonNo) {
		this.telefonNo = telefonNo;
	}

	public Yolcu_GrupInput getGrup_no() {
		return grup_no;
	}

	public void setGrup_no(Yolcu_GrupInput grup_no) {
		this.grup_no = grup_no;
	}

	public String getUetdsYolcuRefNo() {
		return uetdsYolcuRefNo;
	}

	public void setUetdsYolcuRefNo(String uetdsYolcuRefNo) {
		this.uetdsYolcuRefNo = uetdsYolcuRefNo;
	}



	public String getDurum() {
		return durum;
	}



	public void setDurum(String durum) {
		this.durum = durum;
	}
	

}
