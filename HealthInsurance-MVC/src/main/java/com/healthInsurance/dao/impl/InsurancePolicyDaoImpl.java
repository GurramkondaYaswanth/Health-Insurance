package com.healthInsurance.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.healthInsurance.dao.interfaces.InsurancePolicyDaoInterface;
import com.healthInsurance.model.FamilyDetails;
import com.healthInsurance.model.FamilyMemberId;
import com.healthInsurance.model.InsurancePolicy;
import com.healthInsurance.model.InsurancePolicyId;
import com.healthInsurance.util.DBUtilities;

public class InsurancePolicyDaoImpl implements InsurancePolicyDaoInterface{
	
	static Session session = DBUtilities.getSession();;
	Transaction tsn;

	@Override
	public List<InsurancePolicy> viewInsurancePolicyDetails() throws SQLException {
		try {
			session = DBUtilities.getSession();
			 tsn=session.beginTransaction();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}
		 Query query=session.createQuery("from InsurancePolicy");
		 List<InsurancePolicy> insurancepolicylist =query.list();
//		 session.close();
		 return insurancepolicylist;
	}

	@Override
	public boolean updateInsurancePolicyInfo(InsurancePolicy insurancePolicy) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteInsurancePolicyInfo(InsurancePolicyId insurancePolicyId) throws SQLException {
		try {
//			session = DBUtilities.getSession();
			 tsn=session.beginTransaction();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}
		InsurancePolicy insurancePolicy = (InsurancePolicy) session.load(InsurancePolicy.class, insurancePolicyId);
		 session.delete(insurancePolicy);
		 tsn.commit();
//		 session.close();
		 
		 return true;
	}

	@Override
	public List<InsurancePolicy> filterInsurancePolicy(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertInsurancePolicyInfo(InsurancePolicy insurancePolicy) throws SQLException {
		try {
			session = DBUtilities.getSession();
			 tsn=session.beginTransaction();
		}
		catch (RuntimeException e) {
			session.getTransaction().rollback();
		    throw e;
		}
		 session.save(insurancePolicy); //persistent state
		 tsn.commit(); //save permanently into the database
		 boolean flag=true;
		 System.out.println("Inserted the record successfully.............");
		 session.close();
		 return flag;
	}
	
	public static void main(String[] args) {
		InsurancePolicyDaoImpl insurancePolicyDaoImpl = new InsurancePolicyDaoImpl();
		InsurancePolicyId insurancePolicyId = new InsurancePolicyId("2109052323","210525");
		try {
			insurancePolicyDaoImpl.deleteInsurancePolicyInfo(insurancePolicyId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
