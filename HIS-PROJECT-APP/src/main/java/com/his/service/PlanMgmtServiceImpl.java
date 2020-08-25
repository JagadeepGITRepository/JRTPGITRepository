package com.his.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.his.entity.PlanMgmtDtlsEntity;
import com.his.model.PlanMgmtDtls;
import com.his.repository.PlanMgmtDtlsRepository;

@Service
public class PlanMgmtServiceImpl implements PlanMgmtService {
	
	@Autowired
	private PlanMgmtDtlsRepository   planDtlsRepo;

	@Override
	public Boolean savePlanDetails(PlanMgmtDtls planDtls) {
		   //Create  Entity Object
		    PlanMgmtDtlsEntity   planEntity=new PlanMgmtDtlsEntity();
		   //Convert Binding Object to Entity Object
		    planDtls.setDeleteStatus("N");
		    planDtls.setActiveStatus("Y");
		    BeanUtils.copyProperties(planDtls, planEntity);
		    
		   //invoke the method
		    PlanMgmtDtlsEntity   resultEntity =planDtlsRepo.save(planEntity);
		    
		    return  resultEntity.getPlanId()!=null;
	
	}//end of method
	

	@Override
	public List<PlanMgmtDtls> getAllPlanDetails() {
		  List<PlanMgmtDtlsEntity>  resultEntity=planDtlsRepo.findAll();
		  //Create List Object
		  List<PlanMgmtDtls>  planList=new  ArrayList<PlanMgmtDtls>();
		  
		  resultEntity.forEach(entity->{
			     PlanMgmtDtls  plan=new PlanMgmtDtls();
			     //Convert Entity to Model Object
			     BeanUtils.copyProperties(entity, plan);
			     planList.add(plan);
		  });
		  
		return planList;
	}//end of method

	@Override
	public PlanMgmtDtls getPlanDeatilsByplanId(Integer planId) {
		  //invoke the method
		    Optional<PlanMgmtDtlsEntity> planDtls=planDtlsRepo.findById( planId);
		    
		    if(planDtls.isPresent()) {
		    	PlanMgmtDtlsEntity  entity=planDtls.get();
		    	PlanMgmtDtls   plan=new PlanMgmtDtls();
		    	//Convert Entity to Model Object
		    	BeanUtils.copyProperties(entity, plan);
		    	return  plan;
		    }
		return null;
	}

	@Override
	public Boolean deletePlan(Integer planId) {
		 Boolean result=false;
		 //invoke the method
		  Integer  count=planDtlsRepo.updateDeleteStatusById(planId);
		  if(count==1)
			  result=true;
		return result;
	}//end of method

	@Override
	public Boolean activePlan(Integer planId) {
		Boolean  result=false;
		//invoke the method
		Integer count=planDtlsRepo.updateActiveStatusById(planId);
		if(count==1)
			  result=true;
		return  result;
	}//end of method
}//end of class
