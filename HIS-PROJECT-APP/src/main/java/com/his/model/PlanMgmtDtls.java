package com.his.model;

import java.util.Date;

import lombok.Data;

@Data
public class PlanMgmtDtls {
	
	private  Integer  planId;
	private  String    planName;
	private  String    planDesc;
	private  Date      startDate;
	private  Date      endDate;
	private  String    createdBy;
	private  String    updatedBy;
	private  Date      createdDate;
	private  Date      updatedDate;
	private  String    activeStatus;
	private  String    deleteStatus;
	
	

}
