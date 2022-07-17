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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", reason=" + reason + ", notes=" + notes + "]";
	}
	
	
}
