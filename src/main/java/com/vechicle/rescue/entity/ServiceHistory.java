package com.vechicle.rescue.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ServiceHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int historyId;
	private String serviceHistory;
	private String serviceDescription;
	private String serviceStatus;
	
	@ManyToOne
	@JoinColumn(name="vehicle_id")
	private Vehicle vehicle;
	public ServiceHistory() {
		
	}
	
	public ServiceHistory(String serviceHistory,String serviceDescription,String serviceStatus) {
		this.serviceHistory=serviceHistory;
		this.serviceDescription=serviceDescription;
		this.serviceStatus=serviceStatus;
	}
	
	public int getHistoryId() {
		return historyId;
	}
	
	public void setHistoryId(int historyId) {
		this.historyId=historyId;
	}
	public String getServiceHistory() {
		return serviceHistory;
	}
	public void setServiceHistory(String serviceHistory) {
		this.serviceHistory=serviceHistory;
	}
	public String getServiceDescription() {
		return serviceDescription;
	}
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription=serviceDescription;
	}
	public String getServiceStatus() {
		return serviceStatus;
	}
	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus=serviceStatus;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
    public void setVehicle(Vehicle vehicle) {
    	this.vehicle=vehicle;
    }
}
