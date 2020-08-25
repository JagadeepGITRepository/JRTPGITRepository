package com.his.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.his.model.PlanMgmtDtls;

@Service
public interface PlanMgmtService {
	
	  public  Boolean   savePlanDetails(PlanMgmtDtls  planDtls);
	  public  List<PlanMgmtDtls>   getAllPlanDetails();
	  public  PlanMgmtDtls    getPlanDeatilsByplanId(Integer  planId );
	  public  Boolean      deletePlan(Integer planId);
	  public  Boolean      activePlan(Integer planId);

}//end of class
