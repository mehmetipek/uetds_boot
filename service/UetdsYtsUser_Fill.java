package com.arma.uetds_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.arma.uetds_boot.model.UetdsCompanies;
import com.arma.uetds_boot.repository.CompanyRepository;
import com.arma.uetds_boot.security.repository.UserRepository;
import com.arma.uetds_boot.wsdl.UetdsYtsUser;

@Component
public class UetdsYtsUser_Fill {
	
	@Autowired
	private CompanyRepository cRepo;
	
	
	public UetdsYtsUser fill(Long id)
	{
		UetdsCompanies company=new UetdsCompanies();
		UetdsYtsUser user=new UetdsYtsUser();
		company=cRepo.findById(id).get();	
		user.setKullaniciAdi(company.getUetds_kullanici_adi());
		user.setSifre(company.getUetds_sifre());
		
		return user;		
	}
	
	public com.arma.uetds_boot.yolcu.wsdl.UetdsYtsUser fill_yolcu(Long id)
	{
		UetdsCompanies company=new UetdsCompanies();
		com.arma.uetds_boot.yolcu.wsdl.UetdsYtsUser user= new com.arma.uetds_boot.yolcu.wsdl.UetdsYtsUser();
		company=cRepo.findById(id).get();	
		user.setKullaniciAdi(company.getUetds_kullanici_adi());
		user.setSifre(company.getUetds_sifre());
		
		return user;		
	}

}
