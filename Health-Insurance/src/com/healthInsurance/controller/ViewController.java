package com.healthInsurance.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.healthInsurance.dao.CustomerDao;
import com.healthInsurance.dao.FamilyDetailsDao;
import com.healthInsurance.dao.InsurancePolicyDao;
import com.healthInsurance.dao.PreExistingIllnessDao;
import com.healthInsurance.model.Customer;


public class ViewController {
	Scanner sc = new Scanner(System.in);
	
	public void viewDetails(String customerId) {
		
		System.out.println();
		System.out.println("1. To view the policy details ");
		System.out.println("2. To view the Family member details ");
		System.out.println("3. To view the Family member preexisting illness ");
		System.out.println("4. To view your profile ");
		System.out.print("Enter Your option for viewing the details (1 or 2 or 3 or 4): ");
		int viewType = sc.nextInt();
		
		if(viewType == 1) {
			InsurancePolicyDao insurancePolicyDao = new InsurancePolicyDao();
			try {
				insurancePolicyDao.filterInsurancePolicy(customerId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(viewType == 2) {
			FamilyDetailsDao familyDetailsDao = new FamilyDetailsDao();
			try {
				familyDetailsDao.filterFamilyDetails(customerId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(viewType == 3) {
			PreExistingIllnessDao preExistingIllnessDao = new PreExistingIllnessDao();
			try {
				preExistingIllnessDao.FilterPreExistingIllness(customerId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(viewType == 4) {
			CustomerDao customerDao = new CustomerDao();
			try {
				customerDao.Filtercustomer(customerId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println();
		System.out.println("1. viewing the other details ");
		System.out.println("2. Main menu (to apply or view other Insurance policy) ");
		System.out.println("3. Exit ");
		System.out.print("Enter Your option for navigating (1 or 2 or 3): ");
		int navigating = sc.nextInt();
		
		if(navigating == 1) {
			viewDetails(customerId);
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
