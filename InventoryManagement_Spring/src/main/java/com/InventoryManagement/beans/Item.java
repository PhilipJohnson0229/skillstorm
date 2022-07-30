package com.InventoryManagement.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

//Hibernate implementation JPA

//this will be a stateful bean because it stores application state
@Entity
@Table(name="Item")
public class Item{

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "catFk")
	private int catFk;
	
	@Column(name = "strFk")
	private int strFk;
	//private ApplicationContext applicationContext;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(int id, String name, int catFk, int strFk) {
		super();
		this.id = id;
		this.name = name;
		this.catFk = catFk;
		this.strFk = strFk;
	}

	public Item(String name) {
		super();
		this.name = name;
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

	public int getCatFk() {
		return catFk;
	}

	public void setCatFk(int catFk) {
		this.catFk = catFk;
	}

	public int getStrFk() {
		return strFk;
	}

	public void setStrFk(int strFk) {
		this.strFk = strFk;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", catFk=" + catFk + ", strFk=" + strFk + "]";
	}
	
	
}
