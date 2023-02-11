package com.arma.uetds_boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arma.uetds_boot.model.YolcuSeferBilgileriInput;
import com.arma.uetds_boot.model.Yolcu_YolcuBilgileriInput;

@Repository
public interface Yolcu_YolcuRepository extends JpaRepository<Yolcu_YolcuBilgileriInput, Long>{
	
	List<Yolcu_YolcuBilgileriInput> findBysefer(YolcuSeferBilgileriInput id);
	
	Yolcu_YolcuBilgileriInput findByuetdsYolcuRefNo(String refNo);

}
