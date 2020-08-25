package com.his.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.his.model.PlanMgmtDtls;
import com.his.service.PlanMgmtService;

@Controller
public class ViewPlanController {
	
	@Autowired
	private  PlanMgmtService  planService;
	
	@RequestMapping("/editplan")
	public  String   editPlan(@RequestParam("pIanId") Integer  pId  ,Model model) {
		  PlanMgmtDtls  planDtls=planService.getPlanDeatilsByplanId(pId);
		  
		  System.out.println(planDtls);
		  
		  //Add the PlanDetails to the Model Scope
		   model.addAttribute("planDtls",planDtls);
		   
		   return "redirect:/loadplanForm";
		
	}//end of method
	
	
	@RequestMapping("/deleteplan")
	public String  deletePlan(@RequestParam("pIanId") Integer pId,RedirectAttributes   redirect) {
		    Boolean  isDeleted=planService.deletePlan(pId);
		    if(isDeleted) {
		    	 redirect.addFlashAttribute("msg","Soft Deletion Succeded");
		           return  "redirect:/viewplan";
		    } 
		         redirect.addFlashAttribute("msg", "Soft Deletion Failed");
		         
		         return null;

   }//end of method
	
	
	@RequestMapping("/activeplan")
	public String  activePlan(@RequestParam("pIanId") Integer  pId,RedirectAttributes  redirect ) {
		  Boolean isActivate=planService.activePlan(pId);
		  
		  if(isActivate) {
			  redirect.addFlashAttribute("msg","Plan Activation  Suceeded");
			  return "redirect:/viewplan";
		  }
		  redirect.addFlashAttribute("msg","Plan Activation  Failed");  
		
		   return null;
	}//end of method
	
}//end of class