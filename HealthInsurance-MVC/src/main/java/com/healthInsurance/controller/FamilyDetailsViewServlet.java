package com.healthInsurance.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthInsurance.dao.impl.CustomerDaoImpl;
import com.healthInsurance.model.Customer;

/**
 * Servlet implementation class FamilyDetailsViewServlet
 */
public class FamilyDetailsViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FamilyDetailsViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FammilyDetailsView(request, response);
	}

	private void FammilyDetailsView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("Custemail");
		if(email.isEmpty()) {
			email = (String) session.getAttribute("CustemailSignup");
		}
			System.out.println("email :"+email);
			CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
			Customer customerDetails;
			try {
				customerDetails = customerDaoImpl.FiltercustomerByEmail(email);
				
				request.setAttribute("FamilyDetailslist", customerDetails.getFamilyDetails());
				
	            // Creating a RequestDispatcher object to dispatch
	            // the request the request to another resource
	              RequestDispatcher rd = 
	                  request.getRequestDispatcher("jsp/FamilyDetailsView.jsp");

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
