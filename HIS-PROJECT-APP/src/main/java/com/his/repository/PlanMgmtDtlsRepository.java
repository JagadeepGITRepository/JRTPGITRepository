package com.his.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.his.entity.PlanMgmtDtlsEntity;

public interface PlanMgmtDtlsRepository extends JpaRepository<PlanMgmtDtlsEntity,Serializable> {

}
