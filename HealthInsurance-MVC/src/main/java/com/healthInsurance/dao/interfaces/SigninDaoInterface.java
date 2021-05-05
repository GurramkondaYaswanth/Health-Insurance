package com.healthInsurance.dao.interfaces;

import java.sql.SQLException;

import com.healthInsurance.model.Customer;




public interface SigninDaoInterface {
	
	 boolean Customerlogin(Customer customer) throws SQLException;
//	 boolean Employeelogin(Employee employee) throws SQLException;

}
