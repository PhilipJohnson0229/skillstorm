package com.skillstorm.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.skillstorm.beans.Album;

public class HelloHibernate {
	
	// SessionFactory MUST be a singleton
	public static final SessionFactory SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

	public static void main(String[] args) {
		Session session = SESSION_FACTORY.openSession();
		AlbumDAO dao = new AlbumDAO(session);
		List<Album> result = (List<Album>) dao.findByNameLike("Black");
		session.close();
		System.out.println(result);
	}
	
}
