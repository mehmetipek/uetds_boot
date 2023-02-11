package com.arma.uetds_boot.security.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.arma.uetds_boot.dto.UserDTO;
import com.arma.uetds_boot.model.UetdsCompanies;
import com.arma.uetds_boot.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    
    Optional<User> findById(Long id);
    
    Page<User> findBycompanys(Pageable pageable,UetdsCompanies user);
    
    @Query(value = "SELECT * FROM users WHERE users = ?1", nativeQuery = true)
	List<User> findByUserName(Long users);
    
    @Query(value = "SELECT u.*, tk.veri_araligi as personel_tur FROM users u inner join tur_kodlari tk on u.tur_id=tk.tur_kodu  WHERE company_id = ?1", nativeQuery = true)
	List<UserDTO> findByCompanyId(Long id);
    /*
    @Modifying(clearAutomatically = true)
    @Query("UPDATE User u SET u.username = :username WHERE u.id = :userId")
    int updateUser(@Param("username") String username, @Param("userId")  Long userId);
    */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE User u SET u.username = :username WHERE u.id = :userId")
    int updateUser(@Param("username") String username, @Param("userId")  Long userId);
    
    @Query(value = "select * from users where users=?1 and name like ?2%", nativeQuery = true)
    List<User> findByLikeUser(Long firmaId,String username);

}