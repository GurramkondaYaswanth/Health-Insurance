package com.healthInsurance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.healthInsurance.model.FamilyDetails;
import com.healthInsurance.utility.ConnectionManagerMysql;



public class FamilyDetailsDao implements FamilyDetailsDaoInterface{
	
	FamilyDetails familyDetails = new FamilyDetails();

	@Override
	public List<FamilyDetails> viewFamilyDetails() throws SQLException {
		List<FamilyDetails> list=new ArrayList<FamilyDetails>();
		
		Connection con = ConnectionManagerMysql.getConnection();  //connection establishment
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM FamilyDetails");  //Sql query
		int d =1;
		System.out.println();
	
		while(rs.next())
		{

			
		}
		return list;
	}

	@Override
	public void updateFamilyDetailsInfo(FamilyDetails familyDetails) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFamilyDetailsInfo(String id) throws SQLException {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void back() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FamilyDetails FilterFamilyDetails(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertFamilyDetailsInfo(FamilyDetails familyDetails) throws SQLException {
		String familyDetailsInsert = "INSERT INTO family_members_details VALUES (?,?,?,?,?)";

		Connection c = null;
		c = ConnectionManagerMysql.getConnection();
		//access the string
		PreparedStatement ps = c.prepareStatement(familyDetailsInsert);
		ps.setLong(1, familyDetails.getAadhaarNumber());
		ps.setString(2, familyDetails.getCusId());
		ps.setString(3,familyDetails.getPolicyId());
		ps.setString(4,familyDetails.getNames());
		ps.setString(5, familyDetails.getDob());
	
		
		
		int execution = ps.executeUpdate();
		if(execution >0) {
			System.out.println("Inserted succesfully");
		}
		
	}

}
