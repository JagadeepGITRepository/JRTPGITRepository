package com.his.service;

import java.util.List;


import com.his.model.User;

public interface   UserMgmtService {
	
	public  Boolean   saveUser(User   user);
	public List<User>  getAllUserDetails();
	public User              getUserById(Integer userId);
	public Boolean    activateUser(Integer userId);
	public Boolean  deleteUser(Integer  userId);
	public User getAccountDetailsByTempPwd(String tempPassword, String email);
	public Boolean updateAccountDetails(User userDetailsBytempPwd);
	
}