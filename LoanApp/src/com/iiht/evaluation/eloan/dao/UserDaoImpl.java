package com.iiht.evaluation.eloan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.iiht.evaluation.eloan.model.User;
import com.wellsfargo.batch5.pms.exception.LoanException;
import com.iiht.evaluation.eloan.dao.ConnectionDao;

public class UserDaoImpl implements IUserDao {
	Logger log = Logger.getLogger("DAO");

	public static final String SELECT_BY_QRY = "SELECT * FROM User WHERE uname=? and pword=?";
	public static final String INS_QRY = "INSERT INTO User(uname,pword,role) VALUES(?,?,?)";
	
	@Override
	public String getByUserDetails(User users) {
		User user = null;
		Boolean status=false;
		String role = null;
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
				user.setRole(rs.getString(3));
				role=user.getRole();
			}else {
				role="Invalid";
			}

		} catch (SQLException exp) {
			System.out.println(exp);
			exp.printStackTrace();
			
		}
		return role;
	}

	@Override
	public User add(User user) throws LoanException {
		
		
			if (user != null) {
				try (Connection con = ConnectionDao.connect();
						PreparedStatement pst = con.prepareStatement(INS_QRY)) {
					pst.setString(1, user.getUsername());
					pst.setString(2, user.getPassword());
					pst.setString(3, user.getRole());
					pst.executeUpdate();
				} catch (SQLException exp) {
					log.error(exp);
					throw new LoanException("Sorry! An Error Occured While Saving Data!");
				}
			}
			return user;
		}
	

}
