package com.arma.uetds_boot.security.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arma.uetds_boot.dto.CompanyDTO;
import com.arma.uetds_boot.model.UetdsCompanies;
import com.arma.uetds_boot.repository.CompanyRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/company")
public class UetdsCompanyController {

	@Autowired
	private CompanyRepository company;

	@RequestMapping("/comSave")
	public UetdsCompanies saveCom(@RequestBody UetdsCompanies com)
	{
		com.setFirma_unvan(com.getFirma_unvan().toUpperCase());
		return company.save(com);
	}
	@RequestMapping("/getCom")
	public Optional<UetdsCompanies> getCom(@RequestBody Optional<UetdsCompanies> comId){
		comId=company.findById(comId.get().getId());
		comId.get().setUetds_kullanici_adi(null);
		comId.get().setUetds_sifre(null);
		return comId;
	}
	@RequestMapping("/getAllCom")
	public List<CompanyDTO> getAllCom()
	{
		return company.findAllByAktif();
	}   	
	@RequestMapping("/deleteCom")
	public UetdsCompanies deleteCom(@RequestBody UetdsCompanies id)
	{
		UetdsCompanies com=company.getOne(id.getId());
		com.setAktif_durum(0);
		return company.saveAndFlush(com);
	}  
	@RequestMapping("/getComByLike")
	public List<UetdsCompanies> getByLike(@RequestBody UetdsCompanies firma_unvan)
	{
		return company.findbyLike(firma_unvan.getFirma_unvan());
		
	}
}