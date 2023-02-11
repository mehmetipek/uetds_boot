package com.arma.uetds_boot.repository;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arma.uetds_boot.model.CargoNotification;

@Repository
public interface CargoRepository extends JpaRepository<CargoNotification, Long> {
	
	@Query(value = "SELECT * FROM cargo_notification WHERE yukleme_tarihi between ?1 and ?2", nativeQuery = true)
	List<CargoNotification> findByDate(Date date1, Date date2);
	
	//Çekici Plakasına göre Liste
	@Query(value = "select count(plaka1) as yuksayisi, plaka1 as plaka from cargo_notification where cargo_not=?1 group by plaka1 ", nativeQuery = true)
	List<Object[]> findByCekiciPlaka(Long firmaId);
	
	//Dorse Plakasına göre Liste 
	@Query(value = "select count(plaka2) as yuksayisi, plaka2 as plaka from cargo_notification where cargo_not=?1 group by plaka2", nativeQuery = true)
	List<Object[]> findByDorsePlaka(Long firmaId);
	
	@Query(value = "select * from cargo_notification where  cargo_not=?1 and current_date < to_date(yukleme_tarihi, 'DD-MM-YYYY')", nativeQuery = true)
	List<CargoNotification> findByCurrentDate(Long firmaId);
	
	@Query(value = "select * from cargo_notification where plaka1=?1 and cargo_not=?2", nativeQuery = true)
	List<CargoNotification> findByPlaka1(String plaka, Long firma_id);
	
	//Dorse Plakası Referans Numarası
	@Query(value = "select * from cargo_notification where plaka2=?1 and cargo_not=?2", nativeQuery = true)
	List<CargoNotification> findByPlaka2(String plaka, Long firma_id);
	
	CargoNotification findByuetdsBildirimReferansNo(Long referansNo);
	
}
