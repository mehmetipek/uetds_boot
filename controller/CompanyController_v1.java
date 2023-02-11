package com.arma.uetds_boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arma.uetds_boot.dto.PlateDTO;
import com.arma.uetds_boot.dto.UserDTO;
import com.arma.uetds_boot.model.User;
import com.arma.uetds_boot.service.SeferService;
import com.arma.uetds_boot.service.UserService;

@RestController
@RequestMapping("api/v1/companies")
public class CompanyController_v1 {
	@Autowired
	private UserService userService;
	@Autowired
	private SeferService seferService; 
	/*
	 * get all companies
	 * get persons in companies
	 * */
	@GetMapping("/{id}/users")
	public List<UserDTO> getUserListByCompanyId(@PathVariable Long id){		
		return userService.findByCompanyId(id);
	}
	
	@GetMapping("/{id}/usedplate")
	public List<PlateDTO> findUsedPlateByCompanyId(@PathVariable Long id){
		return seferService.findUsedPlateByCompanyId(id);
	}

}
