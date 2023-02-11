package com.arma.uetds_boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arma.uetds_boot.model.Yolcu_GrupInput;

@Repository
public interface Yolcu_GrupRepo extends JpaRepository<Yolcu_GrupInput, Long>{
	
	Yolcu_GrupInput findByuetdsGrupRefNo(String refNo);
	
	@Query(value = "select * from yolcu_sefer_grup where sefer_id=?1", nativeQuery = true)
	List<Yolcu_GrupInput> findBySeferNo(Long seferid);
	
	

}
