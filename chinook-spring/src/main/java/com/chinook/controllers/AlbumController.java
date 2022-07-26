package com.chinook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinook.beans.Album;
import com.chinook.data.AlbumRepository;

@RestController
@RequestMapping("/album")
public class AlbumController {

	@Autowired
	private AlbumRepository albumRepository;
	
	@GetMapping  /// GET /album?q=Metallica
	public List<Album> getDiscography(@RequestParam(name = "q", required = true) String name){
		return albumRepository.findByArtistNameBlahBlah(name);
	}
	
}
