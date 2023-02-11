package com.arma.uetds_boot.service;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.arma.uetds_boot.dto.UserDTO;
import com.arma.uetds_boot.model.Role;
import com.arma.uetds_boot.model.RoleName;
import com.arma.uetds_boot.model.User;
import com.arma.uetds_boot.security.repository.RoleRepository;
import com.arma.uetds_boot.security.repository.UserRepository;
import com.arma.uetds_boot.security.request.SignUpForm;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	
	public List<UserDTO> findByCompanyId(Long id){
		return userRepository.findByCompanyId(id);
	}
	public User getUserById(Long id) {
		User user=new User();
		user=userRepository.findById(id).orElse(null);
		if(user==null)
			return null;
		user.setPassword(null);
		user.getCompanys().setUetds_kullanici_adi(null);
		user.getCompanys().setUetds_sifre(null);
		return user;
	}
	
	public ResponseEntity<String> createUser(Authentication authentication,SignUpForm signUpRequest,RoleName role) {
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
		
		Role _role = roleRepository.findByName(role)
				.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
		roles.add(_role);
		

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok().body(role.toString()+" registered successfully!");
	}
}
