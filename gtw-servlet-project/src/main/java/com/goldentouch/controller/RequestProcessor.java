package com.goldentouch.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.goldentouch.action.Action;

public class RequestProcessor {

	public void process(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServletContext appContext = request.getServletContext();
			String configPath = appContext.getRealPath("WEB-INF/config.properties");
			Properties config = new Properties();
			config.load(new FileInputStream(new File(configPath)));
			
			String formid = request.getParameter("formid");
			String actionClass = config.getProperty(formid);
			Action action = (Action) Class.forName(actionClass).getDeclaredConstructor().newInstance();
			String result = action.execute(request, response);
			String resultHtml = config.getProperty(result);
			RequestDispatcher rd = request.getRequestDispatcher(resultHtml);
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
