package com.wellsfargo.batch5.pms.model;

public class UserLogin {

	private String uname;
	private String password;
	private String role;
	
	public UserLogin() {
		System.out.println("default");
	}
	public UserLogin(String uname, String password, String role) {
		super();
		this.uname = uname;
		this.password = password;
		this.role = role;
		
	}
		
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
