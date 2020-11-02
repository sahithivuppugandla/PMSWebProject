package com.wellsfargo.batch5.pms.service;

import java.awt.print.Book;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.wellsfargo.batch5.pms.dao.IUserDao;
import com.wellsfargo.batch5.pms.dao.UserDaoImpl;
import com.wellsfargo.batch5.pms.exception.LibraryException;
import com.wellsfargo.batch5.pms.model.User;
import com.wellsfargo.batch5.pms.model.UserLogin;

public class UserServiceImpl implements IUserService{
	
	private IUserDao userDao;
	
	public UserServiceImpl() {
		this.userDao = new UserDaoImpl();
	}

	
	private boolean isValidUserName(String username) {
		return username!=null && username.length()>=4;
	}
	
	private boolean isValidPassword(String password) {
		return password!=null && password.length()>=4;	}
	
	private boolean isValidRole(String role) {
		return role!=null && (role.equalsIgnoreCase("admin") || role.equalsIgnoreCase("investor") || role.equalsIgnoreCase("Back Office Representative"));
	} 
	
	
	private void validateUser(User user) throws LibraryException{
		List<String> errMsgs = new ArrayList<String>();
		
		if(!isValidUserName(user.getUname())) {
			errMsgs.add("User name not valid");
		}
		
		if(!isValidPassword(user.getPassword())) {
			errMsgs.add("Password not valid");
		}
		
		if(!isValidRole(user.getRole())) {
			errMsgs.add("Role not valid");
		}
		
		if(!errMsgs.isEmpty()) {
			throw new LibraryException(errMsgs.toString());
		}
	}

	
	@Override
	public User add(User user) throws LibraryException {
		if(user!=null) {
			validateUser(user);
			userDao.add(user);
		}
		return user;
	}

	@Override
	public User save(User user) throws LibraryException {
		if(user!=null) {
			validateUser(user);
			userDao.save(user);
		}
		return user;
	}

	@Override
	public void remove(String username) throws LibraryException {
		userDao.remove(username);		
	}

	@Override
	public List<User> listAll() throws LibraryException {
		return userDao.listAll();
	}

	@Override
	public Boolean getByUserDetails(UserLogin user) throws LibraryException {
		return userDao.getByUserDetails(user);
	}

	
}
