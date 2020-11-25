package com.wellsfargo.batch5.portfolio.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bro_users")
public class BackOfficeUser extends UserLogin{

	@Column(name="bro_email")
	private String BackOfficeUserEmail;

	public BackOfficeUser() {
		System.out.println("default");
	}

	public BackOfficeUser(String uname, String password, String role,String backOfficeUserEmail) {
		super(uname,password,role);

		BackOfficeUserEmail = backOfficeUserEmail;
	}

	public String getBackOfficeUserEmail() {
		return BackOfficeUserEmail;
	}

	public void setBackOfficeUserEmail(String backOfficeUserEmail) {
		BackOfficeUserEmail = backOfficeUserEmail;
	}

}
