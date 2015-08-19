package com.bit2015.web.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class WebUtil {
	public static void forward(HttpServletRequest request,HttpServletResponse respone, String path) throws IOException, ServletException{
		RequestDispatcher dispatcher = 
			    request.getServletContext().getRequestDispatcher(path);
			dispatcher.forward(request, respone);
		
	}
	public static void redirect(		
			HttpServletRequest request,
			HttpServletResponse respone,
			String url)throws IOException{
		respone.sendRedirect(url);
		
	}
}
