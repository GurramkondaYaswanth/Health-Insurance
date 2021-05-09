package com.healthInsurance.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.healthInsurance.dao.interfaces.CustomerDaoInterface;
import com.healthInsurance.model.Customer;
//import com.healthInsurance.model.FamilyDetails;
//import com.healthInsurance.model.FamilyMemberId;
//import com.healthInsurance.model.IllnessIdentity;
//import com.healthInsurance.model.InsurancePolicy;
//import com.healthInsurance.model.InsurancePolicyId;
//import com.healthInsurance.model.PreExistingIllness;
import com.healthInsurance.util.DBUtilities;




public class CustomerDaoImpl implements CustomerDaoInterface{
	
	static Session session = DBUtilities.getSession();
	Transaction tsn;
	//= DBUtilities.getSession();
	@Override
	public List<Customer> viewCustomerDetails() throws SQLException {
		
		
		try {
			session = DBUtilities.getSession();
			 tsn=session.beginTransaction();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}
		 Query query=session.createQuery("from customer");
		 List<Customer> customers=query.list();
//		 Iterator<Course> itr=courses.iterator();
//		 System.out.println(" ID "+"Course Name"+"Course Strength");
//		 while(itr.hasNext()) {
//			 Course course =(Course)itr.next();
//			 System.out.println(course.getCourseId()+"\t"+course.getCourseName()+"\t"+course.getCourseStrength());		 
//		 }
		 session.close();
		 return customers;
		
		
	}

	@Override
	public void updateCustomerInfo(Customer customer) throws SQLException {
		try {
//			session = DBUtilities.getSession();
			 tsn=session.beginTransaction();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}
		Customer custDb = (Customer) session.get(Customer.class, customer.getCusId());
		 
		custDb.setAddress(customer.getAddress());
		custDb.setCity(customer.getCity());
		custDb.setEmail(customer.getEmail());
		custDb.setName(customer.getName());
		custDb.setPassword(customer.getPassword());
		custDb.setPhoneNumber(customer.getPhoneNumber());
		custDb.setFamilyDetails(customer.getFamilyDetails());
		custDb.setInsurancePolicy(customer.getInsurancePolicy());
		custDb.setCusId(customer.getCusId());
		 session.update(custDb);
		 tsn.commit();
//		 session.close();
		
	}

	@Override
	public void deleteCustomerInfo(String id) throws SQLException {
		try {
			session = DBUtilities.getSession();
			 tsn=session.beginTransaction();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}
		Customer customer = (Customer) session.load(Customer.class, id);
		 session.delete(customer);
		 tsn.commit();
		 session.close();
		
		
	}

	@Override
	public Customer Filtercustomer(String id) throws SQLException {
		try {
//			session = DBUtilities.getSession();
			 tsn=session.beginTransaction();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}
		Customer customer = (Customer) session.load(Customer.class, id);
		tsn.commit();
//		session.close();
		 return customer;
	}

	@Override
	public boolean insertCustomerInfo(Customer customer) throws SQLException {
		boolean flag = false;
		try {
			session = DBUtilities.getSession();
			 tsn=session.beginTransaction();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}
		 session.save(customer); //persistent state
		 tsn.commit(); //save permanently into the database
		  flag=true;
		 System.out.println("Inserted the record successfully.............");
		 session.close();
		 return flag;
	
		
	}

	@Override
	public Customer FiltercustomerByEmail(String email) throws SQLException {
		try {
			session = DBUtilities.getSession();
			 tsn=session.beginTransaction();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}
		
		 Query query=session.createQuery("from Customer");
		 List<Customer> customerlist=query.list();
		 Iterator<Customer> itr=customerlist.iterator();
		 
		 while(itr.hasNext()) {
			 Customer custDb =(Customer)itr.next();
			 if(custDb.getEmail().equalsIgnoreCase(email) ) {
//				 System.out.println(custDb.getPassword());
				 return custDb;
			 }
		 }
		return null;
	}
	
//	public static void main(String[] args) {
//		Customer customer = new Customer();
////		customer.setCusId("2105051730");
////		customer.setAddress("tirupati,Andhra pradesh");
////		customer.setCity("Tirupati");
////		customer.setName("Yaswanth");
////		customer.setPassword("Yash@123");
////		customer.setPhoneNumber("9110365727");
////		customer.setEmail("gurram@gmail.com");
//		
//		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
//		try {
//			customer = customerDaoImpl.Filtercustomer("2105051730");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		customer.setEmail("gurram@gmail.com");
//		InsurancePolicy insurancePolicy = new InsurancePolicy();
//		InsurancePolicyId insurancePolicyId = new InsurancePolicyId("2105051730","210422");
//		
//		insurancePolicy.setInsurancePolicyId(insurancePolicyId);
//		insurancePolicy.setInsuranceAmount(800000);
//		insurancePolicy.setMonthlyPremium(10000);
//		insurancePolicy.setNoOfMonths(24);
//		insurancePolicy.setNoOfMonthsPaid(0);
//		insurancePolicy.setPolicyActive(true);
//		insurancePolicy.setFamilyMembers(2);
//		
//		FamilyDetails familyDetails1 = new FamilyDetails();
//		FamilyMemberId familyMemberId1 = new FamilyMemberId("2105051730",911122221234l);
//		familyDetails1.setDob("27/02/1990");
//		familyDetails1.setFamilyMemberId(familyMemberId1);
//		familyDetails1.setGender("male");
//		familyDetails1.setNames("yaswanth");
//		
//		
//		PreExistingIllness preExistingIllness1 = new PreExistingIllness();
//			
//		IllnessIdentity illnessIdentity1 = new IllnessIdentity("sugar",911122221234l);
//		preExistingIllness1.setIllnessIdentity(illnessIdentity1);
//		
//		List<PreExistingIllness> preExistingIllnesslist = new ArrayList<PreExistingIllness>();
//		preExistingIllnesslist.add(preExistingIllness1);
//		
//		familyDetails1.setPreExistingIllness(preExistingIllnesslist);
//		
//		
//		//2nd member
//		FamilyDetails familyDetails2 = new FamilyDetails();
//		FamilyMemberId familyMemberId2 = new FamilyMemberId("2105051730",911122221235l);
//		familyDetails2.setDob("27/02/1992");
//		familyDetails2.setFamilyMemberId(familyMemberId2);
//		familyDetails2.setGender("Female");
//		familyDetails2.setNames("sam");
//		
//		
//		PreExistingIllness preExistingIllness2 = new PreExistingIllness();
//		PreExistingIllness preExistingIllness21 = new PreExistingIllness();
//			
//		IllnessIdentity illnessIdentity21 = new IllnessIdentity("sugar",911122221235l);
//		IllnessIdentity illnessIdentity22 = new IllnessIdentity("BP",911122221235l);
//		preExistingIllness2.setIllnessIdentity(illnessIdentity21);
//		preExistingIllness21.setIllnessIdentity(illnessIdentity22);
//		
//		List<PreExistingIllness> preExistingIllnesslist2 = new ArrayList<PreExistingIllness>();
//		preExistingIllnesslist2.add(preExistingIllness2);
//		preExistingIllnesslist2.add(preExistingIllness21);
//		
//		familyDetails2.setPreExistingIllness(preExistingIllnesslist2);
//		
//		
//		List<FamilyDetails> familyDetailslist = new ArrayList<FamilyDetails>();
//		familyDetailslist.add(familyDetails1);
//		familyDetailslist.add(familyDetails2);
//		
//		List<InsurancePolicy> insurancePolicylist = new ArrayList<InsurancePolicy>();
//		insurancePolicylist.add(insurancePolicy);
//		
////		customer.setInsurancePolicy(insurancePolicylist);
////		customer.setFamilyDetails(familyDetailslist);
//		
//		try {
//			customerDaoImpl.updateCustomerInfo(customer);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			DBUtilities.closeSession();
//		}
//		
////		
////		FamilyDetailsDao familyDetailsDao = new FamilyDetailsDao();
////		try {
////			familyDetailsDao.insertFamilyDetailsInfo(familyDetails1);
////			familyDetailsDao.insertFamilyDetailsInfo(familyDetails2);
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//	}
//
}


