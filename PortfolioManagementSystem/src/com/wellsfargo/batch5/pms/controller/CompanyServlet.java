package com.wellsfargo.batch5.pms.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.batch5.pms.exception.LibraryException;
import com.wellsfargo.batch5.pms.model.Company;
import com.wellsfargo.batch5.pms.service.CompanyServiceImpl;
import com.wellsfargo.batch5.pms.service.ICompanyService;


@WebServlet("/")
public class CompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public CompanyServlet() {
        super();
        
    }
    private ICompanyService companyService;

    public void init() {
    	companyService = new CompanyServiceImpl();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/add":
                    insertCompany(request, response);
                    break;
                case "/delete":
                    deleteCompany(request, response);
                    break;
                case "/modify":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateCompany(request, response);
                    break;
                default:
                    listCompany(request, response);
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
			}
        }
    

    private void listCompany(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException, LibraryException {
        List<Company> listCompany = companyService.listAll();
        request.setAttribute("listCompany", listCompany);
        RequestDispatcher dispatcher = request.getRequestDispatcher("CompanyList.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("CreateCompany.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException, LibraryException {
        String compCode = request.getParameter("id");
        Company existingCompany = companyService.getCompanyByID(Integer.parseInt(compCode));
        RequestDispatcher dispatcher = request.getRequestDispatcher("CreateCompany.jsp");
        request.setAttribute("company", existingCompany);
        dispatcher.forward(request, response);

    }

    private void insertCompany(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, LibraryException {
        String code = request.getParameter("comp_code");
        String title = request.getParameter("comp_title");
        String operations = request.getParameter("comp_operations");
        String shareCount = request.getParameter("sharecount");
        String sharePrice = request.getParameter("open_share_price");
        String sector = request.getParameter("sector");
        String currency = request.getParameter("currency");
        String turnover = request.getParameter("turnover");
       
        Company newCompany= new Company(Integer.parseInt(code), title, operations,Integer.parseInt(shareCount),Double.parseDouble(sharePrice),sector,currency,Integer.parseInt(turnover),null);
        companyService.add(newCompany);
        response.sendRedirect("list");
    }

    private void updateCompany(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, LibraryException {
    	String code = request.getParameter("comp_code");
        String title = request.getParameter("comp_title");
        String operations = request.getParameter("comp_operations");
        String shareCount = request.getParameter("sharecount");
        String sharePrice = request.getParameter("open_share_price");
        String sector = request.getParameter("sector");
        String currency = request.getParameter("currency");
        String turnover = request.getParameter("turnover");
        Company newCompany= new Company(Integer.parseInt(code), title, operations,Integer.parseInt(shareCount),Double.parseDouble(sharePrice),sector,currency,Integer.parseInt(turnover),null);
        companyService.save(newCompany);
        response.sendRedirect("list");
    }

    private void deleteCompany(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, LibraryException {
        String compCode =request.getParameter("id");
        companyService.remove(Integer.parseInt(compCode));
        response.sendRedirect("list");

    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
