package com.InventoryManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.InventoryManagement.beans.Item;
import com.InventoryManagement.data.ItemRepo;


//provides layer of abstraction between controller and repo

//controllers will take in request information
//services will house business logic 

@Service
public class ItemService {
	
	private static final int DEFAULT_PAGE_SIZE = 10;
	
	@Autowired
	private ItemRepo repo;
	
	
	public List<Item> findItemByStoreId(int storeId)
	{
		return repo.findByStoreId(storeId);
	} 
	
	
	public List<Item> findItemByStoreName(String name)
	{
		return repo.findByStoreName(name);
	} 
	
	
	//delegation pattern - provides a layer between two components for more control
	public Long count() 
	{
		return repo.count();
	}
	
	
	public List<Item> findAll(int page) 
	{
		return repo.findAll(PageRequest.of(page, DEFAULT_PAGE_SIZE)).toList();
	}
	
	
	public Item save(Item item) 
	{
		return repo.save(item);
	}
	
	//TODO need to add update and delete methods that preauthenticate
	//@Transactional(propagation = Propagation.REQUIRED) // use an existing transaction (if none, creates one)
	//@PreAuthorize("hasAnyRole('ADMIN', 'USER')") // security at the method level
}
