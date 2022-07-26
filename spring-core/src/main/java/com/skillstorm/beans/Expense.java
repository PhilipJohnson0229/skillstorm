package com.skillstorm.beans;

// Stateful - store application state. 
public class Expense {

	private double amount;
	private String reason;
	
	public Expense() {
		super();
		System.out.println("new Expense()");
	}

	public Expense(double amount, String reason) {
		super();
		this.amount = amount;
		this.reason = reason;
	}

	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
