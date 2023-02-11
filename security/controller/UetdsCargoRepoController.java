package com.arma.uetds_boot.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arma.uetds_boot.model.CargoNotification;
import com.arma.uetds_boot.repository.CargoRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/cargo")
public class UetdsCargoRepoController {

	@Autowired
	private CargoRepository cargoRepo;

	@RequestMapping("/getUpdatetable/{firma_id}")
	public List<CargoNotification> getUpdatetable(@PathVariable Long firma_id) {
		return cargoRepo.findByCurrentDate(firma_id);
	}

	// Verilen çekici plakasının taşıdığı yüklerin referans numaralarını verir.
	@CrossOrigin("*")
	@RequestMapping("/cekiciYukleri/{firma_id}")
	public List<CargoNotification> cekiciPlaka(@RequestBody CargoNotification plaka, @PathVariable Long firma_id) {
		return cargoRepo.findByPlaka1(plaka.getPlaka1(), firma_id);
	}

	// Verilen dorse plakasının taşıdığı yüklerin referans numaralarını verir.
	@CrossOrigin("*") 
	@RequestMapping("/dorseYukleri/{firma_id}")
	public List<CargoNotification> dorsePlaka(@RequestBody CargoNotification plaka, @PathVariable Long firma_id) {
		return cargoRepo.findByPlaka2(plaka.getPlaka2(), firma_id);
	}

}
