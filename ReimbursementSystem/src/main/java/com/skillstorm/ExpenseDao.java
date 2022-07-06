package com.skillstorm;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Set;

import com.skillstorm.javabeans.Employee;

public class ExpenseDao {
	
	//instance variables are NOT thread safe
	private Connection connection;
	
	
	public ExpenseDao() throws SQLException {
		
		Properties props = new Properties();
		
		InputStream in = ClassLoader.getSystemResourceAsStream("application.properties");
		
		try {
			props.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url = props.getProperty("database.url");
		String username = props.getProperty("database.username");
		String password = props.getProperty("database.password");
		
		this.connection = DriverManager.getConnection(url, username, password);
	}

	//we need out CRUD statements
	public Employee createEmployeeRecord(Employee employee) throws SQLException
	{
		String sql = "insert into expense(name, reason, notes)values(?,?,?)";
		
		/*
		 * create a sql statement the question marks represent code that will be filled
		 * in safely with the prepared statement
		 */
		String name = "";
		String reason = "";
		String notes = "";
		
		/*
		 * we will use this interface to create a statement that will send our sql to
		 * database.  this will create a statementImpl object in memory. 
		 * factory method design pattern
		 * polymorphism 
		 */
		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		/*
		 * set string means were setting the SQL string to replace the ? for SOME reason
		 * the index of ? a string array starts at 1 each ? needs a value or it wont
		 * compile
		 */
		statement.setString(1, employee.getName());
		statement.setString(2, employee.getReason());
		statement.setString(3, employee.getNotes());
		
		statement.executeUpdate();
		System.out.println(statement);
		//this will create a resultSet object of generated keys from the database
		ResultSet rs = statement.getGeneratedKeys(); //our flag above will prevent a thrown exception
		rs.next();
		int generatedId = rs.getInt(1);
		
		//take the generated Id and give it to the employee
		employee.setId(generatedId);
		
		return employee;
	}
	
	//set is good so we dont have duplicates
	public Set<Employee> findAll() throws SQLException
	{
		String sql = "select employeeId, name, reason, notes from expense;";
		Set<Employee> employeeSet = new HashSet<Employee>();
		
		//here it is SAFE to use a Statement interface instead of PreparedStatement
		//because were not taking input from the user
		Statement statement = connection.createStatement();
		
		//this will return our result set object
		//normally the cursor is just before the first record
		ResultSet resultSet = statement.executeQuery(sql);
		System.out.println(statement);
		while(resultSet.next()) 
		{
			Employee row = new Employee();
			
			//the cursor will return this index from the column im pointing it to
			int id = resultSet.getInt("employeeId");
			String name = resultSet.getString("name");
			String reason = resultSet.getString("reason");
			
			row.setId(id);
			row.setName(name);
			row.setReason(reason);
			
			employeeSet.add(row);
		}
		
		return employeeSet;
	}
	
	public Employee findById(int id) throws SQLException 
	{
		String sql = "Select employeeId, name, reason, notes from expense where employeeId = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setInt(1, id);		
		
		ResultSet resultSet = statement.executeQuery();
		//we need to call next
		if(resultSet.next()) 
		{
			return new Employee(resultSet.getInt("employeeId"), resultSet.getString("name"),
					resultSet.getString("reason"), resultSet.getString("notes"));
		}else 
		{
			return null;
		}
		
	}
	
	public boolean deleteRecord(int id) throws SQLException
	{
		String sql = "delete from expense where employeeId = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		return statement.executeUpdate() == 1;
	}
	
	
	public boolean UpdateRecord(Employee employee) throws SQLException 
	{
		String sql = "update expense set Name = ?, reason = ?, notes = ? where employeeId = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, employee.getName());
		statement.setString(2, employee.getReason());
		statement.setString(3, employee.getNotes());
		statement.setInt(4, employee.getId());
		return statement.executeUpdate() == 1;
	}
	
}
