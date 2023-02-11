package com.arma.uetds_boot.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.arma.uetds_boot.model.UetdsPlate;

@Repository
public interface PlateRepository extends PagingAndSortingRepository<UetdsPlate, Long> {

	 @Query(value = "SELECT * FROM plaka_bilgileri WHERE plaka_bilgileri = ?1", nativeQuery = true)
	 Page<UetdsPlate> findBycompId(Pageable price,Long compId);
	 
	 @Query(value = "SELECT * FROM plaka_bilgileri p WHERE p.plaka LIKE ?1% and plaka_bilgileri=?2", nativeQuery = true)
	 List<UetdsPlate> findByLike(String plaka, Long firmaId);
	 
}
