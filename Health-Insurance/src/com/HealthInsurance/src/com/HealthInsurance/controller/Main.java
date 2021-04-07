package com.HealthInsurance.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InputMismatchException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("                                         Welcome to Health Insurance     ");
		System.out.println();	
		//taking input to know if the user is hr or employee
		System.out.print("If your Customer enter 1, Health Insurance employee enter 2 : ");
		int CustomerEmployee = sc.nextInt(); 
		if(CustomerEmployee >2 && CustomerEmployee<1) {
			System.out.println("Invalid Input");
		}else {
		//taking input to know new user or existing user
			if(CustomerEmployee == 2) {
				System.out.println("Check the client requirements and reach the monthly target!!");
			}else {
				System.out.print("Enter 1 if your existing User or else enter 2 if your new User: ");
				int newOld =0;
				try{
					newOld = sc.nextInt();
					sc.nextLine();
					
					}catch(InputMismatchException Ime) {
						System.out.println("Enter only numbers");
					}
				
//				int newOld = sc.nextInt();
//				sc.nextLine();
		
				SigninController signincontoller = new SigninController();
				SignupController signupcontroller = new SignupController();
		
				if(newOld == 1) {
					signincontoller.signInCustomer();
				}else if(newOld == 2){
					signupcontroller.signUpCustomer();
				}else {		
					
				}
			}
		}
	}
}

