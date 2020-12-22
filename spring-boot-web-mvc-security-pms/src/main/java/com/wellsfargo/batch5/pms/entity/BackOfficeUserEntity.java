package com.wellsfargo.batch5.pms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BackOfficeUser")
public class BackOfficeUserEntity extends LoginEntity {

	@Column(name="fnm")
	private String firstName;
	
	@Column(name="lnm")
	private String lastName;
	
	public BackOfficeUserEntity() {
		
	}
	
	public BackOfficeUserEntity(Integer userId, String userName, String password, String role, String firstName, String lastName) {
		super(userId,userName,password,role);
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
