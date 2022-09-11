package com.goldentouch.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static DBConnection DBCon;
	private Connection con;
	private final String username = "root";
	private final String password = "root";
	private final String jdbcUrl = "jdbc:mysql://localhost/servletdb";
	
	private DBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection(jdbcUrl,username,password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	synchronized public static DBConnection getInstance() {
		try {
			if(DBCon == null || DBCon.getConnection().isClosed()) {
				DBCon = new DBConnection();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return DBCon;
	}
	
	public Connection getConnection() {
		return con;
	}

}
