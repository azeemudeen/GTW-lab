package com.goldentouch.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.goldentouch.dto.User;
import com.goldentouch.service.UserService;
import com.goldentouch.service.UserServiceImpl;

public class LoginAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		
		UserService userService = new UserServiceImpl();
		User user = new User(uname, upass);
		
		if(userService.checkUserLogin(user)){
			if(!userService.checkFlag(uname)) {
				HttpSession session = request.getSession();
				session.setAttribute("uname", uname);
				session.setMaxInactiveInterval(60);
				userService.updateFlag(uname, 1);
				
				System.out.println("user.login.success");
				return "user.login.success";				
			} else {
				return "user.login.session.error";
			}
		}
		System.out.println("user.login.failed");
		return "user.login.failed";
	}

}
