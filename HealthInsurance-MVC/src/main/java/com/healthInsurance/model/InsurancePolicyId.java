package com.healthInsurance.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class InsurancePolicyId implements Serializable{


	private String custId;
	private String policyId;
	
	
	public InsurancePolicyId() {
		
	}
	
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getPolicyId() {
		return policyId;
	}
	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}
	public InsurancePolicyId(String custId, String policyId) {
		super();
		this.custId = custId;
		this.policyId = policyId;
	}
	
	
	
	

}
