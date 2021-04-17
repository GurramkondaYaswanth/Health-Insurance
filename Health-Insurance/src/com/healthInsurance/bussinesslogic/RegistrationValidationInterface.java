package com.healthInsurance.bussinesslogic;

public interface RegistrationValidationInterface {
	
	public boolean checkUserDetails(String email, String password);
	 boolean validPassword(String password, String confirmPassword);
	  boolean validEmail(String email);

}
