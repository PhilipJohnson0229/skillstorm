package com.chinook.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chinook.beans.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer>{
	
	/// object traversal - starting at Album, I can move through properties
	// @Query disables the methodName parsing feature 
	@Query("FROM Album alb inner join alb.artist a where a.name = ?1") // JPQL
	public List<Album> findByArtistNameBlahBlah(String name);
	
	// From Album inner join artist a where a.name = ? 
	
}
