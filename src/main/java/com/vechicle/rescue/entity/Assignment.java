package com.vechicle.rescue.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Assignment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int assignmentId;
	private LocalDate assignedDate;
	private String status;
	@ManyToOne
	@JoinColumn(name="rescue_id")
	private BreakdownRequest breakdownRequest;
    @ManyToOne
    @JoinColumn(name="mechanic_id")
    private Mechanic mechanic;
    
    public Assignment() {
    	
    }
    
    public Assignment(LocalDate assignedDate,String status) {
    	this.assignedDate=assignedDate;
    	this.status=status;
    }
    public int getAssignmentId() {
    	return assignmentId; 
    } 
    public void setAssignmentId(int assignmentId) {
    	this.assignmentId = assignmentId;
    }
    public LocalDate getAssignedDate() {
    	return assignedDate;
    }
    public void setAssignedDate(LocalDate assignedDate) {
    	this.assignedDate=assignedDate;
    }
    public String getStatus() {
    	return status;
    }
    public void setStatus(String status) {
    	this.status=status;
    }
    public BreakdownRequest getBreakdownRequest() {
    	return breakdownRequest; 
    }
    public void setBreakdownRequest(BreakdownRequest breakdownRequest) {
        this.breakdownRequest = breakdownRequest; 
    }
    public Mechanic getMechanic() { 
        return mechanic; 
    }
    public void setMechanic(Mechanic mechanic) {
    	this.mechanic = mechanic; 
    }
}
