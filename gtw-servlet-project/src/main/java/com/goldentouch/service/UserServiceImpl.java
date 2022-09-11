package com.goldentouch.service;

import com.goldentouch.dao.UserDAO;
import com.goldentouch.dao.UserDAOImpl;
import com.goldentouch.dto.User;

public class UserServiceImpl implements UserService{
	
	private UserDAO userDAO;

	public UserServiceImpl() {
		userDAO = new UserDAOImpl();
	}
	
	@Override
	public boolean checkUserLogin(String uname, String upass) {
		boolean loginStatus =  userDAO.checkCredentials(uname, upass);
		return loginStatus;
	}

	@Override
	public boolean registerUser(User newUser) {
		boolean registerStatus = userDAO.insertUser(newUser);
		return registerStatus;
	}
	 
	@Override
	public boolean checkLoginStatus(String uname) {
		boolean isUserLoggedIn = userDAO.getFlag(uname);
		return isUserLoggedIn;
	}
	
	
	@Override
	public boolean updateLoginStatus(String uname, boolean flag) {
		boolean isFlagUpdated = userDAO.updateFlag(uname, flag);
		return isFlagUpdated;
	}
}
