package com.wellsfargo.batch5.pms.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="superuser")
public class SuperUserEntity extends LoginEntity{

	public SuperUserEntity() {
		
	}
	
	public SuperUserEntity(Integer userId, String userName, String password, String role) {
		super(userId,userName,password,role);
	}
}
