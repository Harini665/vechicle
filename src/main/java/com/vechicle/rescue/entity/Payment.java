package com.vechicle.rescue.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	private double amount;
	private LocalDate paymentDate;
	private String paymentMethod;
	private String paymentStatus;
	@ManyToOne
	@JoinColumn(name="assignment_id")
	private Assignment assignment;
	public Payment() {
		
	}
	
	public Payment(double amount,LocalDate paymentDate, String paymentMethod,String paymentStatus) {
		this.amount=amount;
		this.paymentDate=paymentDate;
		this.paymentMethod=paymentMethod;
		this.paymentStatus=paymentStatus;
		
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount=amount;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate=paymentDate;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod=paymentMethod;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus=paymentStatus;
	}
	public Assignment getAssignment() {
		return assignment;
	}
	public void setAssignment(Assignment assignment) {
		this.assignment=assignment;
	}
	public int getPaymentId() {
	    return paymentId;
	}

	public void setPaymentId(int paymentId) {
	    this.paymentId = paymentId;
	}
	

}
