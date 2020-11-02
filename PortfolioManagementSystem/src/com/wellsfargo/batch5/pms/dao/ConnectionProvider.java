package com.wellsfargo.batch5.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class loaded");
		} catch (ClassNotFoundException e) {
			System.out.println("Application Critically Terminated");
			System.exit(0);
		}
	}

	public static Connection getConnection() throws SQLException {
		System.out.println("Entered get connection method");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/PMS?useSSL=false","root","newpwd");
		
	}
}
