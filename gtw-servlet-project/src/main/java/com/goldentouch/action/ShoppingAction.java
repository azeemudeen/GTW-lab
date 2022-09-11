package com.goldentouch.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		addToSession(session, request);
		String shopid = request.getParameter("shopid");
		return shopid;
	}
	
	public void addToSession(HttpSession session,HttpServletRequest req) {
		Enumeration<String> en=req.getParameterNames();
		while(en.hasMoreElements()) {
			String name=en.nextElement();
			session.setAttribute(name, req.getParameter(name));
		}
	}
}
