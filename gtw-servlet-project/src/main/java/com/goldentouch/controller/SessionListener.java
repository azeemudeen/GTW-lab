package com.goldentouch.controller;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.goldentouch.service.UserService;
import com.goldentouch.service.UserServiceImpl;

@WebListener
public class SessionListener implements HttpSessionListener {

    public SessionListener() { }

    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("Session created");
    }

    public void sessionDestroyed(HttpSessionEvent se)  {
    	HttpSession session = se.getSession();
    	String uname = (String) session.getAttribute("uname");
    	if(uname != null) {
    		UserService userService = new UserServiceImpl();
    		userService.updateFlag(uname, 0);
    		System.out.println("User Logged out");
    	}
    	System.out.println("Session destroyed");
    }
	
}
