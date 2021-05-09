package com.healthInsurance.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.healthInsurance.dao.interfaces.FamilyDetailsDaoInterface;
import com.healthInsurance.model.CompanyPolicies;
import com.healthInsurance.model.Customer;
import com.healthInsurance.model.FamilyDetails;
import com.healthInsurance.model.FamilyMemberId;
import com.healthInsurance.util.DBUtilities;

public class FamilyDetailsDao implements FamilyDetailsDaoInterface{
	
	static Session session=DBUtilities.getSession();
	Transaction tsn;

	@Override
	public List<FamilyDetails> viewFamilyDetails() throws SQLException {
		try {
//			session = DBUtilities.getSession();
			 tsn=session.beginTransaction();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}
		 Query query=session.createQuery("from FamilyDetails");
		 List<FamilyDetails> familyDetailslist=query.list();
		 session.close();
		 return familyDetailslist;
	}

	@Override
	public void updateFamilyDetailsInfo(FamilyDetails familyDetails) throws SQLException {
		try {
//			session = DBUtilities.getSession();
			 tsn=session.beginTransaction();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}
		FamilyDetails familyDetailsyDb = (FamilyDetails) session.get(FamilyDetails.class, familyDetails.getFamilyMemberId());
		 
		
		familyDetailsyDb.setDob(familyDetails.getDob());
		familyDetailsyDb.setGender(familyDetails.getGender());
		familyDetailsyDb.setFamilyMemberId(familyDetails.getFamilyMemberId());
		familyDetailsyDb.setNames(familyDetails.getNames());
	
		 session.update(familyDetailsyDb);
		 tsn.commit();
//		 session.close();
		
	}

	@Override
	public void deleteFamilyDetailsInfo(FamilyMemberId familyMemberId) throws SQLException {
		try {
//			session = DBUtilities.getSession();
			 tsn=session.beginTransaction();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}
		FamilyDetails familyDetails = (FamilyDetails) session.load(FamilyDetails.class, familyMemberId);
		 session.delete(familyDetails);
		 tsn.commit();
		 session.close();
		
	}

	@Override
	public FamilyDetails filterFamilyDetails(FamilyMemberId familyMemberId) throws SQLException {
		try {
//			session = DBUtilities.getSession();
			 tsn=session.beginTransaction();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}
		FamilyDetails familyDetails = (FamilyDetails) session.load(FamilyDetails.class, familyMemberId);
//		List<FamilyDetails> familyDetailslist = new ArrayList<FamilyDetails>();
//		familyDetailslist.add(familyDetails);
		
		return familyDetails;
	}

	@Override
	public boolean insertFamilyDetailsInfo(FamilyDetails familyDetails) throws SQLException {
		try {
//			session = DBUtilities.getSession();
			 tsn=session.beginTransaction();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}
		 session.save(familyDetails); //persistent state
		 tsn.commit(); //save permanently into the database
		 boolean flag=true;
		 System.out.println("Inserted the record successfully.............");
//		 session.close();
		 return flag;
		
	}

	@Override
	public void back() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FamilyDetails> filterFamilyDetails(String id) throws SQLException {
		try {
//			session = DBUtilities.getSession();
			 tsn=session.beginTransaction();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}
		 Query query=session.createQuery("from FamilyDetails");
		 List<FamilyDetails> familyDetailslist=query.list();
		 Iterator<FamilyDetails> itr=familyDetailslist.iterator();
		 List<FamilyDetails> familyDetailslistById = new ArrayList<FamilyDetails>();
		 while(itr.hasNext()) {
			 FamilyDetails famDetDb =(FamilyDetails)itr.next();
			 if(famDetDb.getFamilyMemberId().getCusId().equalsIgnoreCase(id) ) {
//				 System.out.println(custDb.getPassword());
				 
				 familyDetailslistById.add(famDetDb);
				 
			 }
		 }
		 
		return familyDetailslistById;
	}
	
	public static void main(String[] args) {
		FamilyMemberId familyMemberId2 = new FamilyMemberId("2105051730",911122221235l);
		FamilyDetailsDao familyDetailsDao = new FamilyDetailsDao();
		try {
//			FamilyDetails familyDetails = familyDetailsDao.filterFamilyDetails(familyMemberId2);
//			System.out.println(familyDetails.getNames());
//			System.out.println(familyDetails);
			
			
			List<FamilyDetails> familyDetailslistById = new ArrayList<FamilyDetails>();
			familyDetailslistById = familyDetailsDao.filterFamilyDetails("2105051730");
			System.out.println(familyDetailslistById.size());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
