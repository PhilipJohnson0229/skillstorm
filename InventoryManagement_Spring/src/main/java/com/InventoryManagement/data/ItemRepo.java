package com.InventoryManagement.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.InventoryManagement.beans.Item;

@Repository
public interface ItemRepo extends CrudRepository<Item, Integer>{
	
}
