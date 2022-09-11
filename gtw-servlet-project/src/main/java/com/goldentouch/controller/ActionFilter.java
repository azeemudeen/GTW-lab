package com.goldentouch.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("*.demo")
public class ActionFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpRes = (HttpServletResponse) response;
		
		if(httpReq.getSession().isNew()) {
			String formid = httpReq.getParameter("formid");
			if(formid != null && formid.equals("login")) {
				chain.doFilter(request, response);							
			} else {
				httpRes.sendRedirect("expired.jsp");	
			}
		} else {
			chain.doFilter(request, response);			
		}
	}
}
