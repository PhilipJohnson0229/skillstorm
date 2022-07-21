package com.skillstorm.model;

import java.io.Serializable;

import com.skillstorm.model.Employee;

public class Employee implements Serializable{
	
	private int id;
	private String name;
	private String reason;
	private String notes;
	private int statusId;
	
	

	public Employee() {
		super();
		this.statusId = 0;
	}

	public Employee(int id, String name, String reason, String notes) {
		super();
		this.id = id;
		this.name = name;
		this.reason = reason;
		this.notes = notes;
		this.statusId = 0;
	}

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.reason ="";
		this.notes = "";
		this.statusId = 0;
	}
	
	public Employee(String name, String reason, String notes) {
		super();
		this.name = name;
		this.reason = reason;
		this.notes = notes;
		this.statusId = 0;
	}
	
	public Employee(String name) {
		super();
		this.name = name;
		this.reason = "";
		this.notes = "";
		this.statusId = 0;
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
	
	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	//for some reason i had an issue with the hashcode and equals method

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", reason=" + reason + ", notes=" + notes + "]";
	}
	
	
}
