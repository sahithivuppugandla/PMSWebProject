package com.wellsfargo.batch5.pms.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*@WebServlet("/si")
public class SimpleInterestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ILoanService loanService;

	public void init(ServletConfig config) throws ServletException {
		loanService = new LoanServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Loan loan = new Loan();
		loan.setLoanAmount(Double.parseDouble(request.getParameter("loanAmount")));
		loan.setDisbursmentDate(LocalDate.parse(request.getParameter("disbursmentDate")));
		loan.setRate(Double.parseDouble(request.getParameter("rate")));
		
		loan = loanService.computeInterest(loan);
	
		String view = "simple_interest_display_page.jsp";
		
		request.setAttribute("loan", loan);
		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}*/

//}
