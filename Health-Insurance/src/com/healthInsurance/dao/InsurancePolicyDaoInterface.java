package com.healthInsurance.dao;

import java.sql.SQLException;
import java.util.List;

import com.healthInsurance.model.InsurancePolicy;





public interface InsurancePolicyDaoInterface {
	 List<InsurancePolicy> viewInsurancePolicyDetails() throws SQLException;
	 void updateInsurancePolicyInfo(InsurancePolicy insurancePolicy) throws SQLException;
	 void deleteInsurancePolicyInfo(String id) throws SQLException;
	 InsurancePolicy FilterInsurancePolicy(String id) throws SQLException;
	 void insertInsurancePolicyInfo(InsurancePolicy insurancePolicy) throws SQLException;
	 

}
