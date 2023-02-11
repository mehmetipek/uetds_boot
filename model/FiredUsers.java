package com.arma.uetds_boot.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="fired_users")
public class FiredUsers {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne()
	@JoinColumn(name="fired")
	private UetdsCompanies companys; 
	
	
    @NotBlank
    @Size(min=3, max = 50)
    private String name;
    
    @NotBlank
    private String last_name;

    private Long userId;
    
    private String personelTuru;
    
    private String cinsiyet;
    
    private String uyruk;
    
    private String tcno;
    
    private String telno;
    
    private String adres;
    
    private String cikarilma_sebebi;
    
    private Date cikarilma_tar;
  
    @NotBlank
    @Size(min=3, max = 50)
    private String username;


    private String email;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", 
    	joinColumns = @JoinColumn(name = "user_id"), 
    	inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

	public FiredUsers(@NotBlank @Size(min = 3, max = 50) String name, @NotBlank String last_name,String personelTuru, String cinsiyet,
			String uyruk, String tcno, String telno, String adres, String cikarilma_sebebi, Date cikarilma_tar,
			@NotBlank @Size(min = 3, max = 50) String username,  String email, Long userId) {
		super();
		this.name = name;
		this.last_name=last_name;
		this.personelTuru = personelTuru;
		this.cinsiyet = cinsiyet;
		this.uyruk = uyruk;
		this.tcno = tcno;
		this.telno = telno;
		this.adres = adres;
		this.cikarilma_sebebi = cikarilma_sebebi;
		this.cikarilma_tar = cikarilma_tar;
		this.username = username;
		this.email = email;
		this.userId=userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPersonelTuru() {
		return personelTuru;
	}

	public void setPersonelTuru(String personelTuru) {
		this.personelTuru = personelTuru;
	}

	public String getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}

	public String getUyruk() {
		return uyruk;
	}

	public void setUyruk(String uyruk) {
		this.uyruk = uyruk;
	}

	public String getTcno() {
		return tcno;
	}

	public void setTcno(String tcno) {
		this.tcno = tcno;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getCikarilma_sebebi() {
		return cikarilma_sebebi;
	}

	public void setCikarilma_sebebi(String cikarilma_sebebi) {
		this.cikarilma_sebebi = cikarilma_sebebi;
	}

	public Date getCikarilma_tar() {
		return cikarilma_tar;
	}

	public void setCikarilma_tar(Date cikarilma_tar) {
		this.cikarilma_tar = cikarilma_tar;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public UetdsCompanies getCompanys() {
		return companys;
	}

	public void setCompanys(UetdsCompanies companys) {
		this.companys = companys;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	
    
	
    
    
    
}
