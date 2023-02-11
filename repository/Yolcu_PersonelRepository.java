package com.arma.uetds_boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arma.uetds_boot.model.Yolcu_PersonelInput;
@Repository
public interface Yolcu_PersonelRepository extends JpaRepository<Yolcu_PersonelInput, Long> {
	
	List<Yolcu_PersonelInput> findByrefNo(Long seferid);

}
