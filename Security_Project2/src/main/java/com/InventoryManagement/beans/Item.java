package com.InventoryManagement.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Hibernate implementation JPA

//JSR 303 very important security standard
//Bean validation: validation will be done inside the bean itself

//this will be a stateful bean because it stores application state

@Entity
@Table(name="Item")
public class Item{

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	
	@Column(name = "price")
	private String price;

	//@ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne
	@JoinColumn(name ="store_id")
	private Store store;
	
	//@ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne
	@JoinColumn(name ="category_id")
	private Category category;
	
	public Item() {
		super();
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


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public Store getStore() {
		return store;
	}


	public void setStore(Store store) {
		this.store = store;
	}

	

	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", store=" + store + ", category=" + category
				+ "]";
	}


	
	
	
	
}
