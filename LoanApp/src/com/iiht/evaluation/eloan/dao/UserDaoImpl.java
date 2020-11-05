package com.iiht.evaluation.eloan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import com.iiht.evaluation.eloan.model.User;
import com.iiht.evaluation.eloan.dao.ConnectionDao;

public class UserDaoImpl implements UserDao {


	public static final String SELECT_BY_QRY = "SELECT * FROM User WHERE uname=? and pword=?";
	
	@Override
	public Boolean getByUserDetails(User users) {
		User user = null;
		Boolean status=false;
		try (Connection con = ConnectionDao.connect();
				PreparedStatement pst = con.prepareStatement(SELECT_BY_QRY)) {
			System.out.println("Entering getByUserDetails method");
			pst.setString(1, users.getUsername());
			pst.setString(2, users.getPassword());
			
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				status=true;
				user = new User();
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				

			}

		} catch (SQLException exp) {
			System.out.println(exp);
			exp.printStackTrace();
			
		}
		return status;
	}

}
