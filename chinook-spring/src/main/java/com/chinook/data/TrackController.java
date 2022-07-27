package com.chinook.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinook.beans.Track;
import com.chinook.controllers.TrackedRepository;

@RestController
public class TrackController {
	@Autowired
	private TrackedRepository repository;


	@GetMapping("/tracks/count")
	public Long count() 
	{
		return repository.count();
	}
	
	@GetMapping("/tracks")
	public List<Track> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam int size)
	{
		return  repository.findAll(PageRequest.of(page, size)).toList();
	}
	
	public List<Track> pageableTracksByArtist(@PathVariable int artistId, int page)
	{
		int size = 100;
		return repository.findByAlbum_Artist_Id(artistId, PageRequest.of(page, size)).toList();
	}
	
}
