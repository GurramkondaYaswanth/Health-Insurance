package com.healthInsurance.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.healthInsurance.model.Customer;


public interface CustomerDaoInterface {
	
	 List<Customer> viewCustomerDetails() throws SQLException;
	 void updateCustomerInfo(Customer customer) throws SQLException;
	 void deleteCustomerInfo(String id) throws SQLException;
	 Customer Filtercustomer(String id) throws SQLException;
	 void insertCustomerInfo(Customer customer) throws SQLException;
	Customer FiltercustomerByEmail(String email) throws SQLException;
	

}
