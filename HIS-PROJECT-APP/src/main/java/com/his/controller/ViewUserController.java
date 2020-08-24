package com.his.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.his.model.User;
import com.his.service.UserMgmtService;

@Controller
public class ViewUserController {
	
	@Autowired
	private  UserMgmtService  userService;
        
	@RequestMapping("/editUser")
	public String   editContact(@RequestParam("uid")  Integer  userId,Model model) {
		
		   //invoke the method
		    User user=userService.getUserById(userId);
		    
		    model.addAttribute("user",user);
		    
		  return  "userinfo";
	}//end of method
	
	@RequestMapping("/deleteUser")
	public String  deleteContact(@RequestParam("uid") Integer  userId,RedirectAttributes attributes) {
		       boolean isDeleted=userService.deleteUser(userId);
		       if(isDeleted) {
		    	     attributes.addFlashAttribute("msg","Soft  Deletion   Succeded");
		    	      return  "redirect:/viewAccounts";
		       } else {
		    	      attributes.addFlashAttribute("msg","Soft  Deletion    Failed");
		       }
		              return  null;
	}//end of method
	
	
	@RequestMapping("/activateUser")
	public  String  activeContact(@RequestParam("uid")Integer userId,RedirectAttributes  attributes ) {
		 boolean isActivated=userService.activateUser(userId);
	       if(isActivated) {
	    	     attributes.addFlashAttribute("msg","Account Activated Successfully");
	    	      return  "redirect:/viewAccounts";
	       } else {
	    	      attributes.addFlashAttribute("msg","Account Activation Failed");
	       }
	              return  null;
		
	}
	
}//end of class
