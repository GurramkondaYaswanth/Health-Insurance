package com.healthInsurance.dao;

import java.sql.SQLException;

import com.healthInsurance.model.Customer;



public interface SignupDaoInterface {
	int CustomerSignUp(Customer customer) throws SQLException;

}
