package com.chinook.controllers;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.chinook.beans.Track;

@Repository
public interface TrackedRepository extends PagingAndSortingRepository<Track, Integer>{

	//this is passable CASE with he underscores
	public Page<Track> findByAlbum_Artist_Id(int artistId, Pageable request);
	
	@Query("from track t inner join t.album alb inner join alb.artist art ")
	public Page<Track> findTracksPaged(Pageable request);
}
