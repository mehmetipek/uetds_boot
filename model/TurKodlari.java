package com.arma.uetds_boot.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class TurKodlari {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int turKodu;
	
	private String veriAraligi;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "turid")
	private List<User> userid;

	public TurKodlari(Long id, int turKodu, String veriAraligi) {
		super();
		this.id = id;
		this.turKodu = turKodu;
		this.veriAraligi = veriAraligi;
	}

	public TurKodlari() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTurKodu() {
		return turKodu;
	}

	public void setTurKodu(int turKodu) {
		this.turKodu = turKodu;
	}

	public String getVeriAraligi() {
		return veriAraligi;
	}

	public void setVeriAraligi(String veriAraligi) {
		this.veriAraligi = veriAraligi;
	}
	
	

}
