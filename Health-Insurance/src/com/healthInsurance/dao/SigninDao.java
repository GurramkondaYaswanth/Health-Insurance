package com.healthInsurance.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.healthInsurance.model.Customer;
import com.healthInsurance.utility.ConnectionManagerMysql;



public class SigninDao implements SigninDaoInterface{

	@Override
	public boolean Customerlogin(Customer customer) throws SQLException {
		Connection con = ConnectionManagerMysql.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM CUSTOMERS");
		//System.out.println("sql table select ....");
		while(rs.next())
		{
			String email = rs.getString(6);
			String password = rs.getString(3);
//			System.out.println("sql table ....");
//			System.out.println(email);
//			System.out.println(password);
//			System.out.println(customer.getEmail());
//			System.out.println(customer.getPassword());
			if(email.equalsIgnoreCase(customer.getEmail()) && password.equals(customer.getPassword())) {
				System.out.println("Credenentials Matching");
				return true;
			}
		}
		
		return false;
	}
	

}
