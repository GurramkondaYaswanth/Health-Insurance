package com.healthInsurance.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class DBUtilities {

	private static SessionFactory factory;

	private static Session session;
	
    private static ServiceRegistry serviceRegistry;

	public static Session getSession() {

		
		 Configuration configuration = new Configuration();
	        
		 configuration.configure();
	        
		 serviceRegistry = new ServiceRegistryBuilder().applySettings(
	        		
	                         configuration.getProperties()).buildServiceRegistry();  
		 
		 //read all the properties from the cfg file and checked it
		 //db is the service and gets registered to render the service
		 //rmi  example to understand the registry and lookup service
	        
	        factory = configuration.buildSessionFactory(serviceRegistry);
	        
	        session = factory.openSession();
	        System.out.println("sessio in created");
	        
	        //session = factory.getCurrentSession();
		
		  //System.out.println("current session is got...");
		
		return session;
	}
	
	
	public static void  closeSession()
	{
		session.close();
	}
	
	

	//for checking but later remove it
	public static void main(String[] args) {

		DBUtilities.getSession();
	}

}