package com.arma.uetds_boot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arma.uetds_boot.model.RoleName;
import com.arma.uetds_boot.model.User;
import com.arma.uetds_boot.security.request.SignUpForm;
import com.arma.uetds_boot.service.UserService;

@RestController
@RequestMapping("api/v1/users")
public class UserController_v1 {
	@Autowired
	private UserService userService;

	@PreAuthorize("hasRole('ROLE_PM')")
	@PostMapping("/create/pm")
	public ResponseEntity<String> createPM(@Valid @RequestBody SignUpForm signUpRequest,Authentication authentication) {
		return userService.createUser(authentication, signUpRequest, RoleName.ROLE_PM);
	}

	@PreAuthorize("hasRole('ROLE_PM')")
	@PostMapping("/create/admin")
	public ResponseEntity<String> createAdmin(@Valid @RequestBody SignUpForm signUpRequest,Authentication authentication) {
		return userService.createUser(authentication, signUpRequest, RoleName.ROLE_ADMIN);
	}
	@PostMapping("/create/user")
	public ResponseEntity<String> createUser(@Valid @RequestBody SignUpForm signUpRequest,Authentication authentication) {
		return userService.createUser(authentication, signUpRequest, RoleName.ROLE_USER);
	}

}
