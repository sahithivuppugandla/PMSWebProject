package com.iiht.evaluation.eloan.service;

import com.iiht.evaluation.eloan.model.User;
import com.wellsfargo.batch5.pms.exception.LoanException;
import com.iiht.evaluation.eloan.dao.UserDaoImpl;
import com.iiht.evaluation.eloan.dao.IUserDao;

public class UserService implements IUserService {

	
	private IUserDao userDao;
	
	public UserService() {
		this.userDao = new UserDaoImpl();
	}

	
	@Override
	public String getByUserDetails(User user) {
		return userDao.getByUserDetails(user);
	
	}


	@Override
	public User add(User user) throws LoanException {
		if(user!=null) {
			
			userDao.add(user);
		}
		return user;
	}

}
