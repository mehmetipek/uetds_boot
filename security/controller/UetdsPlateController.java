package com.arma.uetds_boot.security.controller;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arma.uetds_boot.model.CargoNotification;
import com.arma.uetds_boot.model.PlakaListModel;
import com.arma.uetds_boot.model.UetdsCompanies;
import com.arma.uetds_boot.model.UetdsPlate;
import com.arma.uetds_boot.repository.CargoRepository;
import com.arma.uetds_boot.repository.PlateRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/plate")
public class UetdsPlateController {


	@Autowired
	private CargoRepository cargoRepo;
	
	@Autowired
	private PlateRepository plateRepo;
	
	
	
	@RequestMapping("/savePlate")
	public UetdsPlate savePlate(@RequestBody UetdsPlate plate)
	{
		return plateRepo.save(plate);
	}
	@RequestMapping("/getAllPlate/{pageNumber}/{limit}")
	public Page<UetdsPlate> getAllPlate(@RequestBody UetdsCompanies comId,@PathVariable int pageNumber, @PathVariable int limit)
	{
		Pageable page= PageRequest.of(pageNumber-1, limit);
		return plateRepo.findBycompId(page,comId.getId());
	}
	
	@RequestMapping("/getAllLike")
	public List<UetdsPlate> getAllPlate(@RequestBody UetdsPlate plate)
	{
		List<UetdsPlate> plates= plateRepo.findByLike(plate.getPlaka(), plate.getFid().getId());
		for(UetdsPlate pla:plates)
			pla.setFid(null);
		
		return plates;
		
	}
	
	@Transactional
	@RequestMapping("/deletePlate")
	public void deletePlateByid(@RequestBody UetdsPlate Plateid)
	{
		plateRepo.deleteById(Plateid.getId());
	}
	

	//Firmaya ait çekici plakalarını ve kayıtlı kaç yük taşıdıklarını gösteren metot.
	@CrossOrigin("*")
	@RequestMapping("/cekiciPlakaList/{firmaId}")
	public List<PlakaListModel> cekici(@PathVariable Long firmaId)
	{
	    List<PlakaListModel> modelList=new ArrayList<PlakaListModel>();
		List<Object[]> cekiciPlaka=cargoRepo.findByCekiciPlaka(firmaId);
		for(Object[] model:cekiciPlaka)
		{
			PlakaListModel modelOne=new PlakaListModel();
			modelOne.setYukSayisi((BigInteger)model[0]);
			modelOne.setPlaka((String)model[1]);
			modelList.add(modelOne);
		}
		return modelList;
	}
	//Firmaya ait dorse plakalarını ve kayıtlı kaç yük taşıdıklarını gösteren metot.
	@CrossOrigin("*")
	@RequestMapping("/dorsePlakaList/{firmaId}")
	public List<PlakaListModel> dorse(@PathVariable Long firmaId)
	{
	    List<PlakaListModel> modelList=new ArrayList<PlakaListModel>();
		List<Object[]> cekiciPlaka=cargoRepo.findByDorsePlaka(firmaId);
		for(Object[] model:cekiciPlaka)
		{
			PlakaListModel modelOne=new PlakaListModel();
			modelOne.setYukSayisi((BigInteger)model[0]);
			modelOne.setPlaka((String)model[1]);
			modelList.add(modelOne);
		}
		return modelList;
	}
	
}
