package com.healthInsurance.controller;

import java.util.Scanner;

import com.healthInsurance.bussinesslogic.ValdiateUserCredentials;
import com.healthInsurance.model.Customer;

public class SigninController {
	
		Scanner sc = new Scanner(System.in);
		ValdiateUserCredentials VUC = new ValdiateUserCredentials();
		
		
		public void signInCustomer() {
			System.out.println();
			System.out.println("login Credentials");   //taking credentials from user
			System.out.print("Enter your email id: ");
			String email = sc.nextLine();
			System.out.print("Enter the Password: ");
		    String password = sc.nextLine();
		    Customer customer = new Customer();
		    customer.setEmail(email);
		    customer.setPassword(password);
		    boolean cusLogin =  VUC.validateCustomer(email, password);	  //calling fxn and checking the credentials
		    if(cusLogin) {
		    	InsuranceController insuranceController = new InsuranceController();
		    	insuranceController.InsuranceServices();
		    }else {
		    	System.out.println();
//		    	System.out.println("Invalid Credentials");
		    	signInCustomer();
		    }
		}

}
