package com.wellsfargo.batch5.pms.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterInvestorModel {
	@NotNull(message = "User name is mandatory")
	@NotBlank(message = "User name is mandatory")
	@Size(min = 4, max = 20, message = "User name must be of 4 to 15 chars in length")
	private String userName;

	@NotNull(message = "Password is mandatory")
	@NotBlank(message = "Password is mandatory")
	@Size(min = 8, max = 15, message = "Password must between 8 and 15 characters")
	private String password;

	@NotNull(message = "User name is mandatory")
	@NotBlank(message = "User name is mandatory")
	@Size(min = 8, max = 20, message = "Confirm password must be of 8 to 15 chars in length")
	private String confirmPassword;

	@NotNull(message = "First name is mandatory")
	@NotBlank(message = "First name is mandatory")
	@Size(min = 4, max = 20, message = "First name must be of 4 to 15 chars in length")
	private String firstName;

	@NotNull(message = "Last Name is mandatory")
	@NotBlank(message = "Last Name is mandatory")
	@Size(min = 4, max = 20, message = "Last Name must be of 4 to 15 chars in length")
	private String lastName;

	@NotNull(message="Mobile Number is mandate")
	@Pattern(regexp = "[1-9][0-9]{9}",message="Mobile Number should be of 10 digits.")
	private String mobileNumber;
	
	@NotNull(message="Email is mandatory")
	@NotBlank(message="Email is mandatory")	
	private String email;
	
	@NotNull(message="Address is mandatory")
	@NotBlank(message="Address is mandatory")	
	private String address;
	
	public RegisterInvestorModel() {

	}

	public RegisterInvestorModel(String userName, String password, String confirmPassword, String firstName,
			String lastName, String mobileNumber, String email, String address) {
		super();
		this.userName = userName;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber=mobileNumber;
		this.email=email;
		this.address=address;
		

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
