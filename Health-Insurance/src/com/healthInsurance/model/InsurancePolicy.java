package com.healthInsurance.model;

public class InsurancePolicy {
	
//	private String HospitalRoom;
	private String[] PreExistingIllness;
	private int FamilyMembers;
	private long[] AadhaarNumber;
//	public String getHospitalRoom() {
//		return HospitalRoom;
//	}
//	public void setHospitalRoom(String hospitalRoom) {
//		HospitalRoom = hospitalRoom;
//	}
	public String[] getPreExistingIllness() {
		return PreExistingIllness;
	}
	public void setPreExistingIllness(String[] preExistingIllness) {
		PreExistingIllness = preExistingIllness;
	}
	public int getFamilyMembers() {
		return FamilyMembers;
	}
	public void setFamilyMembers(int familyMembers) {
		FamilyMembers = familyMembers;
	}
	public long[] getAadhaarNumber() {
		return AadhaarNumber;
	}
	public void setAadhaarNumber(long[] aadhaarNumber) {
		AadhaarNumber = aadhaarNumber;
	}
	
	

}
