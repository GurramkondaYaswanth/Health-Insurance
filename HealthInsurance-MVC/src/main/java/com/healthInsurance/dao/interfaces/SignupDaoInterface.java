package com.healthInsurance.dao.interfaces;

import java.sql.SQLException;

import com.healthInsurance.model.Customer;



public interface SignupDaoInterface {
	boolean CustomerSignUp(Customer customer) throws SQLException;

}
