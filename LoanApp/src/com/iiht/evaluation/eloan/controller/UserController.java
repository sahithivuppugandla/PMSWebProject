package com.iiht.evaluation.eloan.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iiht.evaluation.eloan.dao.ConnectionDao;
import com.iiht.evaluation.eloan.dao.LoanInfoImpl;
import com.iiht.evaluation.eloan.model.LoanInfo;
import com.iiht.evaluation.eloan.model.User;
import com.iiht.evaluation.eloan.service.ILoanInfoService;
import com.iiht.evaluation.eloan.service.IUserService;
import com.iiht.evaluation.eloan.service.LoanInfoServiceImpl;
import com.iiht.evaluation.eloan.service.UserService;
import com.wellsfargo.batch5.pms.exception.LoanException;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConnectionDao connDao;
	private IUserService userService;
	private ILoanInfoService loanInfoService;

	public void setConnDao(ConnectionDao connDao) {
		this.connDao = connDao;
	}

	public void init(ServletConfig config) {
		String jdbcURL = config.getServletContext().getInitParameter("jdbcUrl");
		String jdbcUsername = config.getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = config.getServletContext().getInitParameter("jdbcPassword");
		System.out.println(jdbcURL + jdbcUsername + jdbcPassword);
		this.connDao = new ConnectionDao(jdbcURL, jdbcUsername, jdbcPassword);
		this.userService = new UserService();
		this.loanInfoService= new LoanInfoServiceImpl();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		String viewName = "";
		try {
			switch (action) {
			case "registernewuser":
				viewName = registernewuser(request, response);
				break;
			case "validate":
				viewName = validate(request, response);
				break;
			case "placeloan":
				viewName = placeloan(request, response);
				break;
			case "application1":
				viewName = application1(request, response);
				break;
			case "editLoanProcess":
				viewName = editLoanProcess(request, response);
				break;
			case "registeruser":
				viewName = registerUser(request, response);
				break;
			case "register":
				viewName = register(request, response);
				break;
			case "application":
				viewName = application(request, response);
				break;
			case "trackloan":
				viewName = trackloan(request, response);
				break;
			case "editloan":
				viewName = editloan(request, response);
				break;
			case "displaystatus":
				viewName = displaystatus(request, response);
				break;
			default:
				viewName = "notfound.jsp";
				break;
			}
		} catch (Exception ex) {

			throw new ServletException(ex.getMessage());
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(viewName);
		dispatch.forward(request, response);
	}

	private String validate(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		User loginDetails = new User();
		String role = null;
		String view = "";

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		loginDetails.setUsername(username);
		loginDetails.setPassword(password);

		try {
			role = userService.getByUserDetails(loginDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (role.equalsIgnoreCase("Admin")) {

			view = "/adminhome1.jsp";
		} else if (role.equalsIgnoreCase("User")) {
			view = "/userhome.jsp";
		} else {
			view = "/errorPage.jsp";
		}
		request.setAttribute("username", loginDetails.getUsername());
		return view;
	}

	private String placeloan(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		LoanInfo loaninfo= new LoanInfo();
		
		loaninfo.setPurpose(request.getParameter("loanName"));
		loaninfo.setAmtrequest(Integer.parseInt(request.getParameter("loanAmount")));
		loaninfo.setDoa(LocalDate.parse(request.getParameter("loanApplicationDate")));
		loaninfo.setBstructure(request.getParameter("businessStructure"));
		loaninfo.setBindicator(request.getParameter("billingIndicator"));
		loaninfo.setTindicator(request.getParameter("taxIndicator"));
		loaninfo.setAddress(request.getParameter("contactAddress"));
		loaninfo.setEmail(request.getParameter("contactEmail"));
		loaninfo.setMobile(Integer.parseInt(request.getParameter("contactMobile")));
		
	
		String view="";
		
		try {
			loanInfoService.apply(loaninfo);
			request.setAttribute("msg", "Application Submitted Successfully"+" "+"Application Number:"+" "+loaninfo.getApplno());
			view="userhome.jsp";
		}catch(LoanException e) {
			request.setAttribute("errs", e.getMessage());
			request.setAttribute("loaninfo",loaninfo);
			view="errorPage.jsp";
		}
		return view;
	}

	private String application1(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write the code to display the loan application page */

		return "application.jsp";
	}

	private String editLoanProcess(HttpServletRequest request, HttpServletResponse response) throws SQLException, LoanException {
		LoanInfo loaninfo= new LoanInfo();
		String appNum=request.getParameter("id");
		loaninfo.setPurpose(request.getParameter("loanName"));
		loaninfo.setAmtrequest(Integer.parseInt(request.getParameter("loanAmount")));
		loaninfo.setDoa(LocalDate.parse(request.getParameter("loanApplicationDate")));
		loaninfo.setBstructure(request.getParameter("businessStructure"));
		loaninfo.setBindicator(request.getParameter("billingIndicator"));
		loaninfo.setTindicator(request.getParameter("taxIndicator"));
		loaninfo.setAddress(request.getParameter("contactAddress"));
		loaninfo.setEmail(request.getParameter("contactEmail"));
		loaninfo.setMobile(Integer.parseInt(request.getParameter("contactMobile")));
		loaninfo.setApplno(Integer.parseInt(appNum));
		loanInfoService.save(loaninfo);
		request.setAttribute("msg", "Application Edited Successfully"+" "+"Application Number:"+" "+loaninfo.getApplno());
		return "userhome.jsp";
	}

	private String registerUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, LoanException {
		String username = request.getParameter("loginid");
		String password = request.getParameter("password");
		User user = new User(username, password, "User");
		userService.add(user);
		return "newuserui.jsp";
	}

	private String registernewuser(HttpServletRequest request, HttpServletResponse response) throws SQLException {

		return "register.jsp";
	}

	private String register(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write the code to redirect to register page */

		return null;
	}

	private String displaystatus(HttpServletRequest request, HttpServletResponse response) throws SQLException, LoanException {
		// TODO Auto-generated method stub
		/*
		 * write the code the display the loan status based on the given application
		 * number
		 */
		int applno = Integer.parseInt(request.getParameter("applicationNum"));
		request.setAttribute("loan", loanInfoService.trackById(applno));

		return "loanDetails.jsp";
		
	}

	private String editloan(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, LoanException {
		 String appNum = request.getParameter("applicationNum");
	        LoanInfo exLoanInfo = loanInfoService.trackById(Integer.parseInt(appNum));
	        if(exLoanInfo.getStatus().equalsIgnoreCase("Submitted")) {
	        	  request.setAttribute("existingLoan", exLoanInfo);
	   	       return "application.jsp";
	        }else {
	        	 request.setAttribute("msg", "Loan cannot be edited since its already in process");
	        	return "userhome.jsp";
	        }
	      

	    }
	

	private String trackloan(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		/* write a code to return to trackloan page */
		return "trackloan.jsp";
		
	}

	private String application(HttpServletRequest request, HttpServletResponse response) {
		return null;
		// TODO Auto-generated method stub
		/* write a code to return to trackloan page */
		
	}
}