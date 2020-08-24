package com.his.model;

import lombok.Data;

@Data
public class  User {
	
	private Integer userId;
	private String  firstName;
	private String  lastName;
	private String  email;
	private String  gender;
	private String  role;
	private String accStatus;
	private String password;
	private Character  deleteSwitch;
	

}//end of class
