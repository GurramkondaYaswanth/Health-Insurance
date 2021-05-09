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

import com.healthInsurance.bussinesslogic.IdGeneration;
import com.healthInsurance.bussinesslogic.MonthlyPremium;
import com.healthInsurance.dao.impl.CustomerDaoImpl;

import com.healthInsurance.model.Customer;
import com.healthInsurance.model.InsurancePolicy;
import com.healthInsurance.model.InsurancePolicyId;

/**
 * Servlet implementation class InsurancePolicyApply
 */
public class InsurancePolicyApply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsurancePolicyApply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InsurancePolicyDetails(request, response);
	}
	
	private void InsurancePolicyDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
				
				String InsurPolicyType = request.getParameter("InsuranceType");
				String PayDuration = request.getParameter("PayDuration"); 
				String InsuranceAmount = request.getParameter("InsuranceAmount"); 
				String FamilyMembers =  request.getParameter("FamilyMembers");
				
				IdGeneration idGeneration = new IdGeneration();
				String policyId = idGeneration.IdGenPolicy(Integer.parseInt(InsurPolicyType), Integer.parseInt(PayDuration));
				InsurancePolicy insurancePolicy = new InsurancePolicy();
				InsurancePolicyId insurancePolicyId = new InsurancePolicyId(customerDetails.getCusId(),policyId);
				System.out.println("policy id "+policyId);
				
				MonthlyPremium monthlyPremium =new MonthlyPremium();
				insurancePolicy.setInsurancePolicyId(insurancePolicyId);
				insurancePolicy.setInsuranceAmount(Long.parseLong(InsuranceAmount));
				insurancePolicy.setMonthlyPremium(monthlyPremium.calculationMonthlyPremium(Long.parseLong(InsuranceAmount), Integer.parseInt(PayDuration), Integer.parseInt(InsurPolicyType)));
				insurancePolicy.setNoOfMonths(Integer.parseInt(PayDuration)*12);
				insurancePolicy.setNoOfMonthsPaid(0);
				insurancePolicy.setPolicyActive(true);
				insurancePolicy.setFamilyMembers(Integer.parseInt(FamilyMembers));
				
				List<InsurancePolicy> insurancePolicylist = customerDetails.getInsurancePolicy();
				insurancePolicylist.add(insurancePolicy);
				
				customerDetails.setInsurancePolicy(insurancePolicylist);
				
				customerDaoImpl.updateCustomerInfo(customerDetails);
				
//				request.setAttribute("InsurancePolicylist", customerDetails.getInsurancePolicy());
				
				System.out.println(insurancePolicy);
	      	  
//	             Creating a RequestDispatcher object to dispatch
//	             the request the request to another resource
	              RequestDispatcher rd = 
	                  request.getRequestDispatcher("html/FamilyDetailsForm.html");

	              rd.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
