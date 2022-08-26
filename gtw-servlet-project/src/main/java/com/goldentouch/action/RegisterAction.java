package com.goldentouch.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goldentouch.dto.User;
import com.goldentouch.service.UserService;
import com.goldentouch.service.UserServiceImpl;

public class RegisterAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		
		UserService userService = new UserServiceImpl();
		User newUser = new User(uname, upass);
				
		boolean userRegistered = userService.registerUser(newUser);
		
		if(userRegistered) {
			System.out.println("user.register.success");
			return "user.register.success";			
		}
		System.out.println("user.register.failed");
		return "user.register.failed";
	}

}
