package com.arma.uetds_boot.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.arma.uetds_boot.model.User;
import com.arma.uetds_boot.security.repository.UserRepository;

@Service
public class UserRepoService {

	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	@Transactional
	public User saveUser(User user) {
		
		User savedUser=userRepository.save(user);
		
		return savedUser;
	}
	
	public User updateUser(User user)
	{
		 	if(user.getPassword()==null)
		 		user.setPassword(userRepository.findById(user.getId()).get().getPassword());
		 	else
		 		user.setPassword(encoder.encode(user.getPassword()));
			return userRepository.save(user);
	}
	
	
}
