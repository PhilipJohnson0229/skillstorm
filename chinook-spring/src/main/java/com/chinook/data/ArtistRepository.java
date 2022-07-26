package com.chinook.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chinook.beans.Artist;

// CRUD - DAO (any objects) vs Repository (centered around ONE object)
@Repository					// CrudRepository -> PagingAndSortingRepository -> JpaRepository
public interface ArtistRepository extends JpaRepository<Artist, Integer>{
	// bind the Hibernate Session to the Thread - ThreadContext
	
	// findBy  - query methods
	// parsing the method name to extract props to query on
	// where name like ?
	public List<Artist> findByNameLike(String name); 
	// if the method returns a single value, hqlQuery.uniqueResult(); 
	// if returns Iterable, hqlQuery.list();
	
}

// generic interface for Hibernate (engine that provides CRUD functionality)