package com.arma.uetds_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arma.uetds_boot.model.UlkeListesi;

@Repository
public interface UlkeRepository extends JpaRepository<UlkeListesi, Long> {
	
	UlkeListesi findByKod(String kod);
	

}
