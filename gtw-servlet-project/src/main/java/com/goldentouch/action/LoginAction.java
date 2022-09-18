package com.goldentouch.action;

import java.net.HttpURLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.goldentouch.service.UserService;
import com.goldentouch.service.UserServiceImpl;

public class LoginAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		
		UserService userService = new UserServiceImpl();
		
		if(userService.checkUserLogin(uname, upass)){
			if(!userService.checkLoginStatus(uname)) {
				HttpSession session = request.getSession();
				session.setAttribute("uname", uname);
				session.setMaxInactiveInterval(60);
				userService.updateLoginStatus(uname, true);
				
				System.out.println("User:"+uname+" LoggedIn");
				return "user.login.success";				
			} else {
				return "user.login.session.error";
			}
		}
		System.out.println("User:"+uname+" Login failed");
		response.setStatus(HttpURLConnection.HTTP_UNAUTHORIZED);
		return "user.login.failed";
	}

}
