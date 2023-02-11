package com.arma.uetds_boot.security.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
public class UserController {
	 
	@CrossOrigin("*")
	@RequestMapping("/info")
	public Object object(Authentication authentication,Principal principal ) {
		  return principal;
    }
	
}