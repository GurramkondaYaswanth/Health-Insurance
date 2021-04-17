package com.healthInsurance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.healthInsurance.model.Customer;
import com.healthInsurance.utility.ConnectionManagerMysql;



public class SignupDao implements SignupDaoInterface{

	@Override
	public int CustomerSignUp(Customer customer) throws SQLException {
		
		String CusSignup = "INSERT INTO customers VALUES (?,?,?,?,?,?,?)";

		Connection c = null;
		c = ConnectionManagerMysql.getConnection();
		//access the string
		PreparedStatement ps = c.prepareStatement(CusSignup);
		ps.setString(1, customer.getCusId());
		ps.setString(2, customer.getName());
		ps.setString(3,customer.getPassword());
		ps.setString(4,customer.getAddress());
		ps.setString(5, customer.getPhoneNumber());
		ps.setString(6,customer.getEmail());
		ps.setString(7,customer.getCustomer_city());
		
		
		int execution = ps.executeUpdate();
		//System.out.println(execution);
		return execution;
	}

}
