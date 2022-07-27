package com.chinook.services;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.chinook.beans.Track;
import com.chinook.controllers.TrackedRepository;

@Service
public class TrackService {

	private static final int DEFAULT_PAGE_SIZE = 10;
	
	private TrackedRepository repository;
	
	public List<Track> findTracksByArtist(int artistId, int page)
	{
		return repository.findByAlbum_Artist_Id(artistId,PageRequest.of(page, DEFAULT_PAGE_SIZE)).toList();
	}
	
	//delegation pattern
	public long count() 
	{
		return repository.count();
	}
}
