package com.arma.uetds_boot.security.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.arma.uetds_boot.model.FiredUsers;
import com.arma.uetds_boot.model.UetdsCompanies;
import com.arma.uetds_boot.model.User;
import com.arma.uetds_boot.repository.CompanyRepository;
import com.arma.uetds_boot.repository.FiredUsersRepository;
import com.arma.uetds_boot.security.repository.UserRepository;
import com.arma.uetds_boot.service.UserRepoService;
import com.arma.uetds_boot.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
@Component
public class UetdsUserController {
	
	@Autowired
	private UserRepoService service;
	
	@Autowired
	private UserRepository userRep;

	
	@Autowired
	private CompanyRepository comRepo;
	
	@Autowired
	private FiredUsersRepository fireRepo;
	
	@Autowired
	private UserService userService; 

	
	@CrossOrigin("*")
	@RequestMapping("/allUser")
	public Optional<User> allUser(@RequestBody Long id)
	{
		Optional<User> user=userRep.findById(id);
		user.get().setPassword(null);
		user.get().getCompanys().setUetds_kullanici_adi(null);
		user.get().getCompanys().setUetds_sifre(null);
		return user;
	}
	@CrossOrigin("*")
	@RequestMapping("/getAll/{pageNumber}/{limit}")
	public Page<User> getAllUser(@RequestBody UetdsCompanies id, @PathVariable int pageNumber, @PathVariable int limit){
		Pageable page=PageRequest.of(pageNumber, limit);
		Page<User> user= userRep.findBycompanys(page,id);
		
		for(User us:user)
		{
			us.setCompanys(null);
			us.setPassword(null);
		}
		return user;
	}
	
	@Transactional
	@RequestMapping("/update")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PM')")
	public User updateUser(@RequestBody User user)
	{ 
		return service.updateUser(user);
	}
	@CrossOrigin("*")
	@RequestMapping("/getUser")
	public User getUser(@RequestBody User userId)
	{
		
		return userService.getUserById(userId.getId());
	}
	@Transactional
	@RequestMapping("/deleteUser")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_PM')")
	public void deleteUser(@RequestBody FiredUsers fired)
	{
		userRep.deleteById(fired.getUserId());
	}
	@Transactional
	@RequestMapping("/likeUser/{firma_id}")
	public List<User> likeUser(@RequestBody User user, @PathVariable Long firma_id)
	{
		return userRep.findByLikeUser(firma_id, user.getName());
	}
}
