package com.arma.uetds_boot.security.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jboss.logging.LoggingClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arma.uetds_boot.UetdsBootApplication;
import com.arma.uetds_boot.model.IlceListesi;
import com.arma.uetds_boot.model.Iller;
import com.arma.uetds_boot.model.UlkeListesi;
import com.arma.uetds_boot.repository.IlceRepository;
import com.arma.uetds_boot.repository.UlkeRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/ilce")
public class IlceAndUlkeController {
	
	
	 private static final Logger logger = LoggerFactory.getLogger(IlceAndUlkeController.class);
	 
	
	@Autowired
	private IlceRepository ilceRepo;
	
	@Autowired
	private UlkeRepository ulkeRepo;
	
	@RequestMapping("/getIlceByIlceCode")
	public IlceListesi getByKod(@RequestBody IlceListesi ilceModel)
	{
		System.out.println(ilceModel.getKodu());
		return ilceRepo.findByKodu(ilceModel.getKodu());
	}
	@RequestMapping("/getIlceByIlCode") 
	public List<IlceListesi> getByIlKodu(@RequestBody IlceListesi ilKod)
	{
		return ilceRepo.findByIlkod(ilKod.getIlkod());
		
	}
	@RequestMapping("/getUlkeByUlkeCode")
	public UlkeListesi getByCode(@RequestBody UlkeListesi ulkeKod)
	{
		logger.info(" ############################## - {} {}", ulkeKod.getKod(), ulkeKod.getUlke_adi());

		return ulkeRepo.findByKod(ulkeKod.getKod());
	}
	@RequestMapping("/getAllUlke")
	public List<UlkeListesi> getAll()
	{
		return ulkeRepo.findAll();
	}
	@RequestMapping("/getIller")
	public List<Iller> getIller(Principal p)
	{	
		System.out.println(p);
		List<Iller> iller=new ArrayList<Iller>();
		for(Object data:ilceRepo.findAllDistinctData())
		{
			Iller il=new Iller();
			Object[] dataD=(Object[]) data;
			il.setIl_adi((String) dataD[0]);
			il.setIl_kod((String) dataD[1]);
			iller.add(il);
		}
		
		return iller;
		
	}
	

}
