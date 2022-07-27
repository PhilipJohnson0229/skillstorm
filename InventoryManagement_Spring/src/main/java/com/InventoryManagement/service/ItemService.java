package com.InventoryManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InventoryManagement.data.ItemDaoImpl;


@Service
public class ItemService {

	public ItemService() {
		System.out.println("new ItemService()");
	}

	//@Autowired
	private ItemDaoImpl repository;
}
