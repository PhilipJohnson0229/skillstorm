package com.chinook.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.chinook.beans.Artist;
import com.chinook.data.ArtistRepository;

@RestController
@RequestMapping("/artist") // baseUrl for this controller
@CrossOrigin(origins = "*") // Spring MVC doesn't allow CORS by default
public class ArtistController {

	@Autowired
	private ArtistRepository repository;

	// http://localhost:8080/artist/155 - PathVariable
	@GetMapping("/{id}")
	public ResponseEntity<Artist> findById(@PathVariable int id) {
		return ResponseEntity.ok(repository.findById(id).orElse(new Artist()));
	}

	@PostMapping // objectMapper.readValue(req.getInputStream(), Artist.class)
	public ResponseEntity<Artist> save(@Valid @RequestBody Artist artist) { // 400
		return new ResponseEntity<>(repository.save(artist), HttpStatus.CREATED);
	}

	@GetMapping
	@ResponseBody // resp.getWriter(objectMapper.writeValueAsString(json))
	public Object findAll(@RequestParam(required = false) String name) {
		if (name != null) {
			return repository.findByNameLike("%" + name + "%");
		} else {
			return repository.findAll();
		}
	}

	@DeleteMapping("/{id}") // 204 No Content			// DELETE /artist/11
	public ResponseEntity<Void> delete(@PathVariable int id) {
		repository.deleteById(id);
		//ResponseEntity.status(502).build();
		return ResponseEntity.noContent().header("Custom-Header", "abcde").build();
	}

	@PutMapping("/{id}") // PUT /artist/56
	public Artist update(@RequestBody Artist artist, @PathVariable int id) {
		if (repository.existsById(id)) {
			artist.setId(id); // don't trust user to use your system as intended
			return repository.save(artist);
		} else {
			// you ain't updating, you saving
			throw new IllegalArgumentException("ID doesn't exist");
		}
	}

}
