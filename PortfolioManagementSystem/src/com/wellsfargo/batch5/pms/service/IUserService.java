package com.wellsfargo.batch5.pms.service;

import java.util.List;

import com.wellsfargo.batch5.pms.exception.LibraryException;
import com.wellsfargo.batch5.pms.model.User;
import com.wellsfargo.batch5.pms.model.UserLogin;

public interface IUserService {
	User add(User user) throws LibraryException;
	User save(User user)throws LibraryException;
	void remove(String username) throws LibraryException;
	List<User> listAll() throws LibraryException;
	Boolean getByUserDetails(UserLogin user) throws LibraryException;
	
}
