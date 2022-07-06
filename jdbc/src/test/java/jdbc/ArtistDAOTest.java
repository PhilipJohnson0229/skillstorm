package jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.skillstorm.jdbc.ArtistDAO;
import com.skillstorm.jdbc.beans.Artist;

public class ArtistDAOTest {
	
	static ArtistDAO dao;
	
	@BeforeClass
	public static void setup() {
		try {
			dao = new ArtistDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() {
		try {
			dao.update(new Artist(60, "Santana without Dave Matthew"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore // skip this test (hacky)
	public void delete() {
		try {
			boolean deleted = dao.delete(276);
			System.out.println(deleted);
			assertTrue(deleted);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void findById() {
		try {
			Artist expected = new Artist(50, "Metallica");
			assertEquals(expected, dao.findById(50));
		} catch (SQLException e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void findAll() {
		try {
			Set<Artist> artists = dao.findAll();
			// assertEquals(100, artists.size()); //
			assertTrue(artists.size() > 0);
		} catch (SQLException e) {
			e.printStackTrace();
			fail();
		}
	}
	

	@Test
	public void create() {
		try {
			Artist object = dao.create(new Artist("The Artist Formerly Known as Generated Key"));
			System.out.println(object);
		}catch(SQLException e) {
			e.printStackTrace();
			fail();
		}
	}
	
}