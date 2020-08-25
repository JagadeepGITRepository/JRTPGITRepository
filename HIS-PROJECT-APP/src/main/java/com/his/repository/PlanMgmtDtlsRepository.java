package com.his.repository;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.his.entity.PlanMgmtDtlsEntity;

public interface PlanMgmtDtlsRepository extends JpaRepository<PlanMgmtDtlsEntity,Serializable> {
	
	@Query("update PlanMgmtDtlsEntity  set  deleteStatus='Y',activeStatus='N'  where planId=:pId")
	@Transactional
	@Modifying
	public Integer  updateDeleteStatusById(Integer pId);
	
	@Query("update PlanMgmtDtlsEntity  set  activeStatus='Y',deleteStatus='N'    where planId=:pId")
	@Transactional
	@Modifying
	public Integer  updateActiveStatusById(Integer pId);

}
