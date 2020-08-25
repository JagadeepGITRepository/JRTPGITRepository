package com.his.service;

import java.util.List;

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
		    BeanUtils.copyProperties(planDtls, planEntity);
		   //invoke the method
		    PlanMgmtDtlsEntity   resultEntity =planDtlsRepo.save(planEntity);
		    
		    return  resultEntity.getPlanId()!=null;
	
	}//end of method
	

	@Override
	public List<PlanMgmtDtls> getAllPlanDetails() {
		
		return null;
	}

	@Override
	public PlanMgmtDtls getPlanDeatilsByplanId(Integer planId) {
		
		return null;
	}

	@Override
	public Boolean deletePlan(Integer planId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean activePlan(Integer planId) {
		// TODO Auto-generated method stub
		return null;
	}

}
