package com.goldentouch.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.goldentouch.dto.User;

public class UserServiceImpl implements UserService{

	@Override
	public boolean checkUserLogin(User user) {
		boolean isValidUser = false;
		try {
			Connection con = DBConnection.getConnection();
			String sql = "SELECT * FROM users WHERE name=? AND password=?";
			PreparedStatement stmnt = con.prepareStatement(sql);
			stmnt.setString(1, user.getUsername());
			stmnt.setString(2, user.getPassword());
			ResultSet rs = stmnt.executeQuery();
			if (rs.next()) {
				isValidUser = true;
			}
			stmnt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isValidUser;
	}

	@Override
	public boolean registerUser(User newUser) {
		boolean userCreated = false;
		try {
			Connection con = DBConnection.getConnection();
			String sql = "INSERT INTO users(name,password) VALUES(?,?)";
			PreparedStatement stmnt = con.prepareStatement(sql);
			stmnt.setString(1, newUser.getUsername());
			stmnt.setString(2, newUser.getPassword());
			
			int result = stmnt.executeUpdate();
			if(result > 0) {
				userCreated = true;
			}
			stmnt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userCreated;
	}
	
	@Override
	public boolean checkFlag(String uname) {
		boolean isUserLoggedIn = false;
		try {
			Connection con = DBConnection.getConnection();
			String sql = "SELECT flag FROM users WHERE name=?";
			PreparedStatement stmnt = con.prepareStatement(sql);
			stmnt.setString(1, uname);
			
			ResultSet rs = stmnt.executeQuery();
			if(rs.next()) {
				isUserLoggedIn = rs.getBoolean("flag");
			}
			stmnt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUserLoggedIn;
	}
	
	
	@Override
	public boolean updateFlag(String uname, int flag) {
		boolean isFlagUpdated = false;
		try {
			Connection con = DBConnection.getConnection();
			String sql = "UPDATE users SET flag=? WHERE name=?";
			PreparedStatement stmnt = con.prepareStatement(sql);
			stmnt.setInt(1, flag);
			stmnt.setString(2, uname);
				
			int result = stmnt.executeUpdate();
			if(result > 0) {
				isFlagUpdated = true;
			}
			stmnt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isFlagUpdated;
	}
}
