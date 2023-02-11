package com.arma.uetds_boot.viewModel;

public class Company {

	private Long id;
	private String firma_unvan;
	private Integer aktif_durum;
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
	public Integer getAktif_durum() {
		return aktif_durum;
	}
	public void setAktif_durum(Integer aktif_durum) {
		this.aktif_durum = aktif_durum;
	}
	
	
}
