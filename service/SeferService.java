package com.arma.uetds_boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arma.uetds_boot.dto.PlateDTO;
import com.arma.uetds_boot.repository.YolcuSeferRepository;

@Service
public class SeferService {

	@Autowired
	YolcuSeferRepository seferRepository;
	
	public List<PlateDTO> findUsedPlateByCompanyId(Long id) {
		return seferRepository.findUsedPlateByCompanyId(id);
	}
	
}
