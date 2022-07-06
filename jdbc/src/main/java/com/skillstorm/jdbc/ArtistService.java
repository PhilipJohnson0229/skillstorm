package com.skillstorm.jdbc;

import java.sql.SQLException;

public class ArtistService {

	public void processData() {
		try {
			ArtistDAO dao = new ArtistDAO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
