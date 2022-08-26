package com.goldentouch.service;

import com.goldentouch.dto.User;

public interface UserService {
	boolean checkUserLogin(User user);
	
	boolean registerUser(User newUser);
	
	boolean checkFlag(String uname);
	
	boolean updateFlag(String uname, int flag);
}
