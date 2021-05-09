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
import com.healthInsurance.bussinesslogic.RegistrationValidation;
import com.healthInsurance.dao.impl.CustomerDaoImpl;
import com.healthInsurance.dao.impl.SignupDaoImpl;
import com.healthInsurance.model.Customer;

/**
 * Servlet implementation class SignupServlet
 */
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		String customer_city = request.getParameter("customer_city");

		System.out.println(email);
		IdGeneration idGeneration = new IdGeneration();
		
		Customer customer = new Customer();
		  customer.setEmail(email);
		  customer.setPassword(password);
		  customer.setAddress(address);
		  customer.setCity(customer_city);
		  customer.setName(name);
		  customer.setPhoneNumber(phoneNumber);
		  customer.setCusId(idGeneration.IdGenUser());
		  
		  HttpSession session = request.getSession();
		  session.setAttribute("CustemailSignup",email);
		  session.setAttribute("CustomerSignup",customer);
//		  Customer customer1 = new Customer();
			CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
			
//			try {
//			
//				customer1 = customerDaoImpl.Filtercustomer(email);
//				System.out.println(customer1);
//				if(customer1 != null) {
//					customer1.getEmail();
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		 
		  boolean cusSignup = false;
		  RegistrationValidation registrationValidation = new RegistrationValidation();
		  boolean validemail = registrationValidation.validEmail(email);
		  boolean validPass = registrationValidation.validPassword(password);
			if(validemail) {   //email validation
				if(validPass) {  //password validation
					
		
		  SignupDaoImpl signupDao = new SignupDaoImpl();
		  try {
			  
			 cusSignup =  signupDao.CustomerSignUp(customer);
			System.out.println(cusSignup);
			  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		}
	      if(cusSignup) {
	        

	               RequestDispatcher rd = 
	                   request.getRequestDispatcher("jsp/Home.jsp");
	               rd.forward(request, response);
	        
	        
	          }else {
	        	  if(validPass) {
	        	  System.out.println("invalid credentials check password it should be atleast 8 charcters and atmost 20 and also atleast one uppercase letter, 1 lowercase letter and 1 number ");
	        	  request.setAttribute("msg", "invalid credentials check password it should be atleast 8 charcters and atmost 20 and also atleast one uppercase letter, 1 lowercase letter and 1 number");
              	response.sendRedirect("html/Signup.html");
	        	  }else {
	        		  System.out.println("invalid credentials check email ");
		        	  request.setAttribute("msg", "invalid credentials check email");
	              	response.sendRedirect("html/Signup.html");
	        		  
	        	  }
	        	  
	          }
		  
		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
