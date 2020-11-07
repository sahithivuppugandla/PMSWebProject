package com.iiht.evaluation.eloan.service;


import com.iiht.evaluation.eloan.model.User;
import com.wellsfargo.batch5.pms.exception.LoanException;

public interface IUserService {

	String getByUserDetails(User user);
	User add(User user)throws LoanException;
}
