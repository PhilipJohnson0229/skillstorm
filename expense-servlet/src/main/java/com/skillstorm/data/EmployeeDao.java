package com.skillstorm.data;

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
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import com.skillstorm.model.Employee;



public class EmployeeDao {
	
	List<Employee> data = new CopyOnWriteArrayList<>(); // write (ConcurrentModificationException)
	
	public EmployeeDao() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/expensereimbursements";
		String username = "root";
		String password = "Newlife123";
		this.connection = DriverManager.getConnection(url, username, password);
		System.out.println("connection made to database");
	}
	
	private Connection connection;

	
	// CRUD
	// Domain object - POJO/JavaBean that represents data for our app
	public Employee create(Employee employee) throws SQLException {
		String sql = "insert into expense(name, reason, notes, StatusId) values (?,?,?,0)";				// flag: please return my keys
		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, employee.getName());
		statement.setString(2, employee.getReason());
		statement.setString(3, employee.getNotes());
		
		statement.executeUpdate();
		
		// grab the id - ResultSet = statement.getGeneratedKeys()
		ResultSet rs = statement.getGeneratedKeys(); // without the flag, this throws an exception
		rs.next();
		int generatedId = rs.getInt(1);
		employee.setId(generatedId);
		System.out.println("Employee created");
		return employee;
		
	}

	public Set<Employee> findAll() throws SQLException {
		// ResultSet
		Set<Employee> employees = new HashSet<Employee>(); // store the artists to be returned at the end
		String sql = "select employeeId, name, reason, notes, StatusId from expense";

		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			Employee row = new Employee();

			// extracted the value from the database table
			int id = resultSet.getInt("employeeId");
			String name = resultSet.getString("name");
			String reason = resultSet.getString("reason");
			String notes = resultSet.getString("notes");
			int statusId = resultSet.getInt("StatusId");

			// store it in the Java object
			row.setId(id);
			row.setName(name);
			row.setNotes(notes);
			row.setReason(reason);
			row.setStatusId(statusId);	
			
			employees.add(row);
		} //
		return employees;
	}
	
	public boolean update(Employee employee) throws SQLException {
		String sql = "update expense set StatusId = ? where employeeId = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, employee.getStatusId());
		statement.setInt(2, employee.getId());
		return statement.executeUpdate() == 1;
	}

	
}
