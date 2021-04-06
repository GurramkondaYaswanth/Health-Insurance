package com.healthInsurance.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.healthInsurance.bussinesslogic.IdGeneration;
import com.healthInsurance.bussinesslogic.RegistrationValidation;
import com.healthInsurance.model.Customer;

public class SignupController {
	
	Scanner sc = new Scanner(System.in);
	RegistrationValidation RV = new RegistrationValidation();
	IdGeneration IG = new IdGeneration();
	
	public void signUpCustomer()  throws InputMismatchException{  //taking the details of the customer
		System.out.println();
		System.out.println("Create Account");
		System.out.println();
		 System.out.print("Your Name: ");
		 String name = sc.nextLine();
		System.out.print("Enter your email id: ");
		String email = sc.nextLine();
		System.out.print("Enter the Password: ");
	    String password = sc.nextLine();
	    System.out.print("Mobile Number: ");
	    long phoneNumber = sc.nextLong();
	   if(RV.checkUserDetails(email, password)) {
	    String CusId = IG.IdGen();
	    System.out.println();
	    System.out.println("Your ID is "+CusId);
	    System.out.println("Please take note of your Customer ID");
	    Customer customer = new Customer();   //encapsulating the data
	    customer.setEmail(email);
	    customer.setPassword(password);
	    customer.setCusId(CusId);
	    customer.setPhoneNumber(phoneNumber);
	    customer.setName(name);
	  
	    
	   }

	}
}
