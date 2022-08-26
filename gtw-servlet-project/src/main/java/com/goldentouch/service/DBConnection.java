package com.goldentouch.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static Connection con;
	
	private DBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	synchronized public static Connection getConnection() {
		try {
			if(con == null) {
				String username = "root";
				String password = "root";
				String jdbcUrl = "jdbc:mysql://localhost/servletdb";
				con = DriverManager.getConnection(jdbcUrl,username,password);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	synchronized public static void closeConnection(){
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
