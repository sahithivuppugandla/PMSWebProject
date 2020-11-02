package com.wellsfargo.batch5.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.batch5.pms.exception.LibraryException;
import com.wellsfargo.batch5.pms.model.UserLogin;
import com.wellsfargo.batch5.pms.service.IUserService;
import com.wellsfargo.batch5.pms.service.UserServiceImpl;

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
	UserLogin loginDetails= new UserLogin()	;
	boolean status = false;
	IUserService user= new UserServiceImpl();
	String username= request.getParameter("username");
	String password= request.getParameter("password");
	String role= request.getParameter("role");
	
	loginDetails.setUname(username);
	loginDetails.setPassword(password);
	loginDetails.setRole(role);
	try {
		status= user.getByUserDetails(loginDetails);
	} catch (LibraryException e) {
		e.printStackTrace();
	}
	
	if(status && loginDetails.getRole().equalsIgnoreCase("Admin")) {
		request.getRequestDispatcher("/Admin.jsp").forward(request, response);
	}else if(status && loginDetails.getRole().equalsIgnoreCase("Investor")) {
		request.getRequestDispatcher("/Investor.jsp").forward(request, response);
	}
	else if(status && loginDetails.getRole().equalsIgnoreCase("Back Office Representative")){
		request.getRequestDispatcher("/BackOfficeRepresentative.jsp").forward(request, response);
	}else {
		request.getRequestDispatcher("/Error.jsp").forward(request, response);
	}
	}

}
