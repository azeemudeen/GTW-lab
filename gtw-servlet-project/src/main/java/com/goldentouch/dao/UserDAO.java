package com.goldentouch.dao;

import com.goldentouch.dto.User;

public interface UserDAO {
	boolean checkCredentials(String uname, String upass);
	
	boolean insertUser(User user);
	
	boolean getFlag(String uname);
	
	boolean updateFlag(String uname, boolean flag);
}
