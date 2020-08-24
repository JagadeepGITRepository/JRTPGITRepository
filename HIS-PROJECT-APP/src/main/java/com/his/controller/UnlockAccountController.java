package com.his.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.his.model.UnlockAccount;
import com.his.model.User;
import com.his.service.UserMgmtService;

public class UnlockAccountController {
	

		@Autowired
		private UserMgmtService   userService;

		@GetMapping("/login")
		public String Login(@RequestParam("email") String mail, @RequestParam("OTP") String otp, Model model) {

			UnlockAccount    account = new UnlockAccount();
			model.addAttribute("mail", mail);
			model.addAttribute("otp", otp);
			model.addAttribute("unlockAccount", account);

			return "unlockAccount";

		};

		@PostMapping("/readPassword")
		public String readForm(@ModelAttribute("confirmPwd") UnlockAccount acc, Model model) {
			UnlockAccount    account = new UnlockAccount();
			model.addAttribute("unLockBind", account);
			try {

				User      userDetailsBytempPwd = userService.getAccountDetailsByTempPwd(acc.getTempPassword(),
						 acc.getEmail());

				if (userDetailsBytempPwd != null) {

					userDetailsBytempPwd.setPassword(acc.getConfirmPassword());

					Boolean updateFormData = userService.updateAccountDetails(userDetailsBytempPwd);
					if (updateFormData != null) {
						return "confirmAccount";
					}

				}
			} catch (Exception e) {

			}

			model.addAttribute("errorMsg", "Please Check Your  TempPassword");
			account.setEmail(acc.getEmail());

			return "unlockAccount";

		};

	

}
