package com.his.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name="PLAN_DTLS")
public class PlanMgmtDtlsEntity {
	
	@Id
	@SequenceGenerator(name = "plan_id_gen",sequenceName ="PLAN_ID_SEQ",allocationSize =1)
	@GeneratedValue(generator ="plan_id_gen",strategy = GenerationType.SEQUENCE)
    @Column(name="PLAN_ID") 
	private  Integer  planId;
	
	
	@Column(name="PLAN_NAME")
	private String     planName;
	
	
	@Column(name="PLAN_DESC")
	private String    planDesc;
	
	
	@Column(name="START_DATE")
	private Date      startDate;
	
	
	@Column(name="END_DATE")
	private Date      endDate;
	
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date      createdDate;
	
	
     @UpdateTimestamp
     @Temporal(TemporalType.DATE)
     @Column(name="UPDATED_DATE")
	private Date     updatedDate;
     
     
     @Column(name="CREATED_BY")
	private String   createdBy;
     
     
     
     @Column(name="UPDATED_BY")
	private String   updatedBy;
     
     
     @Column(name="DELETE_STATUS")
     private String   deleteStatus;
     
     
     @Column(name="ACTIVE_STATUS")
     private String   activeStatus;

}//end of class
