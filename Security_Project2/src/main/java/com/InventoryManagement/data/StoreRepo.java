package com.InventoryManagement.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.InventoryManagement.beans.Store;

@Repository
public interface StoreRepo extends JpaRepository<Store, Integer> {

}
