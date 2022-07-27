package com.InventoryManagement.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.InventoryManagement.beans.Item;

//@Repository
public class ItemDaoImpl implements ItemRepo{
	//spring will find these values in out properties file and inject them
	 //this is known as spring expression language
	private String url;
	
	private String username;
	
	private String password;
	
	
	
	public ItemDaoImpl(@Value("${jdbc.datasource.url}") String url, @Value("${jdbc.datasource.username}") String username, @Value("${jdbc.datasource.password}")  String password) {
		
		this.url = url;
		this.username = username;
		this.password = password;
		System.out.printf("connection made to url: %s  username: %s", url, username);
	}
	
	
	 
	public Set<Item> findAll() {
		
		Set<Item> employees = new HashSet<Item>(); // store the artists to be returned at the end
		/*
		 String sql = "select e.employeeid, e.name, e.amount, e.reason, e.notes, e.statusId, s.id, s.Status from expense e inner join reimbursementstatus s on e.statusId = s.id";

		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			Employee row = new Employee();

			// extracted the value from the database table
			int id = resultSet.getInt("employeeId");
			String name = resultSet.getString("name");
			String amount = resultSet.getString("amount");
			String reason = resultSet.getString("reason");
			String notes = resultSet.getString("notes");
			int statusId = resultSet.getInt("statusId");
			
			Double purchaseAmount = new Double(amount); 
			// store it in the Java object
			row.setId(id);
			row.setName(name);
			row.setAmount(purchaseAmount);
			row.setNotes(notes);
			row.setReason(reason);
			row.setStatus(new ReimbursementStatus());
			row.setStatusId(statusId);
			
			
			employees.add(row);
		} */
	
		return employees;
	}



	@Override
	public <S extends Item> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends Item> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Optional<Item> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}



	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public Iterable<Item> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void delete(Item entity) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deleteAll(Iterable<? extends Item> entities) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
}
