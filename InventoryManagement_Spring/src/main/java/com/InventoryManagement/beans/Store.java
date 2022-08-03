package com.InventoryManagement.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Store")
public class Store {

	@Id
	@Column(name = "storeId")
	private int storeId;
	
	@Column(name = "name")
	@NotBlank //Validator inside bean as per JSR 303
	private String name;
	
	@Column(name = "location")
	private String location;
	
	public Store() 
	{
		super();
	}
	
	public Store(int storeId, String name, String location) 
	{
		this.storeId = storeId;
		this.name = name;
		this.location = location;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", name=" + name + ", location=" + location + "]";
	}
	
	
}
