package org.simran.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String dbhost = "jdbc:mysql://localhost:3306/jsdemo?autoReconnect=true&useSSL=false";
	private static String username = "root";
	private static String password = "root";
	private static Connection conn;
	
	@SuppressWarnings("finally")
	public static Connection createNewDBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			conn = DriverManager.getConnection(dbhost,username,password);
		}
		catch(SQLException e) {
			System.out.println("Can't create database connection");
			e.printStackTrace();
		}
		finally {
			return conn;
		}
	}

}
