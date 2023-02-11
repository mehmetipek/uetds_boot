package com.arma.uetds_boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arma.uetds_boot.dto.CompanyDTO;
import com.arma.uetds_boot.model.UetdsCompanies;
import com.arma.uetds_boot.model.User;

@Repository
public interface CompanyRepository extends JpaRepository<UetdsCompanies, Long> {
	
	@Query(value = "SELECT * FROM uetdscompanies c WHERE (aktif_durum is null or aktif_durum=1) and (c.firma_unvan LIKE ?1%) and not id=1" , nativeQuery = true)
	List<UetdsCompanies> findbyLike(String firma_unvan);
	
	@Query(value = "select id,aktif_durum,firma_unvan from uetdscompanies where (aktif_durum is null or aktif_durum=1) and not id=1" , nativeQuery = true)
	List<CompanyDTO> findAllByAktif();
	
	


	
}
