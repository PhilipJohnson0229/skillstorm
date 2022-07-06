package com.skillstorm.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.skillstorm.jdbc.beans.Artist;

public class ArtistDAO {
	
	private Connection connection;

	public ArtistDAO() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/chinook";
		String username = "root";
		String password = "welcome1";
		this.connection = DriverManager.getConnection(url, username, password);
	}
	
	// CRUD
	// Domain object - POJO/JavaBean that represents data for our app
	public boolean create(Artist artist) throws SQLException {
		String sql = "insert into Artist(Name) values (?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, artist.getName());
		return statement.executeUpdate() == 1? true : false;
	}
	
	public Set<Artist> findAll() throws SQLException{
		// ResultSet 
		Set<Artist> artists = new HashSet<Artist>(); // store the artists to be returned at the end
		String sql = "select ArtistId, Name from Artist";
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while(resultSet.next()) {
			Artist row = new Artist();
			
			// extracted the value from the database table
			int id = resultSet.getInt("ArtistId");
			String name = resultSet.getString("Name");
			
			// store it in the Java object
			row.setId(id);
			row.setName(name);
			
			artists.add(row);
		}//
		return artists;
	}
	
	public Artist findById(int id) throws SQLException {
		String sql = "select ArtistId, Name from Artist where ArtistId = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		if(rs.next()) {
			return new Artist(rs.getInt("ArtistId"), rs.getString("Name"));
		}else {
			return null;
		}
	}

	public boolean update(Artist artist) {
		throw new UnsupportedOperationException("still working on it....");
	}
	
	public boolean delete(int id) {
		throw new UnsupportedOperationException("still working on it....");
	}

}
