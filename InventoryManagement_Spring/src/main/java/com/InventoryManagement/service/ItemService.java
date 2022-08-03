package com.InventoryManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.InventoryManagement.beans.Item;



@Service
public class ItemService {

	public ItemService() {
		System.out.println("new ItemService()");
	}	
	
}
