package com.healthInsurance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.healthInsurance.model.FamilyDetails;
import com.healthInsurance.model.InsurancePolicy;
import com.healthInsurance.utility.ConnectionManagerMysql;



public class FamilyDetailsDao implements FamilyDetailsDaoInterface{
	
	FamilyDetails familyDetails = new FamilyDetails();

	@Override
	public List<FamilyDetails> viewFamilyDetails() throws SQLException {
		List<FamilyDetails> list=new ArrayList<FamilyDetails>();
		
		Connection con = ConnectionManagerMysql.getConnection();  //connection establishment
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM family_members_details ");  //Sql query
		int d =1;
		System.out.println();
	
		System.out.println();
		System.out.println("  Aadhaar Number   Customer Id    Policy Id     Name    Date of birth");
		while(rs.next())
		{
			long aadhaarNumber = rs.getLong(1);
			String custId = rs.getString(2);
			String policyId = rs.getString(3);
			String Name = rs.getString(4);
			String dob = rs.getString(5);
			
			familyDetails.setAadhaarNumber(aadhaarNumber);
			familyDetails.setCusId(custId);
			familyDetails.setPolicyId(policyId);
			familyDetails.setNames(Name);
			familyDetails.setDob(dob);
			
			list.add(familyDetails);
			
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
			System.out.println("  aadhaarNumber  custId    policyId    Name    dob");
			String familyDetailsBrief = d+". "+aadhaarNumber+"  "+custId+"    "+policyId+"    "+Name+"    "+dob+"    ";
			d++;
			System.out.println(familyDetailsBrief);
			
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
	public List<FamilyDetails> filterFamilyDetails(String id) throws SQLException {
		List<FamilyDetails> FamilyDetailslist=new ArrayList<FamilyDetails>();
		Connection con = ConnectionManagerMysql.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM family_members_details ");
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
				
				familyDetails.setAadhaarNumber(aadhaarNumber);
				familyDetails.setCusId(custId);
				familyDetails.setPolicyId(policyId);
				familyDetails.setNames(Name);
				familyDetails.setDob(dob);
				
				FamilyDetailslist.add(familyDetails);
				
				System.out.println("  aadhaarNumber  custId    policyId    Name    dob");
				String familyDetailsBrief = d+". "+aadhaarNumber+"  "+custId+"    "+policyId+"    "+Name+"    "+dob+"    ";
				d++;
				System.out.println(familyDetailsBrief);
				
			}
		}
		return FamilyDetailslist;
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
