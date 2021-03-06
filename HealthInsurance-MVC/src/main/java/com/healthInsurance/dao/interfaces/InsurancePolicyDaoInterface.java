package com.healthInsurance.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.healthInsurance.model.FamilyMemberId;
import com.healthInsurance.model.InsurancePolicy;
import com.healthInsurance.model.InsurancePolicyId;





public interface InsurancePolicyDaoInterface {
	 List<InsurancePolicy> viewInsurancePolicyDetails() throws SQLException;
	 boolean updateInsurancePolicyInfo(InsurancePolicy insurancePolicy) throws SQLException;
//	 boolean deleteInsurancePolicyInfo(String id) throws SQLException;
	 List<InsurancePolicy> filterInsurancePolicy(String id) throws SQLException;
//	 InsurancePolicy filterInsurancePolicyBy(String email) throws SQLException;
	 boolean insertInsurancePolicyInfo(InsurancePolicy insurancePolicy) throws SQLException;
	
	boolean deleteInsurancePolicyInfo(InsurancePolicyId insurancePolicyId) throws SQLException;

}
