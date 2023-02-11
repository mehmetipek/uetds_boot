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
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name="yolcu_sefer_grup")
public class Yolcu_GrupInput {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String grupAciklama;
	private String baslangicUlke;
	private long baslangicIl;
	private long baslangicIlce;
	private String baslangicYer;
	private String bitisUlke;
	private long bitisIl;
	private long bitisIlce;
	private String bitisYer;
	private String grupAdi;
	private String grupUcret;
	private String durum;

	@ManyToOne
	@JoinColumn(name = "sefer_id")
	private YolcuSeferBilgileriInput seferNo;
	
	private String uetdsGrupRefNo;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "grup_no")
	private List<Yolcu_YolcuBilgileriInput> grup_id;

	public Yolcu_GrupInput() {
		super();
	}

	

	public Yolcu_GrupInput(Long id, String grupAciklama, String baslangicUlke, long baslangicIl, long baslangicIlce,
			String baslangicYer, String bitisUlke, long bitisIl, long bitisIlce, String bitisYer, String grupAdi,
			String grupUcret, String durum, YolcuSeferBilgileriInput seferNo, String uetdsGrupRefNo) {
		super();
		Id = id;
		this.grupAciklama = grupAciklama;
		this.baslangicUlke = baslangicUlke;
		this.baslangicIl = baslangicIl;
		this.baslangicIlce = baslangicIlce;
		this.baslangicYer = baslangicYer;
		this.bitisUlke = bitisUlke;
		this.bitisIl = bitisIl;
		this.bitisIlce = bitisIlce;
		this.bitisYer = bitisYer;
		this.grupAdi = grupAdi;
		this.grupUcret = grupUcret;
		this.durum = durum;
		this.seferNo = seferNo;
		this.uetdsGrupRefNo = uetdsGrupRefNo;
	}



	public Yolcu_GrupInput(String grupAciklama, String baslangicUlke, long baslangicIl, long baslangicIlce,
			String baslangicYer, String bitisUlke, long bitisIl, long bitisIlce, String bitisYer, String grupAdi,
			String grupUcret, String durum, YolcuSeferBilgileriInput seferNo, String uetdsGrupRefNo) {
		super();
		this.grupAciklama = grupAciklama;
		this.baslangicUlke = baslangicUlke;
		this.baslangicIl = baslangicIl;
		this.baslangicIlce = baslangicIlce;
		this.baslangicYer = baslangicYer;
		this.bitisUlke = bitisUlke;
		this.bitisIl = bitisIl;
		this.bitisIlce = bitisIlce;
		this.bitisYer = bitisYer;
		this.grupAdi = grupAdi;
		this.grupUcret = grupUcret;
		this.durum = durum;
		this.seferNo = seferNo;
		this.uetdsGrupRefNo = uetdsGrupRefNo;
	}



	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getGrupAciklama() {
		return grupAciklama;
	}

	public void setGrupAciklama(String grupAciklama) {
		this.grupAciklama = grupAciklama;
	}

	public String getBaslangicUlke() {
		return baslangicUlke;
	}

	public void setBaslangicUlke(String baslangicUlke) {
		this.baslangicUlke = baslangicUlke;
	}

	public long getBaslangicIl() {
		return baslangicIl;
	}

	public void setBaslangicIl(long baslangicIl) {
		this.baslangicIl = baslangicIl;
	}

	public long getBaslangicIlce() {
		return baslangicIlce;
	}

	public void setBaslangicIlce(long baslangicIlce) {
		this.baslangicIlce = baslangicIlce;
	}

	public String getBaslangicYer() {
		return baslangicYer;
	}

	public void setBaslangicYer(String baslangicYer) {
		this.baslangicYer = baslangicYer;
	}

	public String getBitisUlke() {
		return bitisUlke;
	}

	public void setBitisUlke(String bitisUlke) {
		this.bitisUlke = bitisUlke;
	}

	public long getBitisIl() {
		return bitisIl;
	}

	public void setBitisIl(long bitisIl) {
		this.bitisIl = bitisIl;
	}

	public long getBitisIlce() {
		return bitisIlce;
	}

	public void setBitisIlce(long bitisIlce) {
		this.bitisIlce = bitisIlce;
	}

	public String getBitisYer() {
		return bitisYer;
	}

	public void setBitisYer(String bitisYer) {
		this.bitisYer = bitisYer;
	}

	public String getGrupAdi() {
		return grupAdi;
	}

	public void setGrupAdi(String grupAdi) {
		this.grupAdi = grupAdi;
	}

	public String getGrupUcret() {
		return grupUcret;
	}

	public void setGrupUcret(String grupUcret) {
		this.grupUcret = grupUcret;
	}

	public YolcuSeferBilgileriInput getSeferNo() {
		return seferNo;
	}



	public void setSeferNo(YolcuSeferBilgileriInput seferNo) {
		this.seferNo = seferNo;
	}


	public String getUetdsGrupRefNo() {
		return uetdsGrupRefNo;
	}

	public void setUetdsGrupRefNo(String uetdsGrupRefNo) {
		this.uetdsGrupRefNo = uetdsGrupRefNo;
	}



	public String getDurum() {
		return durum;
	}



	public void setDurum(String durum) {
		this.durum = durum;
	}
	

}
