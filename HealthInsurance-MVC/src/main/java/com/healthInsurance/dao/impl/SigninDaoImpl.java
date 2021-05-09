package com.healthInsurance.dao.impl;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.healthInsurance.dao.interfaces.SigninDaoInterface;
import com.healthInsurance.model.Customer;
import com.healthInsurance.util.DBUtilities;







public class SigninDaoImpl implements SigninDaoInterface{
	
	static Session session; 
	Transaction tsn;

	@Override
	public boolean Customerlogin(Customer customer) throws SQLException {
		
		try {
			session = DBUtilities.getSession();
			 tsn=session.beginTransaction();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}
		
		 Query query=session.createQuery("from Customer");
		 List<Customer> customerlist=query.list();
		 Iterator<Customer> itr=customerlist.iterator();
		 
		 while(itr.hasNext()) {
			 Customer custDb =(Customer)itr.next();
			 if(custDb.getEmail().equalsIgnoreCase(customer.getEmail()) && custDb.getPassword().equals(customer.getPassword())) {
//				 System.out.println(custDb.getPassword());
				 return true;
			 }
		 }
		 
	
		 return false;
		
//		Query query =  session.createQuery("from Customer customer");
//		Iterator itr = query.iterate();
//		while(itr.hasNext()) {
//			Object obj[]= (Object) itr.next();
//			if
//		}
//		
//		String hql = "from customer where email like :emailid ";
//		 
//		String emailid = customer.getEmail();
//		Query query = session.createQuery(hql);
//		query.setParameter("keyword", "%" + emailid + "%");
//		 
//		List<Customer> custList = query.list();
//		System.out.println(custList.get(0).getPassword());
		
//		for(Customer aCust : custList) {
//			if(aCust.getPassword().equals(customer.getPassword())) {
//				return true;
//			}
//		}
				
		
	}
	
//	public static void main(String[] args) {
//		SigninDaoImpl signinDaoImpl = new SigninDaoImpl();
//		Customer customer = new Customer();
//		customer.setEmail("gurram@gmail.com");
//		customer.setPassword("Yash@123");
//		try {
//			signinDaoImpl.Customerlogin(customer);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
