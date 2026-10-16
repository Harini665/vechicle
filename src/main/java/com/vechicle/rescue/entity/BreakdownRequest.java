package com.vechicle.rescue.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BreakdownRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rescueId;

    private String problemType;
    private String description;
    private String location;
    private int priority;
    private String status;
    private LocalDate requestDate;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    // No-argument constructor required by Hibernate
    public BreakdownRequest() {
    }

    // Parameterized constructor
    public BreakdownRequest(
            String problemType,
            String description,
            String location,
            int priority,
            String status,
            LocalDate requestDate) {

        this.problemType = problemType;
        this.description = description;
        this.location = location;
        this.priority = priority;
        this.status = status;
        this.requestDate = requestDate;
    }

    // Getter for rescueId
    public int getRescueId() {
        return rescueId;
    }

    // Setter for rescueId
    public void setRescueId(int rescueId) {
        this.rescueId = rescueId;
    }

    public String getProblemType() {
        return problemType;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}