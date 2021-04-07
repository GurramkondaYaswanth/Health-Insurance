package com.HealthInsurance.bussinesslogic;

public class ValidateUserCredentials {
	//Customer obj
	public boolean validateCustomer(String email, String password) {
		
		if(email.equalsIgnoreCase("Cust@gmail.com") && password.equals("Cust@123"))
			return true;
		else 
			System.out.println("Invalid credentials");
			return false;

	}

}
