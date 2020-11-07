package com.iiht.evaluation.eloan.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iiht.evaluation.eloan.dao.ConnectionDao;
import com.iiht.evaluation.eloan.dto.LoanDto;
import com.iiht.evaluation.eloan.model.ApprovedLoan;
import com.iiht.evaluation.eloan.model.LoanInfo;
import com.iiht.evaluation.eloan.service.ILoanApproveService;
import com.iiht.evaluation.eloan.service.ILoanInfoService;
import com.iiht.evaluation.eloan.service.LoanApproveServiceImpl;
import com.iiht.evaluation.eloan.service.LoanInfoServiceImpl;
import com.mysql.cj.Session;
import com.wellsfargo.batch5.pms.exception.LoanException;


@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConnectionDao connDao;
	private ILoanInfoService loanService;
	private ILoanApproveService loanApproveService;

	
	public void setConnDao(ConnectionDao connDao) {
		this.connDao = connDao;
	}
	public void init(ServletConfig config) {
		String jdbcURL = config.getServletContext().getInitParameter("jdbcUrl");
		String jdbcUsername = config.getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = config.getServletContext().getInitParameter("jdbcPassword");
		System.out.println(jdbcURL + jdbcUsername + jdbcPassword);
		this.connDao = new ConnectionDao(jdbcURL, jdbcUsername, jdbcPassword);
		this.loanService = new LoanInfoServiceImpl();
		this.loanApproveService= new LoanApproveServiceImpl();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action =  request.getParameter("action");
		System.out.println(action);
		String viewName = "";
		try {
			switch (action) {
			case "listall" : 
				viewName = listall(request, response);
				break;
			case "process":
				viewName=process(request,response);
				break;
			case "calemi":
				viewName=calemi(request,response);
				break;
			case "updatestatus":
				viewName=updatestatus(request,response);
				break;
			case "logout":
				viewName = adminLogout(request, response);
				break;	
			default : viewName = "notfound.jsp"; break;		
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		RequestDispatcher dispatch = 
					request.getRequestDispatcher(viewName);
		dispatch.forward(request, response);
		
		
	}

	private String updatestatus(HttpServletRequest request, HttpServletResponse response) throws SQLException, LoanException {
		// TODO Auto-generated method stub
		/* write the code for updatestatus of loan and return to admin home page */
		
		int applno = Integer.parseInt(request.getParameter("applno"));
		Boolean isUpdated = loanService.updateStatus(applno, "Approved");
		if(isUpdated) {
		request.setAttribute("msg", "Loan no" +applno+ "Approved Succesfully");
		}else {
		request.setAttribute("msg", "Encountered problem while approving Loan no" +applno );
		}

		return "adminhome1.jsp";
		}
	
	private String calemi(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
	/* write the code to calculate emi for given applno and display the details */
		int applno = Integer.parseInt(request.getParameter("appNum"));
		
		ApprovedLoan approvedloan = new ApprovedLoan();
		approvedloan.setApplno(applno);
		approvedloan.setAmotsanctioned(Integer.parseInt(request.getParameter("loanAmount")));
		approvedloan.setLoanterm(Integer.parseInt(request.getParameter("loanDuration")));
		approvedloan.setPsd(LocalDate.now());
		approvedloan.setLcd(LocalDate.now());
		approvedloan.setInterestRate(Integer.parseInt(request.getParameter("interestRate")));
	
		
		int term = (approvedloan.getAmotsanctioned())*(1 + approvedloan.getInterestRate()/100)^(approvedloan.getLoanterm());
		int emi = term/(approvedloan.getLoanterm());
		
		approvedloan.setEmi(emi);
		
		String view="";
		
		try {
			
			loanApproveService.calemi(approvedloan);
			loanService.updateStatus(applno, "Approved");
			request.setAttribute("loanapproved",approvedloan);
			request.setAttribute("approve", "Loan Approved Successfully");
			
			view="adminhome1.jsp";
		}catch(LoanException e) {
			request.setAttribute("errs", e.getMessage());
			request.setAttribute("loanapproved",approvedloan);
			view="errorPage.jsp";
		}
		return view;
	}
	private String process(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		// TODO Auto-generated method stub
	/* return to process page */
		int applno = Integer.parseInt(request.getParameter("applno"));
		request.setAttribute("appNum", applno);
		return  "calemi.jsp";
	}
	private String adminLogout(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	/* write code to return index page */
		return null;
	}

	private String listall(HttpServletRequest request, HttpServletResponse response) throws SQLException, LoanException {
		request.setAttribute("loansList", loanService.listAll());
		return "listall.jsp";
	}

	
}