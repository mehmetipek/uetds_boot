package com.arma.uetds_boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arma.uetds_boot.dto.PlateDTO;
import com.arma.uetds_boot.model.CargoNotification;
import com.arma.uetds_boot.model.UetdsCompanies;
import com.arma.uetds_boot.model.YolcuSeferBilgileriInput;



@Repository
public interface YolcuSeferRepository extends JpaRepository<YolcuSeferBilgileriInput, Long>{
	
	List<YolcuSeferBilgileriInput> findBycompanieOrderByHareketTarihiDesc(UetdsCompanies id);
	
	YolcuSeferBilgileriInput findByuetdsSeferReferansNo(Long id);
	
	@Query(value = "select id from yolcu_sefer_bilgileri where uetds_sefer_referans_no=?1", nativeQuery = true)
	Long findByRefNofromId(Long seferRefNo);
	
	@Query(value = "select * from yolcu_sefer_bilgileri where yolcu_cargo_not=?1", nativeQuery = true)
	List<YolcuSeferBilgileriInput> findByFirmaId(Long firmaId);
	
	@Query(value = "select uetds_sefer_referans_no from yolcu_sefer_bilgileri where id=?1", nativeQuery = true)
	Long findByIdChange(Long id);

	@Query(value = "select yolcu_cargo_not from yolcu_sefer_bilgileri where id=?1", nativeQuery = true)
	Long findBySeferId(Long id);
	

	@Query(value = "select * from yolcu_sefer_bilgileri where firma_sefer_no like ?1% and yolcu_cargo_not=?2", nativeQuery = true)
	List<YolcuSeferBilgileriInput> findByLikeSefer(String seferAdi, Long firma_id);
	

	@Query(value = "select * from yolcu_sefer_bilgileri where arac_plaka like ?1% and yolcu_cargo_not=?2 ", nativeQuery = true)
	List<YolcuSeferBilgileriInput> findByLikePlaka(String aracPlaka, Long firma_id);

	@Query(value = "select DISTINCT arac_plaka from yolcu_sefer_bilgileri where yolcu_cargo_not=?1", nativeQuery = true)
	List<PlateDTO> findUsedPlateByCompanyId(Long id);
	
	
	

}
