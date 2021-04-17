package com.healthInsurance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.healthInsurance.model.InsurancePolicy;
import com.healthInsurance.utility.ConnectionManagerMysql;



public class InsurancePolicyDao implements InsurancePolicyDaoInterface{
	
	InsurancePolicy insurancePolicy = new InsurancePolicy();

	@Override
	public List<InsurancePolicy> viewInsurancePolicyDetails() throws SQLException {
		List<InsurancePolicy> list=new ArrayList<InsurancePolicy>();
		
		Connection con = ConnectionManagerMysql.getConnection();  //connection establishment
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM insurance_policy");  //Sql query
		int d =1;
		System.out.println();
		System.out.println("   Customer Id    Policy Id     Monthly premium    InsuranceAmount    Plan Duration    FamilyMembers   Months Paid");
		while(rs.next())
		{
			String custId = rs.getString(1);
			String policyId = rs.getString(2);
			int monthlyPremium = rs.getInt(3);
			long insuranceAmount = rs.getInt(4);
			int planDuration = rs.getInt(5);
			int familyMembers = rs.getInt(6);
			int monthsPaid = rs.getInt(7);
			
			insurancePolicy.setCustId(custId);
			insurancePolicy.setFamilyMembers(familyMembers);
			insurancePolicy.setInsuranceAmount(insuranceAmount);
			insurancePolicy.setMonthlyPremium(monthlyPremium);
			insurancePolicy.setNoOfMonths(planDuration);
			insurancePolicy.setNoOfMonthsPaid(monthsPaid);
			insurancePolicy.setPolicyId(policyId);
			list.add(insurancePolicy);
			
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
			
			String diseaseBrief = d+". "+custId+"    "+policyId+"    "+monthlyPremium+"    "+insuranceAmount+"    "+planDuration+"    "+familyMembers+"    "+monthsPaid;
			d++;
			System.out.println(diseaseBrief);
			
		}
		return list;
	}

	@Override
	public void updateInsurancePolicyInfo(InsurancePolicy insurancePolicy) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInsurancePolicyInfo(String id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InsurancePolicy FilterInsurancePolicy(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertInsurancePolicyInfo(InsurancePolicy insurancePolicy) throws SQLException {
		String insurancePolicyDetailsInsert = "INSERT INTO insurance_policy VALUES (?,?,?,?,?,?,?)";

		Connection c = null;
		c = ConnectionManagerMysql.getConnection();
		//access the string
		PreparedStatement ps = c.prepareStatement(insurancePolicyDetailsInsert);
		ps.setString(1, insurancePolicy.getCustId());
		ps.setString(2, insurancePolicy.getPolicyId());
		ps.setLong(3,insurancePolicy.getMonthlyPremium());
		ps.setLong(4,insurancePolicy.getInsuranceAmount());
		ps.setLong(5, insurancePolicy.getNoOfMonths());
		ps.setLong(6,insurancePolicy.getFamilyMembers());
		ps.setLong(7, insurancePolicy.getNoOfMonthsPaid());
	
		
		
		int execution = ps.executeUpdate();
		if(execution >0) {
			System.out.println("Inserted succesfully");
		}
		
	}

}
