package com.iiht.evaluation.eloan.dao;


import com.iiht.evaluation.eloan.model.User;

public interface UserDao {
	Boolean getByUserDetails(User user);
}
