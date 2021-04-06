package com.healthInsurance.controller;

import java.util.Scanner;

import com.healthInsurance.model.InsurancePolicy;
import com.healthInsurance.services.PolicyTermsDetails;



public class InsuranceController {
	
	Scanner sc = new Scanner(System.in);
	PolicyTermsDetails policyTermsDetails = new PolicyTermsDetails();
	
	public void InsuranceServices() {
		System.out.println();
		System.out.println("           Health Insurance Policy");
		System.out.println();
		System.out.print("If you want to know about the details, technical terms and conditions of policy Enter 1 or Enter 2 for the filling the details of policy: ");
		int FillingTheForm = sc.nextInt();
		
		if(FillingTheForm == 1) {
			policyTermsDetails.AboutPolicyTermsDetails();
			System.out.print("Enter 1 for the filling the details of policy or 2 for Exit: ");
			int FillingTheForm1 = sc.nextInt();
			if(FillingTheForm1 == 1) {
				FillingTheForm = 2;
			}else {
				System.out.println();
				System.out.println("***** Thank You *****");
				
			}
			
		}
		if(FillingTheForm == 2) {
			System.out.println();
			System.out.println("Details for the policy");
			System.out.println();
			System.out.println("Number of Family members (max: 6 members): ");
			int FamilyMembers = sc.nextInt();
			sc.nextLine();
			long[] AadhaarNumber = new long[FamilyMembers];
			String[] PreExistingIllness = new String[FamilyMembers];
			for(int i=0; i<FamilyMembers; i++) {
				System.out.print("Enter the Aadhaar Number of person "+(i+1)+" : ");
				AadhaarNumber[i] = sc.nextLong();
				sc.nextLine();
				
				System.out.print("Any PreExisting Illness of person "+(i+1)+" : ");
				PreExistingIllness[i] = sc.nextLine();
				
				
			}
			InsurancePolicy insurancePolicy = new InsurancePolicy();
			insurancePolicy.setAadhaarNumber(AadhaarNumber);
			insurancePolicy.setFamilyMembers(FamilyMembers);
			insurancePolicy.setPreExistingIllness(PreExistingIllness);
			System.out.println();
			System.out.println("***** Thank You For applying the Insurance. Pay Rs.699 every month regularly*****  ");
		 
			
			
		}
	}

}
