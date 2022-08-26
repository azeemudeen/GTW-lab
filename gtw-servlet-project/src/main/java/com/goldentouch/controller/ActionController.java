package com.goldentouch.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goldentouch.service.DBConnection;

@WebServlet("*.demo")
public class ActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestProcessor rp;
	
    public ActionController() {
        rp = new RequestProcessor();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rp.process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	public void destroy() {
		DBConnection.closeConnection();
	}
}
