package com.vechicle.rescue.entity;

import jakarta.persistence.Entity;
import java.util.List;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	private String customerName;
	private String phoneNumber;
	private String email;
	@OneToMany(mappedBy = "customer")
	private List<Vehicle> vehicles;
	public Customer() {
		
	}
	
	public Customer(int customerId,String customerName,String phoneNumber,String email) {
		this.customerId=customerId;
		this.customerName=customerName;
		this.phoneNumber=phoneNumber;
		this.email=email;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId=customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName=customerName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber=phoneNumber;
	}
    public String getEmail() {
    	return email;
    }
    public void setEmail(String email) {
    	this.email=email;
    }
}
