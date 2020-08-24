package com.his.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.his.model.User;
import com.his.service.UserMgmtService;
import com.his.utility.EmailSenderUtility;

@Controller
public class   UserMgmtController {
	
	@Autowired
	private  UserMgmtService   userService;
	
	@Autowired
	private EmailSenderUtility   emailService;
	
	@GetMapping("/loadform")
	public  String  loadForm(Model model) {
		 //Create User Object
		 User user=new User();
		 //set the User object to the Model 
		 model.addAttribute("user",user);
		 return  "userinfo";
	}
	
	@PostMapping("/createUser")
	public String handleCreateButton(@ModelAttribute("user") User user,RedirectAttributes  redirectAttributes,Model model) {
		    
		     redirectAttributes.addFlashAttribute("user",new User());
		    boolean isSaved=userService.saveUser(user);
		    
		    if(isSaved) {
		    	emailService.sendUserAccUnlockMail2(user);
		    	redirectAttributes.addFlashAttribute("msg","Account is created Succcessfully,Check your mail Once");
		    } else {
		    	redirectAttributes.addFlashAttribute("msg", "Account Creation Failed");
		    }
		     return "redirect:/loadform";
	}//end of method
	
	@GetMapping("/viewAccounts")
	public String  handleViewAccountLinks(Model model) {
		
		      List<User>  user= userService.getAllUserDetails();
		      
		      System.out.println(user);
		      
		      model.addAttribute("userList",user);
		
		      return  "viewAccounts";
	}//end of method

}//end  of class
