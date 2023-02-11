package com.arma.uetds_boot.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arma.uetds_boot.model.IlceListesi;
import com.arma.uetds_boot.model.Iller;

@Repository
public interface IlceRepository extends JpaRepository<IlceListesi, Long> {

	IlceListesi findByKodu(String kod);
	
	List<IlceListesi> findByIlkod(String il_kod);
	
	@Query(value="SELECT DISTINCT il_adi, il_kod FROM ilce_listesi order by il_adi asc", nativeQuery = true)
	List<Object> findAllDistinctData();
}


 