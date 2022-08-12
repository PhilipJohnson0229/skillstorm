package com.InventoryManagement.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InventoryManagement.beans.Category;
import com.InventoryManagement.data.CategoryRepo;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepo repo;

    
    @GetMapping("/getCategories")
    public List<Category> getCategories(){
        return repo.findAll();
    }
    
    @GetMapping("/category/{id}")
    public Optional<Category> getTestCategory(@PathVariable int id){
        return repo.findById(id);
    }
    
    
}