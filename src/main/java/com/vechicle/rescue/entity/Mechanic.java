package com.vechicle.rescue.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mechanic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mechanicId;
	private String mechanicName;
	private String phone;
	private String specialization;
	private String availabilityStatus;
	
	
	public Mechanic() {
		
	}
	
	public Mechanic(String mechanicName, String phone,String specialization,String availabilityStatus) {
		this.mechanicName=mechanicName;
		this.specialization=specialization;
		this.phone=phone;
		this.availabilityStatus=availabilityStatus;
		
	}
	
	public int getMechanicId() {
		return mechanicId;
	}
	public void setMechanicId(int mechanicId) {
		this.mechanicId = mechanicId;
	}
	public String getMechanicName() {
		return mechanicName;
	}
	public void setMechanicName(String mechanicName) {
		this.mechanicName = mechanicName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone=phone;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization=specialization;
	}
	public String getAvailabilityStatus() {
		return availabilityStatus;
	}
	public void setAvailabilityStatus(String availabilityStatus) {
		this.availabilityStatus=availabilityStatus;
	}
     
}
