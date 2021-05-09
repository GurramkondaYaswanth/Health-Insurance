package com.healthInsurance.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.healthInsurance.model.CompanyPolicies;



public interface CompanyPoliciesDao {
	
	List<CompanyPolicies> viewCompanyPolicies() throws SQLException;
	 void updateCompanyPolicies(CompanyPolicies companyPolicies) throws SQLException;
	 void deleteCompanyPolicies(String id) throws SQLException;
	 CompanyPolicies FilterCompanyPolicies(String id) throws SQLException;
	 boolean insertCompanyPoliciesInfo(CompanyPolicies companyPolicies) throws SQLException;


}
