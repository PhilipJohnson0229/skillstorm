package com.skillstorm.model;

public class ReimbursementStatus {

	private int id = 0;
	
	private String status;
	
	public ReimbursementStatus() 
	{
		super();
		this.setStatus();
	}

	public ReimbursementStatus(int id) 
	{
		super();
		this.setStatus(id);
	}
	
	public int getId() {
		return id;
	}

	public boolean setId(int id) {
		
		this.id = id;
		this.setStatus(id);
		if(id != 0) 
		{
			return true;
		}
		return false;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus() {
		switch(this.id) 
		{
		case 0:
			this.status = "Pending";
			this.id = 0;
			break;
		case 1:
			this.status = "Approved";
			this.id = 1;
			break;
		case 2:
			this.status = "Denied";
			this.id = 2;
		}
		
	}
	
	public void setStatus(int id) {
		switch(id) 
		{
		case 0:
			this.status = "Pending";
			break;
		case 1:
			this.status = "Approved";
			break;
		case 2:
			this.status = "Denied";
		}
		
	}

	@Override
	public String toString() {
		return "ReimbursementStatus [id=" + id + ", status=" + status + "]";
	}

	
}
