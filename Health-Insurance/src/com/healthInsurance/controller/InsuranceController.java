package com.healthInsurance.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.healthInsurance.bussinesslogic.IdGeneration;
import com.healthInsurance.bussinesslogic.MonthlyPremium;
import com.healthInsurance.dao.CustomerDao;
import com.healthInsurance.dao.FamilyDetailsDao;
import com.healthInsurance.dao.InsurancePolicyDao;
import com.healthInsurance.dao.PreExistingIllnessDao;
import com.healthInsurance.model.Customer;
import com.healthInsurance.model.FamilyDetails;
import com.healthInsurance.model.InsurancePolicy;
import com.healthInsurance.model.PolicyStatus;
import com.healthInsurance.model.PreExistingIllness;
import com.healthInsurance.services.PolicyTermsDetails;



public class InsuranceController {
	
	Scanner sc = new Scanner(System.in);
	PolicyTermsDetails policyTermsDetails = new PolicyTermsDetails();
	FamilyDetails familyDetails = new FamilyDetails();
	IdGeneration idGeneration = new IdGeneration();
	InsurancePolicy insurancePolicy = new InsurancePolicy();
	PolicyStatus policyStatus = new PolicyStatus();
	CustomerDao customerDao = new CustomerDao();
	FamilyDetailsDao familyDetailsDao = new FamilyDetailsDao();
	PreExistingIllnessDao preExistingIllnessDao = new PreExistingIllnessDao();
	
	public void InsuranceServices(Customer customer) {
		
		
		String Custemail = customer.getEmail();
		String CustomerId = null;
		//getting the customer details
		if(customer.getCusId() == null) {
			try {
				CustomerId = customerDao.FiltercustomerByEmail(Custemail).getCusId();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			CustomerId = customer.getCusId();
		}
		System.out.println();
		System.out.println("           Health Insurance Policy");
		System.out.println();
		System.out.print("If you want to know about the details, technical terms and conditions of policy Enter 1 or Enter 2 for the filling the details of policy: ");
		int fillingTheForm = sc.nextInt();
		
		if(fillingTheForm == 1) {
			policyTermsDetails.AboutPolicyTermsDetails();
			System.out.print("Enter 1 for the filling the details of policy or 2 for Exit: ");
			int FillingTheForm1 = sc.nextInt();
			if(FillingTheForm1 == 1) {
				fillingTheForm = 2;
			}else {
				System.out.println();
				System.out.println("***** Thank You *****");
				
			}
			
		}
		if(fillingTheForm == 2) {
			System.out.println();
			System.out.println("Details for the policy");
			System.out.println();
			System.out.println("1. Only for Health Problems insurance ");
			System.out.println("2. Health Problems and Health releated death Insurance ");
			System.out.print("Enter Your option for Insurance Type (1 or 2): ");
			int insurType = sc.nextInt();
			System.out.println();
			System.out.println("Number of Family members (max: 6 members): ");
			int familyMembers = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the Amount you want for Insurance (min: 2 lakhs && max: 10 lakhs): ");
			long insuranceAmount = sc.nextLong();
			
			
			int PlanDuration = 0;
			if(insurType == 1) {
			System.out.println();
			System.out.println("1. One Year Plan (20% of Total Insurance will be paying at the end of one Year)  ");
			System.out.println("2. Two Year Plan (24% of Total Insurance will be paying at the end of Two Year)  ");
			System.out.println("3. Five Year Plan (30% of Total Insurance will be paying at the end of Five Year)  ");
			System.out.print("Enter Your option for Insurance Duration (1 or 2 or 3): ");
			 PlanDuration = sc.nextInt();
			}else if(insurType == 2) {
			System.out.println();
			System.out.println("1. One Year Plan (24% of Total Insurance will be paying at the end of one Year)  ");
			System.out.println("2. Two Year Plan (30% of Total Insurance will be paying at the end of Two Year)  ");
			System.out.println("3. Five Year Plan (36% of Total Insurance will be paying at the end of Five Year)  ");
			System.out.print("Enter Your option for Insurance Duration (1 or 2 or 3): ");
			PlanDuration = sc.nextInt();
			}
			
			if(PlanDuration == 3) {
				PlanDuration =5;
			}
			
			long monthlyPremiumCost = 0;
			if(insurType == 1) {
			MonthlyPremium monthlyPremium = new MonthlyPremium();
			 monthlyPremiumCost =  monthlyPremium.calculationMonthlyPremium(insuranceAmount,PlanDuration);
			}else if(insurType == 2) {
				MonthlyPremium monthlyPremium = new MonthlyPremium();
				 monthlyPremiumCost =  monthlyPremium.calculationMonthlyPremiumDeath(insuranceAmount,PlanDuration);
			}else {
				System.out.println("Invalid input");
			}
			
			long[] aadhaarNumber = new long[familyMembers];
			String[] preExistingIllness = new String[familyMembers];
			 String[] dob = new String[familyMembers];
			 String[] names = new String[familyMembers];
			 String[] gender = new String[familyMembers];
			 
			 sc.nextLine();
			for(int i=0; i<familyMembers; i++) {
				System.out.print("Name of person "+(i+1)+" : ");
				names[i] = sc.nextLine();
				
				System.out.print("Date of birth (DD/MM/YYYY) of person  "+(i+1)+" : ");
				dob[i] = sc.nextLine();
				
				System.out.print("Gender of person "+(i+1)+" : ");
				gender[i] = sc.nextLine();
				
				System.out.print("Enter the Aadhaar Number of person "+(i+1)+" : ");
				aadhaarNumber[i] = sc.nextLong();
				sc.nextLine();
				
				System.out.print("Any PreExisting Illness of person use(comma after each illness)"+(i+1)+" : ");
				preExistingIllness[i] = sc.nextLine();
			}
			
			int monthspaid = 0;
			insurancePolicy.setFamilyMembers(familyMembers);
			insurancePolicy.setInsuranceAmount(insuranceAmount);
			insurancePolicy.setCustId(CustomerId);
			insurancePolicy.setFamilyMembers(familyMembers);
			insurancePolicy.setMonthlyPremium(monthlyPremiumCost);
			insurancePolicy.setNoOfMonths(PlanDuration*12);
			insurancePolicy.setNoOfMonthsPaid(monthspaid);
			
			InsurancePolicyDao insurancePolicyDao = new InsurancePolicyDao();
			try {
				insurancePolicyDao.insertInsurancePolicyInfo(insurancePolicy);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			String policyId = idGeneration.IdGenPolicy(insurType,PlanDuration);
			
			
			for(int j=0; j<familyMembers; j++) {
			familyDetails.setAadhaarNumber(aadhaarNumber[j]);
			familyDetails.setCusId(CustomerId);
			familyDetails.setDob(dob[j]);
			familyDetails.setNames(names[j]);
			familyDetails.setPolicyId(policyId);
			familyDetails.setGender(gender[j]);
			
			try {
				familyDetailsDao.insertFamilyDetailsInfo(familyDetails);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
//			policyStatus.setCusId(cusId);
//			policyStatus.setMonthsPaid(monthsPaid);
			policyStatus.setPolicyId(policyId);
			
			
			for(int j=0; j<familyMembers; j++) {
			PreExistingIllness preExistingIllnes = new PreExistingIllness();
			preExistingIllnes.setAadhaarNumber(aadhaarNumber[j]);
			preExistingIllnes.setCusId(CustomerId);
			preExistingIllnes.setPolicyId(policyId);
			preExistingIllnes.setPreExistingIllness(preExistingIllness[j]);
			
			try {
				preExistingIllnessDao.insertPreExistingIllnessInfo(preExistingIllnes);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			System.out.println();
			System.out.println("***** Thank You For applying the Insurance. Pay monthly Premium: "+monthlyPremiumCost+ " every month regularly for "+PlanDuration+" year "+ "for Claiming insurance of "+insuranceAmount+" *****  ");
		 
			
			
		}
	}

}