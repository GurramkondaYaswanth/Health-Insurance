package com.healthInsurance.model;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class FamilyMemberId implements Serializable{
	
   
    private String cusId;

    
    private long aadhaarNumber;
    
    public FamilyMemberId() {
    	
    }

	public String getCusId() {
		return cusId;
	}

	public void setCusId(String cusId) {
		this.cusId = cusId;
	}

	public long getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(long aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	public FamilyMemberId(String cusId, long aadhaarNumber) {
		super();
		this.cusId = cusId;
		this.aadhaarNumber = aadhaarNumber;
	}
    
    


	
	
	

}
