package com.InventoryManagement.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.InventoryManagement.beans.Item;

@Repository						  //change this to JpaRepository when ready to go past basic CRUD
public interface ItemRepo extends JpaRepository<Item, Integer>{
	
	// a find by/query method
	public List <Item> findByNameLike(String name);
	//even though were trying to retrieve a single item we have to do this to return a UNIQUE result
	//if more than one item is found then it will return an iterable hqlQuery.List()
}
