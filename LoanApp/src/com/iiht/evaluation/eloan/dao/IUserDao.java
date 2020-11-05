package com.iiht.evaluation.eloan.dao;


import com.iiht.evaluation.eloan.model.User;
import com.wellsfargo.batch5.pms.exception.LoanException;

public interface IUserDao {
	String getByUserDetails(User user);
	User add(User user)throws LoanException;
}
