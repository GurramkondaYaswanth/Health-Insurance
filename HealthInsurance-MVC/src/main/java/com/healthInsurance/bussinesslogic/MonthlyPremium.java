package com.healthInsurance.bussinesslogic;

public class MonthlyPremium {
	public long calculationMonthlyPremium(long InsuranceAmount, int planDuration, int insurType) {
		long MonthlyPremium = 0;
		if(insurType == 1) {
		if(planDuration == 1) {
		   MonthlyPremium = (long) (0.0166667*InsuranceAmount);   //20%
		}else if(planDuration == 2) {
		   MonthlyPremium = (long) (0.020*InsuranceAmount/2);      //24%
		}else if(planDuration == 5) {
		   MonthlyPremium = (long) (0.025*InsuranceAmount/5);      //30%
		}
		}else if(insurType == 2) {
			if(planDuration == 1) {
				   MonthlyPremium = (long) (0.02*InsuranceAmount);  //24%
				}else if(planDuration == 2) {
				   MonthlyPremium = (long) (0.025*InsuranceAmount/2);  //30%
				}else if(planDuration == 5) {
				   MonthlyPremium = (long) (0.03*InsuranceAmount/5);   //36%
				}
			
		}
		return MonthlyPremium;	
		
	}
	
//	public long calculationMonthlyPremiumDeath(long InsuranceAmount, int planDuration) {
//		long MonthlyPremium = 0;
//		if(planDuration == 1) {
//		   MonthlyPremium = (long) (0.02*InsuranceAmount);  //24%
//		}else if(planDuration == 2) {
//		   MonthlyPremium = (long) (0.025*InsuranceAmount/2);  //30%
//		}else if(planDuration == 5) {
//		   MonthlyPremium = (long) (0.03*InsuranceAmount/5);   //36%
//		}
////		System.out.println("MonthlyPremium:"+MonthlyPremium);
//		
//		return MonthlyPremium;	
//	}

}
