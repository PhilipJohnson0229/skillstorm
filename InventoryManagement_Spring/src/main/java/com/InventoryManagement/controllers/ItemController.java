package com.InventoryManagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.InventoryManagement.beans.Item;
import com.InventoryManagement.data.ItemRepo;
import com.InventoryManagement.service.ItemService;



@RestController
@RequestMapping("/item/")
public class ItemController {
	
	@Autowired
	private ItemRepo repo;
	
	//means this method will be mapped to a GET request
	//@ResponseBody //this tells spring not to redirect to another page just inject data into response body
	@GetMapping("{id}")
	public Item findById(@PathVariable int id) 
	{
		return repo.findById(id).get();
	}
	
	@PostMapping
	public Item saveItem(@RequestBody Item item) 
	{
		return repo.save(item);
	}
	
	@GetMapping
	@ResponseBody
	public Iterable<Item> findAll() 
	{
		return repo.findAll();
	}
	
	@DeleteMapping
	public void delete(@PathVariable int id) 
	{
		repo.deleteById(id);
	}
	
	@PutMapping("{id}") // PUT /artist/56
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
