package com.InventoryManagement.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InventoryManagement.beans.Store;
import com.InventoryManagement.data.StoreRepo;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreRepo repo;

    @PostMapping("/saveStores")
    public ResponseEntity<String> saveStores(@RequestBody List<Store> strData) {
        repo.saveAll(strData);
        return ResponseEntity.ok("Data saved");
    }

    @GetMapping("/getStores")
    public List<Store> getStores(){
        return repo.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Store> getTestStore(@PathVariable int id){
        return repo.findById(id);
    }
    
    @PostMapping("/requestInventory")
    public Store viewStoreInventory(@RequestBody Store store) 
    {
    	System.out.println(store.toString());
    	return repo.save(store);
    }
}