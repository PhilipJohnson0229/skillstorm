package com.skillstorm;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/**
 * @author phili
 * will take input from user to query database and return
 * info about their expense reimbursement status
 */
public class Expense {
	public static void main(String[] args) throws SQLException{
		//establish the connection
		//we cant instantiate a connection because its an interface 
		//so we use driver managers static method
		Connection conn;
		
		String url = "";
		
		String username = "";
		
		String password = "";
		
		//were going to need to load these values from a properties file using classloader
		
		Properties props = new Properties();
		
		InputStream in = ClassLoader.getSystemResourceAsStream("application.properties");
		
		try {
			props.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		url = props.getProperty("database.url");
		username = props.getProperty("database.username");
		password = props.getProperty("database.password");
		
		//connect to the database
		conn = DriverManager.getConnection(url, username, password);
		
		
		//create a sql statement
		//the question marks represent code that will be filled in safely with 
		//the prepared statement
		String sql = "insert into expense(name, reason, notes)values(?,?,?);";
		String name = "wanda";
		String reason = "lost items";
		String notes = "cant find my stapler and hole puncher";
		
		//we will use this interface to create a statement that will send our sql to database
		//this will create a statementImpl object in memory
		//factory method design / polymorphism
		//the challenge is that we allow the user to potentially hurt us with sql injection
		//prepared statement creates paramaterized sql statements to avoid command injection
		PreparedStatement statement = conn.prepareStatement(sql);
		
		//set string means were setting the SQL string to replace the ?
		//for SOME reason the index of ? a string array starts at 1
		//each ? needs a value or it wont compile
		statement.setString(1, name);
		statement.setString(2, reason);
		statement.setString(3, notes);
		
		statement.executeUpdate();
		
		//jdbc allows us to create paramaterized inputs to prevent sql/command injection hacks
		
		
		
		if(!conn.isClosed()) 
		{
			System.out.println("Were in and we did an insert!");
			System.out.println("We inserted via " + statement);
		}
		
		conn.close();
		System.out.println("Now were out");
	}
}
