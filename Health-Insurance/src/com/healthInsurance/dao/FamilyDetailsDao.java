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
		System.out.println("   Disease Id    Disease Name        Disease Origin Date    Origin Place        Duration of disease");
		while(rs.next())
		{
//			String disId = rs.getString(1);
//			String name = rs.getString(2);
//			String date = rs.getString(3);
//			String place = rs.getString(4);
//			String Duration = rs.getString(5);
//			diseases.setDiseaseId(disId);
//			diseases.setDiseaseName(name);
//			diseases.setDuration(Duration);
//			diseases.setOriginDate(date);
//			diseases.setOriginPlace(place);
//			list.add(diseases);
//			
//			int spaces = 20- (name.length());  
//			int spaces1 = 23 - (date.length());
//			int spaces2 = 20- (place.length());
//			
//			for(int i=0; i<spaces; i++) {
//				name = name + " "; 
//			}
//			for(int j=0; j<spaces1; j++) {
//				date = date + " "; 
//			}
//			for(int k=0; k<spaces2; k++) {
//				place = place + " "; 
//			}
//			
//			String diseaseBrief = d+". "+disId+"    "+name+date+place+Duration;
//			d++;
//			System.out.println(diseaseBrief);
			
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
