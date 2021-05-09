package com.healthInsurance.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthInsurance.dao.impl.CompanyPoliciesDaoImpl;
import com.healthInsurance.model.CompanyPolicies;


/**
 * Servlet implementation class CompanyPoliciesViewServlet
 */
public class CompanyInsurPoliciesViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyInsurPoliciesViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CompanyInsurPoliciesView(request, response);
	}

	private void CompanyInsurPoliciesView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//				CompanyPolicies companyPolicies = new CompanyPolicies();
				CompanyPoliciesDaoImpl companyPoliciesDaoImpl = new CompanyPoliciesDaoImpl();
				List<CompanyPolicies> companyPoliciesList = new ArrayList<CompanyPolicies>();
			try {
				companyPoliciesList = companyPoliciesDaoImpl.viewCompanyPolicies();
				
				request.setAttribute("companyPoliciesList", companyPoliciesList);
				
	            // Creating a RequestDispatcher object to dispatch
	            // the request the request to another resource
	              RequestDispatcher rd = 
	                  request.getRequestDispatcher("jsp/AllInsurancePoliciesView.jsp");

	              rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
