package com.wellsfargo.batch5.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String username= request.getParameter("username");
	String password= request.getParameter("password");
	String role= request.getParameter("role");
	
	if(username.equalsIgnoreCase("test")&& password.equalsIgnoreCase("test")&&role.equalsIgnoreCase("Admin")) {
		request.getRequestDispatcher("/Admin.jsp").forward(request, response);
	}else if(username.equalsIgnoreCase("test")&&password.equalsIgnoreCase("test")&&role.equalsIgnoreCase("Investor")) {
		request.getRequestDispatcher("/Investor.jsp").forward(request, response);
	}
	else {
		request.getRequestDispatcher("/BOR.jsp").forward(request, response);
	}
	}

}
