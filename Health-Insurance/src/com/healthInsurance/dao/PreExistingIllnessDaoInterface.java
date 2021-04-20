package com.healthInsurance.dao;

import java.sql.SQLException;
import java.util.List;

import com.healthInsurance.model.PreExistingIllness;



public interface PreExistingIllnessDaoInterface {
	
	 List<PreExistingIllness> viewPreExistingIllnessDetails() throws SQLException;
	 void updatePreExistingIllnessInfo(PreExistingIllness preExistingIllness) throws SQLException;
	 void deletePreExistingIllnessInfo(String id) throws SQLException;
	 List<PreExistingIllness> FilterPreExistingIllness(String id) throws SQLException;
	 void insertPreExistingIllnessInfo(PreExistingIllness preExistingIllness) throws SQLException;
}
