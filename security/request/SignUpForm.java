package com.arma.uetds_boot.security.request;

import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;

import com.arma.uetds_boot.model.TurKodlari;
import com.arma.uetds_boot.model.UetdsCompanies;


public class SignUpForm {
	
		
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;
    
    @NotBlank
    private String last_name;
    
    @ManyToOne()
	@JoinColumn(name="users")
    private UetdsCompanies companys;

    @NotBlank
    @Size(min = 3, max = 50)
    private String username;
    
    
    private String personelTuru;
    
    private String cinsiyet;
    
    private String uyruk;
    
    private String tcno;
    
    private String telno;
    
    private String adres;

 

    private String email;
    
    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    @ManyToOne
   	@JoinColumn(name = "userid")
    private TurKodlari turid;
    
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

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRole() {
    	return this.role;
    }
    
    public void setRole(Set<String> role) {
    	this.role = role;
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

	public TurKodlari getTurid() {
		return turid;
	}

	public void setTurid(TurKodlari turid) {
		this.turid = turid;
	}
	
	
	
    
}