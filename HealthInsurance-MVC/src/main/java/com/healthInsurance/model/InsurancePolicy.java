package com.healthInsurance.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="InsurancePolicy")
public class InsurancePolicy {
	
	@EmbeddedId
	private InsurancePolicyId insurancePolicyId;
//	private String custId;
//	private String policyId;
//	private String HospitalRoom;
//	private String[] PreExistingIllness;
	private int familyMembers;
//	private long[] AadhaarNumber;
	private long insuranceAmount;
	private int noOfMonths;
	private long monthlyPremium;
	private int noOfMonthsPaid;
	private boolean PolicyActive;
	
	
	public InsurancePolicyId getInsurancePolicyId() {
		return insurancePolicyId;
	}

	public void setInsurancePolicyId(InsurancePolicyId insurancePolicyId) {
		this.insurancePolicyId = insurancePolicyId;
	}

	public InsurancePolicy() {
		
	}
	
	public InsurancePolicy(InsurancePolicyId insurancePolicyId, int familyMembers, long insuranceAmount, int noOfMonths,
			long monthlyPremium, int noOfMonthsPaid, boolean policyActive) {
		super();
		this.insurancePolicyId = insurancePolicyId;
		this.familyMembers = familyMembers;
		this.insuranceAmount = insuranceAmount;
		this.noOfMonths = noOfMonths;
		this.monthlyPremium = monthlyPremium;
		this.noOfMonthsPaid = noOfMonthsPaid;
		PolicyActive = policyActive;
	}
	public boolean isPolicyActive() {
		return PolicyActive;
	}
	public void setPolicyActive(boolean policyActive) {
		PolicyActive = policyActive;
	}
	public int getNoOfMonthsPaid() {
		return noOfMonthsPaid;
	}
	public void setNoOfMonthsPaid(int noOfMonthsPaid) {
		this.noOfMonthsPaid = noOfMonthsPaid;
	}
	public long getMonthlyPremium() {
		return monthlyPremium;
	}
	public void setMonthlyPremium(long monthlyPremiumCost) {
		this.monthlyPremium = monthlyPremiumCost;
	}
//	public String getCustId() {
//		return custId;
//	}
//	public void setCustId(String custId) {
//		this.custId = custId;
//	}
//	public String getPolicyId() {
//		return policyId;
//	}
//	public void setPolicyId(String policyId) {
//		this.policyId = policyId;
//	}
	public int getNoOfMonths() {
		return noOfMonths;
	}
	public void setNoOfMonths(int noOfMonths) {
		this.noOfMonths = noOfMonths;
	}
	public long getInsuranceAmount() {
		return insuranceAmount;
	}
	public void setInsuranceAmount(long insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}
	//	public String getHospitalRoom() {
//		return HospitalRoom;
//	}
//	public void setHospitalRoom(String hospitalRoom) {
//		HospitalRoom = hospitalRoom;
//	}
//	public String[] getPreExistingIllness() {
//		return PreExistingIllness;
//	}
//	public void setPreExistingIllness(String[] preExistingIllness) {
//		PreExistingIllness = preExistingIllness;
//	}
	public int getFamilyMembers() {
		return familyMembers;
	}
	public void setFamilyMembers(int familyMembers) {
		this.familyMembers = familyMembers;
	}
//	public long[] getAadhaarNumber() {
//		return AadhaarNumber;
//	}
//	public void setAadhaarNumber(long[] aadhaarNumber) {
//		AadhaarNumber = aadhaarNumber;
//	}
	
	

}
