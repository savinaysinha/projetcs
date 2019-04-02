package com.yash.tmsapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.PreparedStatement;

/**
 * This will be used to geting PreparedStatement object and will perform shutdown activities
 * @author savinay.sinha
 *
 */
public class DBUtill {

	private static String driverClassName="com.mysql.jdbc.Driver";
	private static Connection con = null;
	private static PreparedStatement pstmt = null;
	/**
	 * this static block will be used to load the driver of the database if found
	 * other wise will return RuntimeException with message saying "Database Driver is Not available". 
	 */
	static {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Database Driver is Not available");

		}
	}
	
	/**
	 * this the helper method that will be used to create the Connection object if found other will throw the RuntimeException with
	 * message saying "There is Problem in DataBase While establishing the connection"  
	 * @return Connection object if no exception occurred otherwise return null
	 */
	private Connection connect() {
	
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/pbdb", "root", "root");
			
			
		} catch (SQLException e) {
			throw new RuntimeException("There is Problem in DataBase While establishing the connection");
		}
		return con;
	}
	
	public PreparedStatement preparedConnection(String sql) {
		con=connect();
		try {
			
			pstmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			throw new RuntimeException("Prepare Statement is not Created");
		}
		
		return pstmt;
	}

}
