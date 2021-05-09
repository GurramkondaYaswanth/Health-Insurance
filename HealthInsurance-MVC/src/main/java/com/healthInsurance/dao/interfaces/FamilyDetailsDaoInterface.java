package com.healthInsurance.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.healthInsurance.model.FamilyDetails;
import com.healthInsurance.model.FamilyMemberId;



public interface FamilyDetailsDaoInterface {
	
	 List<FamilyDetails> viewFamilyDetails() throws SQLException;
	 void updateFamilyDetailsInfo(FamilyDetails familyDetails) throws SQLException;
//	 void deleteFamilyDetailsInfo(String id) throws SQLException;
	 FamilyDetails filterFamilyDetails(FamilyMemberId familyMemberId) throws SQLException;
	 List<FamilyDetails> filterFamilyDetails(String id) throws SQLException;
	 boolean insertFamilyDetailsInfo(FamilyDetails familyDetails) throws SQLException;
	 void back() throws SQLException;
	void deleteFamilyDetailsInfo(FamilyMemberId familyMemberId) throws SQLException;

}
