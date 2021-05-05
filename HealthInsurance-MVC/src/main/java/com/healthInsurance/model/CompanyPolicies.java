package com.healthInsurance.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="company_policies")
public class CompanyPolicies {
	
	@Id
	private String policyId;
	private int policyDuration;
	private int percentageToBePaid;
	private String policyBrief;
	
	
	
	public int getPercentageToBePaid() {
		return percentageToBePaid;
	}
	public void setPercentageToBePaid(int percentageToBePaid) {
		this.percentageToBePaid = percentageToBePaid;
	}
	public String getPolicyId() {
		return policyId;
	}
	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}
	public int getPolicyDuration() {
		return policyDuration;
	}
	public void setPolicyDuration(int policyDuration) {
		this.policyDuration = policyDuration;
	}

	public String getPolicyBrief() {
		return policyBrief;
	}
	public void setPolicyBrief(String policyBrief) {
		this.policyBrief = policyBrief;
	}
	
	
	

}
