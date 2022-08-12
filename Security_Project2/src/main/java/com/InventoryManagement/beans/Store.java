package com.InventoryManagement.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="store")
public class Store {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "Name")
	@NotBlank
	private String name;
	
	@Column(name = "location")
	private String location;
	
	
	@OneToMany(mappedBy = "store")
	@JsonIgnore
	private Set<Item> items;

	public Store() {
		super();
	}


	public Store(int id, String name, String location, Set<Item> items) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.items = items;
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



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}


	public Set<Item> getItems() {
		return items;
	}


	public void setItems(Set<Item> items) {
		this.items = items;
	}


	@Override
	public String toString() {
		return "Store [id=" + id + ", name=" + name + ", location=" + location +"]"; //do not put mappedBy variahles here
	}



	

	
}
