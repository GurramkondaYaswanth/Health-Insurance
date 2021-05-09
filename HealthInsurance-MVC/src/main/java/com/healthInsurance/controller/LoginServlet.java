package com.healthInsurance.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthInsurance.model.Customer;



/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
//		RequestDispatcher rd=request.getRequestDispatcher("html/login.html");
//		rd.include(request, response);
		String email=request.getParameter("email");
//      System.out.println(uid);
		String pwd=request.getParameter("password");
      
		
		
		
		Customer customer = new Customer();
		  customer.setEmail(email);
		  customer.setPassword(pwd);
		  
		  boolean cusLogin =  customer.loginValidation(customer);

		
		PrintWriter pw=response.getWriter();
		
		HttpSession session = request.getSession();
		session.setAttribute("Custemail",email);
		session.setAttribute("Customer",customer);
        if(cusLogin) {
        	pw.println("success");
//        	CourseDaoImplementation courseDaoImplementation = new CourseDaoImplementation();
//        	List<Course> courseslist = courseDaoImplementation.listCourses();
//        	
//        	 request.setAttribute("data", courseslist);
        	  
             // Creating a RequestDispatcher object to dispatch
             // the request the request to another resource
               RequestDispatcher rd = 
                   request.getRequestDispatcher("jsp/Home.jsp");

               rd.forward(request, response);
               pw.println("</body>");
               pw.println("</html>");
          }else { 
        	  System.out.println("invalid credentials");
                	response.sendRedirect("html/Signin.html");
		//  http://localhost:8090/HealthInsurance-MVC/html/Signup.html
//            		RequestDispatcher rd=request.getRequestDispatcher("html/login.html");
//            		rd.include(request, response);
          }
        pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
