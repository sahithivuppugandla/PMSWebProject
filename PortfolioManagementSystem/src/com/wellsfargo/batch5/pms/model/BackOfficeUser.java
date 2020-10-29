package com.wellsfargo.batch5.pms.model;

public class BackOfficeUser extends User {

	private String BackOfficeUserName;
	private String BackOfficeUserEmail;
	
	
	public BackOfficeUser() {
		System.out.println("default");
	}

	

	public BackOfficeUser(String backOfficeUserName, String backOfficeUserEmail) {
		super();
		BackOfficeUserName = backOfficeUserName;
		BackOfficeUserEmail = backOfficeUserEmail;
	}



	public String getBackOfficeUserName() {
		return BackOfficeUserName;
	}


	public void setBackOfficeUserName(String backOfficeUserName) {
		BackOfficeUserName = backOfficeUserName;
	}


	public String getBackOfficeUserEmail() {
		return BackOfficeUserEmail;
	}


	public void setBackOfficeUserEmail(String backOfficeUserEmail) {
		BackOfficeUserEmail = backOfficeUserEmail;
	}
	
	
	
	
}
