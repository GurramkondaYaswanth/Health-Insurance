package com.healthInsurance.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.healthInsurance.dao.interfaces.PreExistingIllnessDaoInterface;
import com.healthInsurance.model.CompanyPolicies;
import com.healthInsurance.model.PreExistingIllness;
import com.healthInsurance.util.DBUtilities;

public class PreExistingIllnessDaoImpl implements PreExistingIllnessDaoInterface{
	static Session session;
	Transaction tsn;

	@Override
	public List<PreExistingIllness> viewPreExistingIllnessDetails() throws SQLException {
		try {
			session = DBUtilities.getSession();
			 tsn=session.beginTransaction();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}
		 Query query=session.createQuery("from PreExistingIllness");
		 List<PreExistingIllness> preexistingillnesslist=query.list();
		 session.close();
		 return preexistingillnesslist;
	}

	@Override
	public boolean updatePreExistingIllnessInfo(PreExistingIllness preExistingIllness) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePreExistingIllnessInfo(String id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PreExistingIllness> FilterPreExistingIllness(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertPreExistingIllnessInfo(PreExistingIllness preExistingIllness) throws SQLException {
		try {
			session = DBUtilities.getSession();
			 tsn=session.beginTransaction();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}
		 session.save(preExistingIllness); //persistent state
		 tsn.commit(); //save permanently into the database
		 boolean flag=true;
		 System.out.println("Inserted the record successfully.............");
		 session.close();
		 return flag;
	}

}
