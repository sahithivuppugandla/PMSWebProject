package com.iiht.evaluation.eloan.service;

import com.iiht.evaluation.eloan.model.User;
import com.iiht.evaluation.eloan.dao.UserDaoImpl;
import com.iiht.evaluation.eloan.dao.UserDao;

public class UserService implements IUserService {

	
	private UserDao userDao;
	
	public UserService() {
		this.userDao = new UserDaoImpl();
	}

	
	@Override
	public Boolean getByUserDetails(User user) {
		return userDao.getByUserDetails(user);
	
	}

}
