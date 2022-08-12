package com.InventoryManagement.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.InventoryManagement.beans.User;



public interface UserRepo extends JpaRepository<User, Long> {
    
	
	
    Optional<User> findByUsername(String username);
}