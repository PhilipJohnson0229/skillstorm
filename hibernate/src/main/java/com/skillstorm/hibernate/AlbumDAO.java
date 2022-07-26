package com.skillstorm.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.skillstorm.beans.Album;

public class AlbumDAO {

	Session session;
	
	public AlbumDAO(Session session) {
		this.session = session;
	}
	
	public List<Album> findByNameLike(String like) {
		return session.createCriteria(Album.class)
				.createAlias("artist", "a")
				.add(Restrictions.like("a.name", "%"+like+"%"))
				.add(Restrictions.between("a.id", 1, 50))
				.list();
	}
	
}
