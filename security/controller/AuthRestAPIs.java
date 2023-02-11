package com.arma.uetds_boot.security.controller;

import java.security.Principal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.arma.uetds_boot.model.Role;
import com.arma.uetds_boot.model.RoleName;
import com.arma.uetds_boot.model.User;
import com.arma.uetds_boot.security.jwt.JwtProvider;
import com.arma.uetds_boot.security.repository.RoleRepository;
import com.arma.uetds_boot.security.repository.UserRepository;
import com.arma.uetds_boot.security.request.LoginForm;
import com.arma.uetds_boot.security.request.SignUpForm;
import com.arma.uetds_boot.security.response.JwtResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(HttpServletRequest request,@Valid @RequestBody LoginForm loginRequest) {
		String ipAddress = request.getRemoteAddr();
		System.out.println(ipAddress);
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		return ResponseEntity.ok(new JwtResponse(jwt));
	}

	@CrossOrigin("*")
	@PostMapping("/signup")
	public ResponseEntity<String> registerUser(Authentication authentication,Principal principal,@Valid @RequestBody SignUpForm signUpRequest) {
		if(authentication==null)
			return new ResponseEntity<String>("Fail -> Unauthorized", HttpStatus.UNAUTHORIZED); 
		
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<String>("Fail -> Username is already taken!", HttpStatus.BAD_REQUEST);
		}
		User createdBy=userRepository.findByUsername(authentication.getName()).orElse(null);

		 
		 User user=new User(signUpRequest.getName(),signUpRequest.getLast_name(), signUpRequest.getPersonelTuru(), signUpRequest.getCinsiyet(),
				 signUpRequest.getUyruk(), signUpRequest.getTcno(), signUpRequest.getTelno(), signUpRequest.getAdres(), signUpRequest.getUsername(),
				 signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()), signUpRequest.getTurid());

		 
		user.setCompanys(signUpRequest.getCompanys());
		user.setCreateBy(createdBy);
		user.setCreateAt(new Date(System.currentTimeMillis()));
		

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		strRoles.forEach(role -> {
			switch (role) {
			case "admin":
				Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(adminRole);

				break;
			case "pm":
				Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(pmRole);

				break;
			default:
				Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(userRole);
			}
		});

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok().body("User registered successfully!");
	}

}