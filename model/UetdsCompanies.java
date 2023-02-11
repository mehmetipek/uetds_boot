package com.arma.uetds_boot.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "uetdscompanies")
public class UetdsCompanies {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column
	private String firma_unvan;
	
	@NotBlank
	@Column
	private String uetds_kullanici_adi;
	
	@NotBlank
	@Column
	private String uetds_sifre;
	
	@Column
	private Integer aktif_durum;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "companys")
	private List<User> users;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "companys")
	private List<FiredUsers> fired;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "fid")
	private List<UetdsPlate> plaka_bilgileri;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "firma_id")
	private List<CargoNotification> cargo_not;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "companie")
	private List<YolcuSeferBilgileriInput> yolcu_cargo_not;
	
	public UetdsCompanies() {
		super();
	}
	

	public UetdsCompanies(@NotBlank String firma_unvan, @NotBlank String uetds_kullanici_adi,
			@NotBlank String uetds_sifre, Integer aktif_durum) {
		super();
		this.firma_unvan = firma_unvan;
		this.uetds_kullanici_adi = uetds_kullanici_adi;
		this.uetds_sifre = uetds_sifre;
		this.aktif_durum = aktif_durum;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirma_unvan() {
		return firma_unvan;
	}

	public void setFirma_unvan(String firma_unvan) {
		this.firma_unvan = firma_unvan;
	}

	public String getUetds_kullanici_adi() {
		return uetds_kullanici_adi;
	}

	public void setUetds_kullanici_adi(String uetds_kullanici_adi) {
		this.uetds_kullanici_adi = uetds_kullanici_adi;
	}

	public String getUetds_sifre() {
		return uetds_sifre;
	}

	public void setUetds_sifre(String uetds_sifre) {
		this.uetds_sifre = uetds_sifre;
	}


	public Integer getAktif_durum() {
		return aktif_durum;
	}


	public void setAktif_durum(Integer aktif_durum) {
		this.aktif_durum = aktif_durum;
	}

	
	
	

	
	

}
