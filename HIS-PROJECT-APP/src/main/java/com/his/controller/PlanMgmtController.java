package com.his.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.his.model.PlanMgmtDtls;
import com.his.service.PlanMgmtService;

@Controller
public class PlanMgmtController {
	
	@Autowired
	private PlanMgmtService    planService;
	
	
	@GetMapping(value = {"/","/loadplanForm"})
	public   String    loadPlanRegisterForm(Model  model) {
		  //Create Binding Class Object
		  PlanMgmtDtls   planDtls=new PlanMgmtDtls();
		  //Add the Binding Object to the Model Scope
		  model.addAttribute("planDtls",planDtls);
		  return "registerPlanDtls";
	}//end of method
	
	@PostMapping("/registerPlan")
	public  String    registerPlanDetails(@ModelAttribute("planDtls")PlanMgmtDtls planDtls,RedirectAttributes attributes) {
		     Boolean  isSaved=planService.savePlanDetails(planDtls);
		     
		     if(isSaved) {
		    	    attributes.addFlashAttribute("msg","Plan Deatils  Registration Succeded");
		    	    return   "redirect:/plan/loadForm";
		     }
		           attributes.addFlashAttribute("msg","Plan Deatils  Registration Failed ");
		           return   "redirect:/plan/loadForm";
	  }//end of method
	
	
	@GetMapping("/viewplan")
	public  String    viewAllPlans(Model model) {
		   List<PlanMgmtDtls>  planList=planService.getAllPlanDetails();
		   System.out.println(planList);
		   //Add the List Object to the Model Scope
		   model.addAttribute("planList",planList);
		   
		   return "viewplan";
	}

}//end of class
