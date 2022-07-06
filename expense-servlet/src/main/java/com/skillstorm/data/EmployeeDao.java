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
	public List<Employee> findAll(){
		return data;
	}
	public void add(Employee employee) {
		data.add(employee);
	}
	
}
