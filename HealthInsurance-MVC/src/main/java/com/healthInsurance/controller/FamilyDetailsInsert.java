package com.healthInsurance.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.healthInsurance.dao.impl.FamilyDetailsDao;

import com.healthInsurance.model.Customer;
import com.healthInsurance.model.FamilyDetails;
import com.healthInsurance.model.FamilyMemberId;
import com.healthInsurance.model.IllnessIdentity;
import com.healthInsurance.model.InsurancePolicy;
import com.healthInsurance.model.InsurancePolicyId;
import com.healthInsurance.model.PreExistingIllness;

/**
 * Servlet implementation class FamilyDetailsInsert
 */
public class FamilyDetailsInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FamilyDetailsInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	FamilyDetailsInsert(request, response);
	}
	
	private void FamilyDetailsInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
//		out.println("welcome to first servlet");
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
				
				String aadhaar = request.getParameter("aadhaar");
				String name = request.getParameter("name"); 
				String gender = request.getParameter("Gender"); 
				String DOB =  request.getParameter("DOB");
				String PreIllness =  request.getParameter("PreIllness");
				
				
				FamilyDetails familyDetails2 = new FamilyDetails();
				FamilyMemberId familyMemberId2 = new FamilyMemberId(customerDetails.getCusId(),Long.parseLong(aadhaar));
				familyDetails2.setDob(DOB);
				familyDetails2.setFamilyMemberId(familyMemberId2);
				familyDetails2.setGender(gender);
				familyDetails2.setNames(name);
				
				String[] illnessArray = PreIllness.split(",");
				
				List<PreExistingIllness> preExistingIllnesslist2 = new ArrayList<PreExistingIllness>();
				
				for(int i=0; i<illnessArray.length;i++) {
					PreExistingIllness preExistingIllness2 = new PreExistingIllness();
					IllnessIdentity illnessIdentity21 = new IllnessIdentity(illnessArray[i],Long.parseLong(aadhaar));
					preExistingIllness2.setIllnessIdentity(illnessIdentity21);
					preExistingIllnesslist2.add(preExistingIllness2);
				}
				
				familyDetails2.setPreExistingIllness(preExistingIllnesslist2);
				
				
//				List<FamilyDetails> familyDetailslist = new ArrayList<FamilyDetails>();
//				familyDetailslist.add(familyDetails2);
				
				
				FamilyDetailsDao familyDetailsDao = new FamilyDetailsDao();
				try {
					familyDetailsDao.insertFamilyDetailsInfo(familyDetails2);
//					familyDetailsDao.insertFamilyDetailsInfo(familyDetails2);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				
//				int visitCount = 1;
				int visitCount = 0;
			      String visitCountKey = new String("visitCount");
			      if((Integer)session.getAttribute(visitCountKey) == null) {
			    	  session.setAttribute(visitCountKey,  visitCount);
			      }
			      if (session.isNew()) {
			    	  session.setAttribute(visitCountKey,  visitCount);
			       } else {
			          visitCount = (Integer)session.getAttribute(visitCountKey);
			          visitCount = visitCount + 1;
			          
			       }
			      session.setAttribute(visitCountKey,  visitCount);
			
	      	  
//	             Creating a RequestDispatcher object to dispatch
//	             the request the request to another resource  customerDetails.getInsurancePolicy().size() -1
				int famSize = customerDetails.getInsurancePolicy().get(customerDetails.getInsurancePolicy().size() -1).getFamilyMembers();
				int famSizeDB = customerDetails.getFamilyDetails().size();
				System.out.println("famSize "+famSize);
				System.out.println("famSizeDB "+famSizeDB);
				if(visitCount < famSize) {
					int dispCount = visitCount+1;
					out.print("family member details of "+ dispCount +" person");
	              RequestDispatcher rd = 
	                  request.getRequestDispatcher("html/FamilyDetailsForm.html");
	              

	              rd.include(request, response);
				}else {
					out.print("Succesfully applied the policy");
					RequestDispatcher rd = request.getRequestDispatcher("jsp/Home.jsp");
					rd.include(request, response);
				}
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
