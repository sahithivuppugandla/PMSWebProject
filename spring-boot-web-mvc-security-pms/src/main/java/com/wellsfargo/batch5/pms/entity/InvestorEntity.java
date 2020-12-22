package com.wellsfargo.batch5.pms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Investor")
public class InvestorEntity extends LoginEntity {

	@Column(name="fnm")
	private String firstName;
	
	@Column(name="lnm")
	private String lastName;
	
	@Column(name="mobile")
	private String mobileNumber;
	
	@Column(name="email")
	private String email;
	
	@Column(name="address")
	private String address;

	public InvestorEntity() {
		
	}
	
	public InvestorEntity(Integer userId, String userName, String password, String role, String firstName, String lastName, String mobile, String email, String address) {
		super(userId,userName,password,role);
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber=mobile;
		this.email=email;
		this.address=address;
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
