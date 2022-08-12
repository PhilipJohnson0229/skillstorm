package com.InventoryManagement.controllers;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.InventoryManagement.beans.Item;
import com.InventoryManagement.service.ItemService;

//receives requests and passes the params and path vriables to the service
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/items")
public class ItemController {
	
	private static final Logger log = LoggerFactory.getLogger(ItemController.class);
	
    @Autowired
    private ItemService service;

    @GetMapping("/getItems")
	@ResponseBody					//Pagination -> ItemRepo extends PagingAndSortingRepository
    public List<Item> getItems(@RequestParam(defaultValue = "0") int page){
        return service.findAll(page);
    }
    
    @GetMapping("/getStoreItemsId")
    public List<Item> getItemsByStoreId(@RequestParam(name = "id", required = true) int id, Authentication principal){
    	//SecurityContext - stores all Authentication info in HttpSession
    	//SecurityContextHolder
    	log.info("using the getItemsByStoreId method and the requested id is " + id);
    	log.debug("we're in the findById method"); // INFO default threshold
		log.debug("findById URL: /artist/" + id);
		log.info("Current user: " + principal.getName());
        return service.findItemByStoreId(id);
    }
    
    @GetMapping("/getStoreItemsName")
    public List<Item> getItemsByStoreName(@RequestParam(name = "name", required = true) String name){
        return service.findItemByStoreName(name);
    }
    
    @PostMapping // objectMapper.readValue(req.getInputStream(), Artist.class)
	@Transactional // 
	public ResponseEntity<Item> save(@Valid @RequestBody Item item) { // 400
		return new ResponseEntity<>(service.save(item), HttpStatus.CREATED);
	}
	
	@PostMapping("/many")  
	@Transactional //(rollbackFor = org.h2.jdbc.JdbcSQLDataException.class)
	public ResponseEntity<Void> saveMany(@RequestBody List<Item> items) { 
		for (Item item : items) {
			service.save(item); // any one fails - rollback
		}
		return ResponseEntity.noContent().build();
	}
	
	//TODO need to implement update and delete methods that preauthenticate with admin role
}