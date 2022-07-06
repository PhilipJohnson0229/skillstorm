package com.skillstorm.javabeans;

public class ReimbursementStatus {

	private enum status{Pending, Approved, Denied}
	
	private status currentStatus;

	public ReimbursementStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReimbursementStatus(status currentStatus) {
		super();
		this.currentStatus = currentStatus;
	}

	public status getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(status currentStatus) {
		this.currentStatus = currentStatus;
	}
	
	
	
}
