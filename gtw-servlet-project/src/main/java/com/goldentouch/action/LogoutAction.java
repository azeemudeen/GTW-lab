package com.goldentouch.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.goldentouch.service.UserService;
import com.goldentouch.service.UserServiceImpl;

public class LogoutAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession(false);
		String uname = (String) session.getAttribute("uname");

		UserService userService = new UserServiceImpl();
		boolean isUserLoggedOut = userService.updateLoginStatus(uname, false);
		if (isUserLoggedOut) {
			request.getSession().invalidate();
			return "user.logout.success";
		} else {
			System.out.println("User:" + uname + " Logout Failed");
			return "user.logout.failed";
		}
	}

}
