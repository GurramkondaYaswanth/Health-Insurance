package com.healthInsurance.model;

public class PolicyStatus {
	
	private String cusId;
	private String policyId;
	private int monthsPaid;
	public String getCusId() {
		return cusId;
	}
	public void setCusId(String cusId) {
		this.cusId = cusId;
	}
	public String getPolicyId() {
		return policyId;
	}
	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}
	public int getMonthsPaid() {
		return monthsPaid;
	}
	public void setMonthsPaid(int monthsPaid) {
		this.monthsPaid = monthsPaid;
	}
	
	

}
