package com.healthInsurance.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="FamilyDetails")
public class FamilyDetails {
	
	@EmbeddedId
    private FamilyMemberId familyMemberId;
	
//	private String cusId;
//	private String policyId;
//	private long aadhaarNumber;
	private String dob;
	private String names;
	private String gender;
	
	 
//	@JoinColumn(name="Fid")  
	@OneToMany(cascade = CascadeType.ALL) 
	private List<PreExistingIllness> preExistingIllness; 
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
//	public long getAadhaarNumber() {
//		return aadhaarNumber;
//	}
//	public void setAadhaarNumber(long aadhaarNumber) {
//		this.aadhaarNumber = aadhaarNumber;
//	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public FamilyMemberId getFamilyMemberId() {
		return familyMemberId;
	}
	public void setFamilyMemberId(FamilyMemberId familyMemberId) {
		this.familyMemberId = familyMemberId;
	}
	
	
	
	

}
