package com.arma.uetds_boot.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="plaka_bilgileri")
public class UetdsPlate {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@ManyToOne()
	@JoinColumn(name="plaka_bilgileri")
	private UetdsCompanies fid;
	
	@NotBlank
	@NaturalId
	@Column(name="plaka")
	private String plaka;

	@Column(name="marka")
	private String cekici_marka;
	
	
	@Column(name="model")
	private String cekici_model;
	
	@Column(name="durum")
	private String oz_mal_durumu;  //True ise öz mal, False ise Sözleşmeli


	@Column(name="soz_bas_tar")
	private Date sozlesme_bas_tar;

	@Column(name = "soz_bit_tar")
	private Date sozlesme_bitis_tar;
	
	@Column(name="son_mua_tar")
	private Date son_muayene_tar;
	
	

	public UetdsPlate() {
		super();
	}

	


	public UetdsPlate(@NotBlank String plaka, String cekici_marka, String cekici_model, String oz_mal_durumu,
			Date sozlesme_bas_tar, Date sozlesme_bitis_tar, Date son_muayene_tar) {
		super();
		this.plaka = plaka;
		this.cekici_marka = cekici_marka;
		this.cekici_model = cekici_model;
		this.oz_mal_durumu = oz_mal_durumu;
		this.sozlesme_bas_tar = sozlesme_bas_tar;
		this.sozlesme_bitis_tar = sozlesme_bitis_tar;
		this.son_muayene_tar = son_muayene_tar;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UetdsCompanies getFid() {
		return fid;
	}

	public void setFid(UetdsCompanies fid) {
		this.fid = fid;
	}

	public String getPlaka() {
		return plaka;
	}

	public void setPlaka(String plaka) {
		this.plaka = plaka;
	}




	public String getCekici_marka() {
		return cekici_marka;
	}




	public void setCekici_marka(String cekici_marka) {
		this.cekici_marka = cekici_marka;
	}

	public String getCekici_model() {
		return cekici_model;
	}




	public void setCekici_model(String cekici_model) {
		this.cekici_model = cekici_model;
	}
	


	public String getOz_mal_durumu() {
		return oz_mal_durumu;
	}




	public void setOz_mal_durumu(String oz_mal_durumu) {
		this.oz_mal_durumu = oz_mal_durumu;
	}




	public Date getSozlesme_bas_tar() {
		return sozlesme_bas_tar;
	}




	public void setSozlesme_bas_tar(Date sozlesme_bas_tar) {
		this.sozlesme_bas_tar = sozlesme_bas_tar;
	}




	public Date getSozlesme_bitis_tar() {
		return sozlesme_bitis_tar;
	}




	public void setSozlesme_bitis_tar(Date sozlesme_bitis_tar) {
		this.sozlesme_bitis_tar = sozlesme_bitis_tar;
	}




	public Date getSon_muayene_tar() {
		return son_muayene_tar;
	}




	public void setSon_muayene_tar(Date son_muayene_tar) {
		this.son_muayene_tar = son_muayene_tar;
	}
	
	

	
	
}
