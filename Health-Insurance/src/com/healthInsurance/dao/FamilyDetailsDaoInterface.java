package com.healthInsurance.dao;

import java.sql.SQLException;
import java.util.List;

import com.healthInsurance.model.FamilyDetails;



public interface FamilyDetailsDaoInterface {
	
	 List<FamilyDetails> viewFamilyDetails() throws SQLException;
	 void updateFamilyDetailsInfo(FamilyDetails familyDetails) throws SQLException;
	 void deleteFamilyDetailsInfo(String id) throws SQLException;
	 List<FamilyDetails> filterFamilyDetails(String id) throws SQLException;
	 void insertFamilyDetailsInfo(FamilyDetails familyDetails) throws SQLException;
	 void back() throws SQLException;

}
