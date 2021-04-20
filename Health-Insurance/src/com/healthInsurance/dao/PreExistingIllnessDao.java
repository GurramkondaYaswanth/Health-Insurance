package com.healthInsurance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.healthInsurance.model.FamilyDetails;
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
	public List<PreExistingIllness> FilterPreExistingIllness(String id) throws SQLException {
		List<PreExistingIllness> preExistingIllnesslist=new ArrayList<PreExistingIllness>();
		Connection con = ConnectionManagerMysql.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM pre_existing_illness ");
		int d =1;
		
		System.out.println();
		System.out.println("   Customer Id    Policy Id     Monthly premium    InsuranceAmount    Plan Duration    FamilyMembers   Months Paid");
		while(rs.next())
		{
			if(rs.getString(1).equals(id)) {
				long aadhaarNumber = rs.getLong(1);
				String custId = rs.getString(2);
				String policyId = rs.getString(3);
				String Name = rs.getString(4);
				String dob = rs.getString(5);
//				
//				familyDetails.setAadhaarNumber(aadhaarNumber);
//				familyDetails.setCusId(custId);
//				familyDetails.setPolicyId(policyId);
//				familyDetails.setNames(Name);
//				familyDetails.setDob(dob);
//				
//				FamilyDetailslist.add(familyDetails);
				
				System.out.println("  aadhaarNumber  custId    policyId    Name    dob");
				String familyDetailsBrief = d+". "+aadhaarNumber+"  "+custId+"    "+policyId+"    "+Name+"    "+dob+"    ";
				d++;
				System.out.println(familyDetailsBrief);
				
			}
		}
		return preExistingIllnesslist;
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
