package com.healthInsurance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.healthInsurance.model.Customer;
import com.healthInsurance.utility.ConnectionManagerMysql;





public class CustomerDao implements CustomerDaoInterface{

	Customer customer = new Customer();
	
	@Override
	public List<Customer> viewCustomerDetails() throws SQLException {

		return null;
	}

	@Override
	public void updateCustomerInfo(Customer customer) throws SQLException {
		String Email = customer.getEmail();
		String password = customer.getPassword();
		String cusId = customer.getCusId();
		String name = customer.getName();
		String phoneNumber = customer.getPhoneNumber();
		String address = customer.getAddress();
		String customer_city = customer.getCustomer_city();
		
		Connection con = ConnectionManagerMysql.getConnection();
		//System.out.println(name);
		//access the string
		PreparedStatement ps = con.prepareStatement("UPDATE customers SET customer_name= ?, customer_password=?, customer_address =?, customer_phonenumber = ?, customer_email = ?, customer_city=?  WHERE customer_id = ?");
		ps.setString(1, name);
		ps.setString(2, password);
		ps.setString(3, address);
		ps.setString(4, phoneNumber);
		ps.setString(5, Email);
		ps.setString(6, customer_city);
		ps.setString(7, cusId);
		
		System.out.println("updating..");
		int status = ps.executeUpdate();
		
		if(status >0) {
			System.out.println("An existing data was updated successfully!");
		}
		
	}

	@Override
	public void deleteCustomerInfo(String id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer Filtercustomer(String id) throws SQLException {
		Connection con = ConnectionManagerMysql.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM customers");
		int d =1;
		System.out.println();
		
		while(rs.next())
		{
			if(rs.getString(1).equals(id)) {
				customer.setCusId(rs.getString(1));
				customer.setName(rs.getString(2));
				customer.setPassword(rs.getString(3));
				customer.setAddress(rs.getString(4));
				customer.setPhoneNumber(rs.getString(5));
				customer.setEmail(rs.getString(6));
				customer.setCustomer_city(rs.getString(7));
				
				
				System.out.println();
				System.out.println("Customer Id     Name                    Password        Address                 phoneNumber    email          city");
				System.out.println(customer.getCusId()+"   "+customer.getName()+"   "+customer.getPassword()+"   "+customer.getAddress()+"    "+customer.getPhoneNumber()+"    "+customer.getEmail()+"   "+customer.getCustomer_city()         );
			}
		}
		
		return customer;
	}
	
	
	@Override
	public Customer FiltercustomerByEmail(String email) throws SQLException {
		Connection con = ConnectionManagerMysql.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM customers");
		int d =1;
		System.out.println();
		email = email.toLowerCase();
		while(rs.next())
		{
			if(rs.getString(6).equals(email)) {
				customer.setCusId(rs.getString(1));
				customer.setName(rs.getString(2));
				customer.setPassword(rs.getString(3));
				customer.setAddress(rs.getString(4));
				customer.setPhoneNumber(rs.getString(5));
				customer.setEmail(rs.getString(6));
				customer.setCustomer_city(rs.getString(7));
				
			}
		}
		
		return customer;
	}

	@Override
	public void insertCustomerInfo(Customer customer) throws SQLException {
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
		if(execution >0) {
			System.out.println("Inserted succesfully");
		}
		//System.out.println(execution);
	
		
	}



}
