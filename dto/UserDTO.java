package com.arma.uetds_boot.dto;

import java.sql.Date;
import java.util.Set;

import com.arma.uetds_boot.model.Role;
import com.arma.uetds_boot.model.TurKodlari;
import com.arma.uetds_boot.model.User;

public interface UserDTO {
	Long getId();
	String getPersonelTuru();
	String getCinsiyet();
	 String getUyruk();
	String getTcno();
	String getTelno();
	String getAdres();
	String getUsername();
	String getName();
	String getLast_name();
	String getEmail();
	Set<Role> getRoles();
	TurKodlari getTurid();
	User getCreateBy();
	Date getCreateAt();
	String getPersonel_tur();
}
