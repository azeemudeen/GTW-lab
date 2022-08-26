package com.goldentouch.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.goldentouch.service.UserService;
import com.goldentouch.service.UserServiceImpl;

public class LogoutAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		if(request.isRequestedSessionIdValid()){
			HttpSession session = request.getSession(false);
			String uname = (String) session.getAttribute("uname");
			
			UserService userService = new UserServiceImpl();
			boolean isUserLoggedOut = userService.updateFlag(uname, 0);
			if(isUserLoggedOut) {
				request.getSession().invalidate();				
			} else {
				System.out.println("user.logout.failed");
				return "user.logout.failed";
			}
		}
		System.out.println("user.logout.success");
		return "user.logout.success";
	}

}
