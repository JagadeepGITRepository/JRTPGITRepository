package com.his.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.his.entity.UserEntity;
import com.his.model.User;
import com.his.repository.UserRepository;
import com.his.utility.PasswordGeneratorUtility;

@Service
public class UserMgmtServiceImpl implements UserMgmtService {
	
	@Autowired
	private UserRepository   userRepo;

	@Override
	public Boolean saveUser(User  user) {
		Boolean isSave = false;
		user.setPassword(PasswordGeneratorUtility.randomAlphaNumeric(4));
		user.setAccStatus("LOCKED");
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(user, entity);
		userRepo.save(entity);
		isSave = true;
		return isSave;
	}

	@Override
	public List<User> getAllUserDetails() {
		     List<UserEntity>  userEntity=userRepo.findAll();
		     List<User>  userList=new ArrayList<>();
		     
		     userEntity.forEach(entity->{
		    	  User  user=new   User();
		    	  BeanUtils.copyProperties(entity, user);
		    	  userList.add(user);
		     });
		   return userList;
	}

	
	

	@Override
	public Boolean deleteUser(Integer userId) {
		   boolean  result=false;
		  //invoke the method
		   Integer  count=userRepo.updateUserByUserId(userId);
		    if(count==1)
		    	result=true;
		   return   result;
	}//end of method


	@Override
	public User getUserById(Integer   userId) {
		//invoke the method
		 Optional<UserEntity> entity=userRepo.findById(userId);
		 //Create User Object
		 User  user=new User();
		 //Convert UserEntity  to User 
		 BeanUtils.copyProperties(entity,user);
		return user;
	}//end of method


	@Override
	public User getAccountDetailsByTempPwd(String tempPassword, String email) {
		
		UserEntity  entity= userRepo.findByPasswordAndEmail(tempPassword,email);
		User   user = null;
		
		if(entity != null) {
			user = new User();
			BeanUtils.copyProperties(entity,user);
		}
		
		return   user;
	}


	@Override
	public Boolean updateAccountDetails(User userDetailsBytempPwd) {
		Boolean isUpdate = false;
		userDetailsBytempPwd.setAccStatus( "UNLOCKED");
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(userDetailsBytempPwd,entity);
		userRepo.save(entity);
		isUpdate = true;
		return isUpdate;
	}

	@Override
	public Boolean activateUser(Integer userId) {
		  boolean  result=false;
		  //invoke the method
		   Integer  count=userRepo.activateUserByUserId(userId);
		    if(count==1)
		    	result=true;
		   return   result;
	}//end of method
}//end of class
