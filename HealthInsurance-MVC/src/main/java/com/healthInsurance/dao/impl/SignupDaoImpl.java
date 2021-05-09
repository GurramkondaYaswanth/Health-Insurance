package com.healthInsurance.dao.impl;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.healthInsurance.dao.interfaces.SignupDaoInterface;
import com.healthInsurance.model.Customer;
import com.healthInsurance.util.DBUtilities;





public class SignupDaoImpl implements SignupDaoInterface{
	static Session session;
	Transaction tsn;
	boolean flag = false;
	@Override
	public boolean CustomerSignUp(Customer customer) throws SQLException {
		
		try {
			session = DBUtilities.getSession();
			 tsn=session.beginTransaction();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}
		 session.save(customer); //persistent state
		 tsn.commit(); //save permanently into the database
		  flag=true;
		 System.out.println("Inserted the record successfully.............");
		 session.close();
		 return flag;
	}

}
