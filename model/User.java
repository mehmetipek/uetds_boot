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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;



@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class User{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne()
	@JoinColumn(name="company_id")
	private UetdsCompanies companys; 
	
	
    @NotBlank
    @Size(min=3, max = 50)
    private String name;
    
    @NotBlank
    private String last_name;

    
    private String personelTuru;
    
    @NotBlank
    private String cinsiyet;
    
    @NotBlank
    private String uyruk;
    
    @NotBlank
    private String tcno;
    @NotBlank
    private String telno;
    @NotBlank
    private String adres;
    
   
    
    
    @NotBlank
    @Size(min=3, max = 50)
    private String username;


    private String email;

    
    @NotBlank
    @Size(min=6, max = 100)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", 
    	joinColumns = @JoinColumn(name = "user_id"), 
    	inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    
    @ManyToOne
   	@JoinColumn(name = "tur_id")
    private TurKodlari turid;
    
    @CreatedBy
	@ManyToOne()
	@JoinColumn(name="created_by")
    private User createBy;
    @CreatedDate
    private Date createAt;
    public User() {}



    public User(@NotBlank @Size(min = 3, max = 50) String name,@NotBlank String last_name, String personelTuru, String cinsiyet, String uyruk,
			String tcno, String telno, String adres, @NotBlank @Size(min = 3, max = 50) String username,
			 String email, @NotBlank @Size(min = 6, max = 100) String password, TurKodlari turid) {
		super();
		this.name = name;
		this.personelTuru = personelTuru;
		this.cinsiyet = cinsiyet;
		this.uyruk = uyruk;
		this.tcno = tcno;
		this.telno = telno;
		this.adres = adres;
		this.username = username;
		this.email = email;
		this.password = password;
		this.last_name=last_name;
		this.turid=turid;
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

	public UetdsCompanies getCompanys() {
		return companys;
	}

	public void setCompanys(UetdsCompanies companys) {
		this.companys = companys;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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



	public User getCreateBy() {
		return createBy;
	}



	public void setCreateBy(User createBy) {
		this.createBy = createBy;
	}



	public Date getCreateAt() {
		return createAt;
	}



	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
    
}