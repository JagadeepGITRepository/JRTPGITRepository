package com.his.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.his.model.PlanMgmtDtls;
import com.his.service.PlanMgmtService;

@Controller
@RequestMapping("/plan")
public class PlanMgmtController {
	
	@Autowired
	private PlanMgmtService    planService;
	
	
	@GetMapping(value = {"/","/loadForm"})
	public   String    loadPlanRegisterForm(Model  model) {
		  //Create Binding Class Object
		  PlanMgmtDtls   planDtls=new PlanMgmtDtls();
		  //Add the Binding Object to the Model Scope
		  model.addAttribute("palnDtls",planDtls);
		  return "registerPlanDtls";
	}//end of method

}//end of class
