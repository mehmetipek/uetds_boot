package com.arma.uetds_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arma.uetds_boot.model.FiredUsers;

@Repository
public interface FiredUsersRepository  extends JpaRepository<FiredUsers, Long>{

	
}
