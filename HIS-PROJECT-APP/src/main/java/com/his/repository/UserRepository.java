package com.his.repository;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.his.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Serializable> {

	public   List<UserEntity>  findByRole(String role);
	
	@Query("update  UserEntity    set   deleteSwitch='Y'  where  userId=:uid")
	@Modifying
	@Transactional
	public    Integer   updateUserByUserId(Integer  uid);
	
	@Query("update  UserEntity    set   deleteSwitch='N'  where  userId=:uid")
	@Modifying
	@Transactional
	public Integer      activateUserByUserId(Integer uid);

	public UserEntity findByPasswordAndEmail(String tempPassword, String email);

}
