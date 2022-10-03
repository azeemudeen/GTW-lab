package com.goldentouch.action;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

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

	@SuppressWarnings("unchecked")
	public void addToSession(HttpSession session, HttpServletRequest req) {
		Map<String,String> shoppingList = (Map<String, String>) session.getAttribute("shoppingList");
		if(shoppingList == null) {
			shoppingList = new HashMap<String, String>();
		}
		Enumeration<String> en=req.getParameterNames();
		while(en.hasMoreElements()) {
			String name=en.nextElement();
			if(name.startsWith("i")) {
				shoppingList.put(name,req.getParameter(name));				
			}
		}
		session.setAttribute("shoppingList", shoppingList);
	}
}
