package com.healthInsurance.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.healthInsurance.bussinesslogic.ValdiateUserCredentials;
import com.healthInsurance.dao.SigninDao;
import com.healthInsurance.model.Customer;

public class SigninController {
	
		Scanner sc = new Scanner(System.in);
		ValdiateUserCredentials VUC = new ValdiateUserCredentials();
		SigninDao sd = new SigninDao();
		
		public void signInCustomer() throws SQLException {
			System.out.println();
			System.out.println("login Credentials");   //taking credentials from user
			System.out.print("Enter your email id: ");
			String email = sc.nextLine();
			System.out.print("Enter the Password: ");
		    String password = sc.nextLine();
		    Customer customer = new Customer();
		    customer.setEmail(email);
		    customer.setPassword(password);
		    boolean cusLogin =  sd.Customerlogin(customer);	  //calling fxn and checking the credentials
		    if(cusLogin) {
		    	InsuranceController insuranceController = new InsuranceController();
		    	insuranceController.InsuranceServices(customer);
		    }else {
		    	System.out.println();
//		    	System.out.println("Invalid Credentials");
		    	signInCustomer();
		    }
		}

}
