package com.HealthInsurance.bussinesslogic;

public class MonthlyPremium {
	public long calculationMonthlyPremium(long InsuranceAmount) {
		long MonthlyPremium = (long) (0.02*InsuranceAmount);
//		System.out.println("MonthlyPremium:"+MonthlyPremium);
		
		return MonthlyPremium;
		
		
	}

}
