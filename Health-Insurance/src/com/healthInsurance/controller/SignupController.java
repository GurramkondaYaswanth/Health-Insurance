package com.healthInsurance.controller;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.healthInsurance.bussinesslogic.IdGeneration;
import com.healthInsurance.bussinesslogic.RegistrationValidation;
import com.healthInsurance.dao.SignupDao;
import com.healthInsurance.model.Customer;

public class SignupController {
	
	Scanner sc = new Scanner(System.in);
	RegistrationValidation RV = new RegistrationValidation();
	IdGeneration IG = new IdGeneration();
	SignupDao signupDao = new SignupDao();
	
	public void signUpCustomer()  throws InputMismatchException{  //taking the details of the customer
		System.out.println();
		System.out.println("Create Account");
		System.out.println();
		 System.out.print("Your Name: ");
		 String name = sc.nextLine();
		System.out.print("Enter your email id: ");
		String email = sc.nextLine();
		email = email.toLowerCase();
		System.out.print("Enter the Password: ");
	    String password = sc.nextLine();
	    System.out.print("Mobile Number: ");
	    String phoneNumber = sc.nextLine();
	    
	    System.out.print("Enter the Address: ");
	    String address = sc.nextLine();
	    System.out.print("City : ");
	    String City = sc.nextLine();
	    
	    
	   if(RV.checkUserDetails(email, password)) {
	    String CusId =  IG.IdGenUser();
	    System.out.println();
	    System.out.println("Your ID is "+CusId);
	    System.out.println("Please take note of your Customer ID");
	    Customer customer = new Customer();   //encapsulating the data
	    customer.setEmail(email);
	    customer.setPassword(password);
	    customer.setCusId(CusId);
	    customer.setPhoneNumber(phoneNumber);
	    customer.setName(name);
	    customer.setAddress(address);
	    customer.setCustomer_city(City);
	    
	    int cusSignupStatus = 0;
		try {
			cusSignupStatus = signupDao.CustomerSignUp(customer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    if(cusSignupStatus > 0) {
		InsuranceController insuranceController = new InsuranceController();
    	insuranceController.InsuranceServices(customer);
	    }
	   }

	}
}
