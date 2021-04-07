package com.HealthInsurance.model;

public class Customer {
	private String email;
	private String password;
	private String cusId;
	private String name;
	private long phoneNumber;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCusId() {
		return cusId;
	}
	public void setCusId(String cusId) {
		this.cusId = cusId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
//	public Customer(String email, String password, String cusId, String name, long phoneNumber) {
//		super();
//		this.email = email;
//		this.password = password;
//		this.cusId = cusId;
//		this.name = name;
//		this.phoneNumber = phoneNumber;
//	}

}
