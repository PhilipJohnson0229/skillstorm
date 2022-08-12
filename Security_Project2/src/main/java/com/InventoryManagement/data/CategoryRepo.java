package com.InventoryManagement.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.InventoryManagement.beans.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
