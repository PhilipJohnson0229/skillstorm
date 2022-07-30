package com.InventoryManagement.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.InventoryManagement.beans.Item;
import com.InventoryManagement.data.ItemRepo;
import com.InventoryManagement.service.ItemService;
import com.fasterxml.jackson.databind.json.JsonMapper;



@RestController
@RequestMapping("/item/")
public class ItemController {
	
	@Autowired
	private ItemRepo repo;
	
	//means this method will be mapped do a GET request
	//@ResponseBody //this tells spring not to redirect to another page just inject data into response body
	@GetMapping("{id}")
	public Item findById(@PathVariable int id) 
	{
		return repo.findById(id).get();
	}
	
	
	
	@PostMapping("/add")
	public void addItemToDB(@RequestParam int id, @RequestParam String name, @RequestParam int catId, @RequestParam int strId){
		 Item newItem = new Item();
		 newItem.setId(id);
		 newItem.setName(name);
		 newItem.setCatFk(catId);
		 newItem.setStrFk(strId);
		 
	     repo.save(newItem);
	}
	 
	@GetMapping
	@ResponseBody
	public Object findAll(@RequestParam (required = false) String name) 
	{
		if(name != null) 
		{
			return repo.findItemByName("%" + name + "%");
		}else 
		{
			return repo.findAll();
		} 
	}
	
	@DeleteMapping
	public void delete(@PathVariable int id) 
	{
		repo.deleteById(id);
	}
	
	@PutMapping("{id}") // PUT 
	public Item update(@RequestBody Item item, @PathVariable int id) {
		if (repo.existsById(id)) {
			item.setId(id); // don't trust user to use your system as intended
			return repo.save(item);
		} else {
			// you ain't updating, you saving
			throw new IllegalArgumentException("ID doesn't exist");
		}
	}
}
