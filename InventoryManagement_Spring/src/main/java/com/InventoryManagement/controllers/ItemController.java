package com.InventoryManagement.controllers;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@RequestMapping("/item/")
@CrossOrigin(origins = "*") // Spring MVC doesn't allow CORS by default
@Tag(description = "Artist API", name = "API Info")
public class ItemController {
	
	@Autowired
	private ItemRepo repo;
	
	//private static final Logger log = LoggerFactory.getLogger(ArtistController.class);

	//means this method will be mapped do a GET request
	//@ResponseBody //this tells spring not to redirect to another page just inject data into response body
	/*@GetMapping("{id}")
	public Item findById(@PathVariable int id) 
	{
		return repo.findById(id).get();
	}*/
	
	
	
	@PostMapping("/add")
	public void addItemToDB(@RequestParam int id, @Valid @RequestParam String name, @RequestParam int catId, @RequestParam int strId){
		 Item newItem = new Item();
		 newItem.setId(id);
		 newItem.setName(name);
		 newItem.setCatFk(catId);
		 newItem.setStrFk(strId);
		 
	     repo.save(newItem);
	}
	
	// http://localhost:8080/artist/155 - PathVariable
	@GetMapping("/{id}")
	public ResponseEntity<Item> findById(@PathVariable int id, Authentication principal) {
		// SecurityContext - stores all Authentication info in HttpSession
		//SecurityContextHolder
		//log.debug("we're in the findById method"); // INFO default threshold
		//log.debug("findById URL: /artist/" + id);
		//log.info("Current user: " + principal.getName());
		return ResponseEntity.ok(repo.findById(id).orElse(new Item()));
	}
	
	@PostMapping // objectMapper.readValue(req.getInputStream(), Artist.class)
	@Transactional // 
	public ResponseEntity<Item> save(@Valid @RequestBody Item artist) { // 400
		return new ResponseEntity<>(repo.save(artist), HttpStatus.CREATED);
	}
	
	@PostMapping("/many")  
	@Transactional //(rollbackFor = org.h2.jdbc.JdbcSQLDataException.class)
	public ResponseEntity<Void> saveMany(@RequestBody List<Item> items) { 
		for (Item artist : items) {
			repo.save(artist); // any one fails - rollback
		}
		return ResponseEntity.noContent().build();
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
	
	@DeleteMapping
	public ResponseEntity<Void> delete(@PathVariable int id) 
	{
		repo.deleteById(id);
		return ResponseEntity.noContent().build();
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
