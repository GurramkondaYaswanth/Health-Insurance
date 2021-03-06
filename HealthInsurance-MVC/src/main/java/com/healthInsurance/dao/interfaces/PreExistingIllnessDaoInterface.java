package com.healthInsurance.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.healthInsurance.model.PreExistingIllness;



public interface PreExistingIllnessDaoInterface {
	
	 List<PreExistingIllness> viewPreExistingIllnessDetails() throws SQLException;
	 boolean updatePreExistingIllnessInfo(PreExistingIllness preExistingIllness) throws SQLException;
	 boolean deletePreExistingIllnessInfo(String id) throws SQLException;
	 List<PreExistingIllness> FilterPreExistingIllness(String id) throws SQLException;
	 boolean insertPreExistingIllnessInfo(PreExistingIllness preExistingIllness) throws SQLException;
}
