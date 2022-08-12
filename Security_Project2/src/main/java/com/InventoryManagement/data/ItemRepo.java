package com.InventoryManagement.data;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.InventoryManagement.beans.Item;

@Repository						  //change this to JpaRepository when ready to go past basic CRUD
public interface ItemRepo extends PagingAndSortingRepository<Item, Integer>{
	
	//@Query("from Item i inner join i.store str inner join i.category cat") 
	//this is if we NEED to reduce databse hits
	public Page<Item> findAll(Pageable request);
	
	@Query("From Item i inner join i.store str where str.name = ?1")
	public List<Item> findByStoreName(String name);
	
	@Query("From Item i inner join i.store str where str.id = ?1")
	public List<Item> findByStoreId(int storeId);
}
