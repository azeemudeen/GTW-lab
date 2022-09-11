package com.goldentouch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.goldentouch.dto.User;
import com.goldentouch.service.DBConnection;

public class UserDAOImpl implements UserDAO {
	
	private DBConnection DBCon;
	
	public UserDAOImpl() {
		DBCon = DBConnection.getInstance();
	}

	@Override
	public boolean checkCredentials(String uname, String upass) {
		boolean isValidUser = false;
		try {
			Connection con = DBCon.getConnection();
			String sql = "SELECT * FROM users WHERE name=? AND password=?";
			PreparedStatement stmnt = con.prepareStatement(sql);
			stmnt.setString(1, uname);
			stmnt.setString(2, upass);
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
	public boolean insertUser(User user) {
		boolean userCreated = false;
		try {
			Connection con = DBCon.getConnection();
			String sql = "INSERT INTO users(name,password) VALUES(?,?)";
			PreparedStatement stmnt = con.prepareStatement(sql);
			stmnt.setString(1, user.getUsername());
			stmnt.setString(2, user.getPassword());
			
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
	public boolean getFlag(String uname) {
		boolean isUserLoggedIn = false;
		try {
			Connection con = DBCon.getConnection();
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
	public boolean updateFlag(String uname, boolean flag) {
		boolean isFlagUpdated = false;
		try {
			Connection con = DBCon.getConnection();
			String sql = "UPDATE users SET flag=? WHERE name=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setBoolean(1, flag);
			ps.setString(2, uname);
				
			int result = ps.executeUpdate();
			if(result > 0) {
				isFlagUpdated = true;
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isFlagUpdated;
	}

}
