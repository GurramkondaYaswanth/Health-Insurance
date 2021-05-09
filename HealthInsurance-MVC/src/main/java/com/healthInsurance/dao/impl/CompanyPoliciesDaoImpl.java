package com.healthInsurance.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.healthInsurance.dao.interfaces.CompanyPoliciesDao;
import com.healthInsurance.model.CompanyPolicies;
import com.healthInsurance.model.Customer;
import com.healthInsurance.util.DBUtilities;

public class CompanyPoliciesDaoImpl implements CompanyPoliciesDao{
	
	static Session session;
	Transaction tsn;

	@Override
	public List<CompanyPolicies> viewCompanyPolicies() throws SQLException {
		try {
			session = DBUtilities.getSession();
			 tsn=session.beginTransaction();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}
		 Query query=session.createQuery("from CompanyPolicies");
		 List<CompanyPolicies> companyPolicieslist=query.list();
		 session.close();
		 return companyPolicieslist;
	}

	@Override
	public void updateCompanyPolicies(CompanyPolicies companyPolicies) throws SQLException {
		try {
			session = DBUtilities.getSession();
			 tsn=session.beginTransaction();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}
		CompanyPolicies comanyPolicyDb = (CompanyPolicies) session.get(CompanyPolicies.class, companyPolicies.getPolicyId());
		 
		comanyPolicyDb.setPercentageToBePaid(companyPolicies.getPercentageToBePaid());
		comanyPolicyDb.setPolicyBrief(companyPolicies.getPolicyBrief());
		comanyPolicyDb.setPolicyDuration(companyPolicies.getPolicyDuration());
		comanyPolicyDb.setPolicyId(companyPolicies.getPolicyId());
		
		
		
		 session.update(comanyPolicyDb);
		 tsn.commit();
		 session.close();
		
	}

	@Override
	public void deleteCompanyPolicies(String id) throws SQLException {
		try {
			session = DBUtilities.getSession();
			 tsn=session.beginTransaction();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}
		CompanyPolicies companyPolicies = (CompanyPolicies) session.load(CompanyPolicies.class, id);
		 session.delete(companyPolicies);
		 tsn.commit();
		 session.close();
		
	}

	@Override
	public CompanyPolicies FilterCompanyPolicies(String id) throws SQLException {
		try {
			session = DBUtilities.getSession();
			 tsn=session.beginTransaction();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}
		CompanyPolicies companyPolicies = (CompanyPolicies) session.load(CompanyPolicies.class, id);
		session.close();
		 return companyPolicies;
	}

	@Override
	public boolean insertCompanyPoliciesInfo(CompanyPolicies companyPolicies) throws SQLException {
		try {
			session = DBUtilities.getSession();
			 tsn=session.beginTransaction();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}
		 session.save(companyPolicies); //persistent state
		 tsn.commit(); //save permanently into the database
		 boolean flag=true;
		 System.out.println("Inserted the record successfully.............");
		 session.close();
		 return flag;
		
	}
	
//	public static void main(String[] args) {
//		CompanyPolicies companyPolicies = new CompanyPolicies();
//		companyPolicies.setPercentageToBePaid(36);
//		companyPolicies.setPolicyId("YYMM25");
//		companyPolicies.setPolicyBrief("(Health Problem+ Death)");
//		companyPolicies.setPolicyDuration(60);
//		CompanyPoliciesDaoImpl companyPoliciesDaoImpl = new CompanyPoliciesDaoImpl();
//		try {
////			companyPoliciesDaoImpl.updateCompanyPolicies(companyPolicies);
//			companyPoliciesDaoImpl.insertCompanyPoliciesInfo(companyPolicies);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
