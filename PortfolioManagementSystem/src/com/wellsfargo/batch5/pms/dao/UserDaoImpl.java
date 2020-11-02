package com.wellsfargo.batch5.pms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.wellsfargo.batch5.pms.exception.LibraryException;
import com.wellsfargo.batch5.pms.model.User;
import com.wellsfargo.batch5.pms.model.UserLogin;

public class UserDaoImpl implements IUserDao {

	Logger log = Logger.getLogger("DAO");

	public static final String INS_QRY = "INSERT INTO User(username,password,role) VALUES(?,?,?)";
	public static final String UPD_QRY = "UPDATE TABLE User SET username=?,password=?,role=? WHERE username=?";
	public static final String DEL_QRY = "DELETE FROM User WHERE username=?";
	public static final String SELECT_ALL_QRY = "SELECT username,password,role FROM User";
	public static final String SELECT_BY_QRY = "SELECT * FROM UserLogin WHERE username=? and password=? and role=?";

	@Override
	public User add(User user) throws LibraryException {
		if (user != null) {
			try (Connection con = ConnectionProvider.getConnection();
					PreparedStatement pst = con.prepareStatement(INS_QRY)) {
				
				pst.setString(1, user.getUname());
				pst.setString(2, user.getPassword());
				pst.setString(3, user.getRole());
				pst.executeUpdate();
			} catch (SQLException exp) {
				log.error(exp);
				throw new LibraryException("Sorry! An Error Occured While Saving Data!");
			}
		}
		return user;
	}

	@Override
	public User save(User user) throws LibraryException {
		if (user != null) {
			try (Connection con = ConnectionProvider.getConnection();
					PreparedStatement pst = con.prepareStatement(UPD_QRY)) {

				pst.setString(1, user.getUname());
				pst.setString(2, user.getPassword());
				pst.setString(3, user.getRole());
				pst.setString(4, user.getUname());

				pst.executeUpdate();
			} catch (SQLException exp) {
				log.error(exp);
				throw new LibraryException("Sorry! An Error Occured While Saving Data!");
			}
		}
		return user;
	}

	@Override
	public void remove(String username) throws LibraryException {
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement pst = con.prepareStatement(DEL_QRY)) {

			pst.setString(1, username);

			pst.executeUpdate();
		} catch (SQLException exp) {
			log.error(exp);
			throw new LibraryException("Sorry! An Error Occured While Deleting Data!");
		}

	}

	@Override
	public List<User> listAll() throws LibraryException {
		List<User> users = new ArrayList<>();
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement pst = con.prepareStatement(SELECT_ALL_QRY)) {

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				User user = new User();
				
				pst.setString(1, user.getUname());
				pst.setString(2, user.getPassword());
				pst.setString(3, user.getRole());

				users.add(user);
			}

		} catch (SQLException exp) {
			log.error(exp);
			throw new LibraryException("Sorry! An Error Occured While Fetching Data!");
		}
		return users;
	}

	@Override
	public Boolean getByUserDetails(UserLogin users) throws LibraryException {
		UserLogin user = null;
		Boolean status=false;
		try (Connection con = ConnectionProvider.getConnection();
				PreparedStatement pst = con.prepareStatement(SELECT_BY_QRY)) {
			System.out.println("Entering getByUserDetails method");
			pst.setString(1, users.getUname());
			pst.setString(2, users.getPassword());
			pst.setString(3, users.getRole());
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				status=true;
				user = new UserLogin();
				user.setUname(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setRole(rs.getString(3));

			}

		} catch (SQLException exp) {
			log.error(exp);
			exp.printStackTrace();
			throw new LibraryException("Sorry! An Error Occured While Fetching Data!");
		}
		return status;
	}

}
