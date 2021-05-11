package com.healthInsurance.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthInsurance.bussinesslogic.IdGeneration;
import com.healthInsurance.dao.impl.CustomerDaoImpl;
import com.healthInsurance.model.Customer;

/**
 * Servlet implementation class ProfileUpdate
 */
public class ProfileUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerProfileUpdate(request, response);
	}

private void CustomerProfileUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("Custemail");
		Customer customer =  (Customer) session.getAttribute("Customer");
		if(email == null) {
			email = (String) session.getAttribute("CustemailSignup");
			customer =  (Customer) session.getAttribute("CustomerSignup");
		}
		
		System.out.println("email :"+email);
		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
		Customer customerDetails;
		try {
			customerDetails = customerDaoImpl.FiltercustomerByEmail(email,customer.getPassword());
			request.setAttribute("customerDetails", customerDetails);
			
			
//			String emailUpdate = request.getParameter("email");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String phoneNumber = request.getParameter("phoneNumber");
			String address = request.getParameter("address");
			String customer_city = request.getParameter("city");

//			System.out.println(emailUpdate);
			
			
			Customer customerUpdate = new Customer();
			customerUpdate.setEmail(email);
			if(password != null) {
			customerUpdate.setPassword(password);
			}else {
				customerUpdate.setPassword(customer.getPassword());
			}
			customerUpdate.setAddress(address);
			customerUpdate.setCity(customer_city);
			customerUpdate.setName(name);
			customerUpdate.setPhoneNumber(phoneNumber);
			customerUpdate.setCusId(customerDetails.getCusId());
			customerUpdate.setFamilyDetails(customerDetails.getFamilyDetails());
			customerUpdate.setInsurancePolicy(customerDetails.getInsurancePolicy());
			
			
			customerDaoImpl.updateCustomerInfo(customerUpdate);
			request.setAttribute("customerDetails", customerDetails);
      	  
            // Creating a RequestDispatcher object to dispatch
            // the request the request to another resource
              RequestDispatcher rd = 
                  request.getRequestDispatcher("jsp/CustomerDetailsView.jsp");

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
