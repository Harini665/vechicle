package com.vechicle.rescue.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vehicleId;
	private String vechicleNumber;
	private String vechicleType;
	private String brand;
	private String model;
	private int manufactoringYear;
	private String fuelType;
	@ManyToOne
	@JoinColumn(name ="customer_id")
	private Customer customer;
	
	
	public Vehicle() {
		
	}
	
	public Vehicle(String vechicleNumber,String vechicleType,String brand,String model,int manufactoringYear,String fuelType) {
		this.vechicleNumber=vechicleNumber;
		this.vechicleType = vechicleType;
		this.brand=brand;
		this.model=model;
		this.manufactoringYear = manufactoringYear;
		this.fuelType=fuelType;
	}
	public Customer getCustomer() {
	    return customer;
	}

	public void setCustomer(Customer customer) {
	    this.customer = customer;
	}
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId=vehicleId;
	}
	public String getVechicleNumber() {
		return vechicleNumber;
	}
	public void setVechicleNumber(String vechicleNumber) {
		this.vechicleNumber=vechicleNumber;
	}
	public String getVechicleType() {
		return vechicleType;
	}
	public void setVechicleType(String vechicleType) {
		this.vechicleType=vechicleType;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand=brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model=model;
	}
	public int getManufactoringYear() {
		return manufactoringYear;
	}
	public void setManufactoringYear(int manufactoringYear) {
		this.manufactoringYear=manufactoringYear;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType=fuelType;
	}

}
