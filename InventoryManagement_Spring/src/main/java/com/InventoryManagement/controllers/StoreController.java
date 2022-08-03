package com.InventoryManagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.InventoryManagement.beans.Item;
import com.InventoryManagement.beans.Store;
import com.InventoryManagement.data.ItemRepo;
import com.InventoryManagement.data.StoreRepo;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/store/")
@CrossOrigin(origins = "*") // Spring MVC doesn't allow CORS by default
@Tag(description = "Artist API", name = "API Info")
public class StoreController {

	@Autowired
	private StoreRepo repo;
	
	//means this method will be mapped do a GET request
	//@ResponseBody //this tells spring not to redirect to another page just inject data into response body
	@GetMapping("{id}")
	public Store findById(@PathVariable int id) 
	{
		return repo.findById(id).get();
	}
	
	@GetMapping
	@ResponseBody
	public Object findAll(@RequestParam (required = false) String name) 
	{
		if(name != null) 
		{
			return repo.findByNameLike("%" + name + "%");
		}else 
		{
			return repo.findAll();
		} 
	}
}
