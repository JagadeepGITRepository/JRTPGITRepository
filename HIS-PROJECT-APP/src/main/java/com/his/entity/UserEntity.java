package com.his.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name="USER_MASTER")
public class UserEntity {
	
	@Id
	@Column(name="USER_ID")
	@SequenceGenerator(name="uid_seq_gen",sequenceName = "USER_ID_SEQ",allocationSize =1)
	@GeneratedValue(generator ="uid_seq_gen",strategy = GenerationType.SEQUENCE )
	private Integer   userId;
	
	@Column(name="FIRST_NAME")
	private String   firstName;
	
	@Column(name="LAST_NAME")
	private String   lastName;
	
	@Column(name="EMAIL")
	private String   email;
	
	@Column(name="GENDER")
	private String   gender;
	
	@Column(name="ROLE")
	private String   role;
	
	@Column(name="CREATED_DATE")
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date   createdDate;
	
	@Column(name="UPDATED_DATE")
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	private Date   updatedDate;
	
	@Column(name="DELETE_SWITCH")
	private Character  deleteSwitch;
	
	@Column(name="ACCOUNT_STATUS")
	private String  accountStatus;
	
	@Column(name="PASSWORD")
	private String   password;
}
