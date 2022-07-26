package com.InventoryManagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.InventoryManagement.beans.Item;

@Controller
public class ItemController {

	//means this method will be mapped to a GET request
	@GetMapping("/test-item")
	@ResponseBody //this tells spring not to redirect to another page just inject data into response body
	public Item getTestItem() 
	{
		return new Item(1, "5 Hour Energy");
	}
}
