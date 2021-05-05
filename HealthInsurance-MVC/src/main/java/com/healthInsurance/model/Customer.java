package com.healthInsurance.model;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.healthInsurance.dao.impl.SigninDaoImpl;

@Entity
@Table (name="customer")
public class Customer {   //customer details
	
	
	@Id
	private String cusId;
	private String email;
	private String password;	
	private String name;
	private String phoneNumber;
	private String address;
	private String city;
	
	@OneToMany(cascade = CascadeType.ALL)  
	@JoinColumn(name="cusId")  
	private List<FamilyDetails> familyDetails; 
	
	
	@OneToMany(cascade = CascadeType.ALL)  
	@JoinColumn(name="cusId")  
	private List<InsurancePolicy> insurancePolicy; 
	
	
	public Customer() {
		
	}
	
	
	


	public Customer(String cusId, String email, String password, String name, String phoneNumber, String address,
			String city, List<FamilyDetails> familyDetails, List<InsurancePolicy> insurancePolicy) {
		super();
		this.cusId = cusId;
		this.email = email;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
		this.familyDetails = familyDetails;
		this.insurancePolicy = insurancePolicy;
	}





	public List<InsurancePolicy> getInsurancePolicy() {
		return insurancePolicy;
	}


	public void setInsurancePolicy(List<InsurancePolicy> insurancePolicy) {
		this.insurancePolicy = insurancePolicy;
	}


	public List<FamilyDetails> getFamilyDetails() {
		return familyDetails;
	}
	public void setFamilyDetails(List<FamilyDetails> familyDetails) {
		this.familyDetails = familyDetails;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public boolean loginValidation(Customer customer) {
		SigninDaoImpl signinDaoImpl = new SigninDaoImpl();
		boolean loginValidate = false;
		try {
			 loginValidate = signinDaoImpl.Customerlogin(customer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return loginValidate;
		
	}

	
	

}
