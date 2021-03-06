package com.skillstorm.model;

import java.io.Serializable;

import com.skillstorm.model.Employee;

public class Employee implements Serializable{
	
	private int id;
	private String name;
	private String reason;
	private String notes;
	private int statusId;
	private ReimbursementStatus status;
	
	

	public Employee() {
		super();
		this.status = new ReimbursementStatus();
		this.statusId = this.status.getId();
	}

	public Employee(int id, String name, String reason, String notes) {
		super();
		this.id = id;
		this.name = name;
		this.reason = reason;
		this.notes = notes;
		this.status = new ReimbursementStatus();
		this.statusId = 0;
	}

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.reason ="";
		this.notes = "";
		this.status = new ReimbursementStatus();
	}
	
	public Employee(String name, String reason, String notes, int statusId) {
		super();
		this.name = name;
		this.reason = reason;
		this.notes = notes;
		this.status = new ReimbursementStatus(statusId);
		this.statusId = statusId;
	}
	
	public Employee(String name) {
		super();
		this.name = name;
		this.reason = "";
		this.notes = "";
		this.status = new ReimbursementStatus();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	//for some reason i had an issue with the hashcode and equals method

	public int getStatusId() {
		this.status.setId(this.statusId);
		return statusId;
	}

	public void setStatusId(int id) {
		this.statusId = id;
	}
	
	public ReimbursementStatus getStatus() {
		return status;
	}

	public void setStatus(ReimbursementStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", reason=" + reason + ", notes=" + notes + ", statusId=" + statusId +"]";
	}
	
	
}
