package com.healthInsurance.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class IllnessIdentity implements Serializable{
	
	private String PreExistingIllness;
	private long aadhaarNumber;
	
	public IllnessIdentity() {
		
	}
	
	public String getPreExistingIllness() {
		return PreExistingIllness;
	}
	public void setPreExistingIllness(String preExistingIllness) {
		PreExistingIllness = preExistingIllness;
	}
	public long getAadhaarNumber() {
		return aadhaarNumber;
	}
	public void setAadhaarNumber(long aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}
	
	public IllnessIdentity(String preExistingIllness, long aadhaarNumber) {
		super();
		PreExistingIllness = preExistingIllness;
		this.aadhaarNumber = aadhaarNumber;
	}
	
	
	

}
