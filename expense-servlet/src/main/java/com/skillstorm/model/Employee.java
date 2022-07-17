package com.skillstorm.model;

import java.io.Serializable;

import com.skillstorm.model.Employee;

public class Employee implements Serializable{
	
	private int id;
	private String name;
	private String reason;
	private String notes;
	
	public Employee() {
		super();
	}

	public Employee(int id, String name, String reason, String notes) {
		super();
		this.id = id;
		this.name = name;
		this.reason = reason;
		this.notes = notes;
	}

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Employee(String name) {
		super();
		this.name = name;
		this.reason = "";
		this.notes = "";
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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", reason=" + reason + ", notes=" + notes + "]";
	}
	
	
}
