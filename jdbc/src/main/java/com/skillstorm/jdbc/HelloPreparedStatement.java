package com.skillstorm.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HelloPreparedStatement {

	public static void main(String[] args) throws SQLException {
		// 1. establish a Connection to the database
		String url = "jdbc:mysql://localhost:3306/chinook";
		String username = "root";
		String password = "welcome1";
		
		// Factory method - new com.mysql.cj.jdbc.ConnectionImpl()
		Connection conn = DriverManager.getConnection(url, username, password); 
		// Connection conn = new com.mysql.cj.jdbc.ConnectionImpl(HostInfo hostInfo)
		
		// 2. issue the SQL statement 
		String userInput = "band'); drop table users; --";
		
		String sql = "insert into Artist(Name) values (?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, userInput); // all ?s must have a value for the SQL to compile
		statement.executeUpdate(); // insert, update, delete, create, alter, drop
		
		System.out.println(statement);
		
		System.out.println("Finished");
		
		// 3. close the connection
		conn.close();
	}
	
}
