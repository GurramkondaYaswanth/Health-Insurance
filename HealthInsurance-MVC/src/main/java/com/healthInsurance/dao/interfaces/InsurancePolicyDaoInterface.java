package com.healthInsurance.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.healthInsurance.model.InsurancePolicy;





public interface InsurancePolicyDaoInterface {
	 List<InsurancePolicy> viewInsurancePolicyDetails() throws SQLException;
	 void updateInsurancePolicyInfo(InsurancePolicy insurancePolicy) throws SQLException;
	 void deleteInsurancePolicyInfo(String id) throws SQLException;
	 List<InsurancePolicy> filterInsurancePolicy(String id) throws SQLException;
//	 InsurancePolicy filterInsurancePolicyBy(String email) throws SQLException;
	 void insertInsurancePolicyInfo(InsurancePolicy insurancePolicy) throws SQLException;

}
