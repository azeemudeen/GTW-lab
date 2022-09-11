package com.goldentouch.service;

import com.goldentouch.dto.User;

public interface UserService {
	
	boolean checkUserLogin(String uname, String upass);
	
	boolean registerUser(User newUser);
	
	boolean checkLoginStatus(String uname);
	
	boolean updateLoginStatus(String uname, boolean flag);
	
}
