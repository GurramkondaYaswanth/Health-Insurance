package com.healthInsurance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.healthInsurance.model.PreExistingIllness;
import com.healthInsurance.utility.ConnectionManagerMysql;

public class PreExistingIllnessDao implements PreExistingIllnessDaoInterface {

	@Override
	public List<PreExistingIllness> viewPreExistingIllnessDetails() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePreExistingIllnessInfo(PreExistingIllness preExistingIllness) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePreExistingIllnessInfo(String id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PreExistingIllness FilterPreExistingIllness(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertPreExistingIllnessInfo(PreExistingIllness preExistingIllness) throws SQLException {
		String preExistingIllnessInsert = "INSERT INTO pre_existing_illness VALUES (?,?,?,?)";

		Connection c = null;
		c = ConnectionManagerMysql.getConnection();
		//access the string
		PreparedStatement ps = c.prepareStatement(preExistingIllnessInsert);
		ps.setLong(1, preExistingIllness.getAadhaarNumber());
		ps.setString(2, preExistingIllness.getCusId());
		ps.setString(3,preExistingIllness.getPolicyId());
		ps.setString(4,preExistingIllness.getPreExistingIllness());
		
	
		
		
		int execution = ps.executeUpdate();
		if(execution >0) {
			System.out.println("Inserted succesfully");
		}
		
	}

}
