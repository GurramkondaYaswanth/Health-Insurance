package com.healthInsurance.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="PreExistingIllness")
public class PreExistingIllness {
	
	@EmbeddedId
	private IllnessIdentity illnessIdentity;

//	private String cusId;
//	private String policyId;
//	private String PreExistingIllness;
//	private long aadhaarNumber;
	
	
	public IllnessIdentity getIllnessIdentity() {
		return illnessIdentity;
	}
	public void setIllnessIdentity(IllnessIdentity illnessIdentity) {
		this.illnessIdentity = illnessIdentity;
	}
//	public String getCusId() {
//		return cusId;
//	}
//	public void setCusId(String cusId) {
//		this.cusId = cusId;
//	}
//	public String getPolicyId() {
//		return policyId;
//	}
//	public void setPolicyId(String policyId) {
//		this.policyId = policyId;
//	}
//	public String getPreExistingIllness() {
//		return PreExistingIllness;
//	}
//	public void setPreExistingIllness(String preExistingIllness) {
//		PreExistingIllness = preExistingIllness;
//	}
//	public long getAadhaarNumber() {
//		return aadhaarNumber;
//	}
//	public void setAadhaarNumber(long aadhaarNumber) {
//		this.aadhaarNumber = aadhaarNumber;
//	}
	
	

}
