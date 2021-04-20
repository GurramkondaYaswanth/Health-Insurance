package com.healthInsurance.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.healthInsurance.dao.CustomerDao;
import com.healthInsurance.dao.FamilyDetailsDao;
import com.healthInsurance.dao.InsurancePolicyDao;
import com.healthInsurance.dao.PreExistingIllnessDao;
import com.healthInsurance.model.Customer;
import com.healthInsurance.model.FamilyDetails;
import com.healthInsurance.model.InsurancePolicy;
import com.healthInsurance.model.PreExistingIllness;

public class UpdateController {
	
	Scanner sc =new Scanner(System.in);
public void updateDetails(String customerId) {
		
		System.out.println();
		System.out.println("1. To view and update the policy details ");
		System.out.println("2. To view and update the Family member details ");
		System.out.println("3. To view and update the Family member preexisting illness ");
		System.out.println("4. To view and update your profile ");
		System.out.print("Enter Your option for viewing the details (1 or 2 or 3 or 4): ");
		int viewType = sc.nextInt();
		
		if(viewType == 1) {
			InsurancePolicyDao insurancePolicyDao = new InsurancePolicyDao();
			try {
				InsurancePolicy insurancePolicy = new InsurancePolicy();
				
				
				
				
				
//				insurancePolicy.setInsuranceAmount(insuranceAmount);
//				insurancePolicy.setCustId(customerId);
//				insurancePolicy.setFamilyMembers(familyMembers);
//				insurancePolicy.setMonthlyPremium(monthlyPremiumCost);
//				insurancePolicy.setNoOfMonths(PlanDuration*12);
//				insurancePolicy.setNoOfMonthsPaid(monthspaid);
				
				
				insurancePolicyDao.updateInsurancePolicyInfo(insurancePolicy);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(viewType == 2) {
			FamilyDetailsDao familyDetailsDao = new FamilyDetailsDao();
			FamilyDetails familyDetails = new FamilyDetails();
			try {
				familyDetailsDao.updateFamilyDetailsInfo(familyDetails);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(viewType == 3) {
			PreExistingIllnessDao preExistingIllnessDao = new PreExistingIllnessDao();
			PreExistingIllness preExistingIllness = new PreExistingIllness();
			try {
				preExistingIllnessDao.updatePreExistingIllnessInfo(preExistingIllness);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(viewType == 4) {
				
			CustomerDao customerDao = new CustomerDao();
			try {
				Customer customer = new Customer();
				customer = customerDao.Filtercustomer(customerId);
//				private String email;
//				private String password;
//				private String cusId;
//				private String name;
//				private String phoneNumber;
//				private String address;
//				private String customer_city;
				
				System.out.println();
				System.out.print("Email: ");
				sc.nextLine();
				String email = sc.nextLine();
				customer.setEmail(email);
				
				System.out.print("password: ");
				String password = sc.nextLine();
				customer.setPassword(password);
				
				String cusId = customer.getCusId();
				
				System.out.print("name: ");
				String name = sc.nextLine();
				customer.setName(name);
				
				System.out.print("phoneNumber: ");
				String phoneNumber = sc.nextLine();
				customer.setPhoneNumber(phoneNumber);
				
				System.out.print("address: ");
				String address = sc.nextLine();
				customer.setAddress(address);
				
				System.out.print("city: ");
				String city = sc.nextLine();
				customer.setCustomer_city(city);
				
				
				customerDao.updateCustomerInfo(customer);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println();
		System.out.println("1. update the other details ");
		System.out.println("2. Main menu (to apply or view other Insurance policy) ");
		System.out.println("3. Exit ");
		System.out.print("Enter Your option for navigating (1 or 2 or 3): ");
		int navigating = sc.nextInt();
		
		if(navigating == 1) {
			updateDetails(customerId);
		}else if(navigating == 2) {
			InsuranceController insuranceController = new InsuranceController();
			Customer customer = new Customer();
			customer.setCusId(customerId);
			insuranceController.InsuranceServices(customer);
		}else if(navigating == 3){
			System.out.println("**********************Thank You****************************");
		}
		
		
	}

}
