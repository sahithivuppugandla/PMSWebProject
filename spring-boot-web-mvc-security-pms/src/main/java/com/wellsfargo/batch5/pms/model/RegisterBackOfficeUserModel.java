package com.wellsfargo.batch5.pms.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterBackOfficeUserModel {

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

	public RegisterBackOfficeUserModel() {

	}

	public RegisterBackOfficeUserModel(String userName, String password, String confimrPassword, String firstName,
			String lastName, String mobileNumber, String addressLine1, String addressLine2, String city) {
		super();
		this.userName = userName;
		this.password = password;
		this.confirmPassword = confimrPassword;
		this.firstName = firstName;
		this.lastName = lastName;

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
}
