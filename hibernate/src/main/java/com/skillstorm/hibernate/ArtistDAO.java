package com.skillstorm.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.skillstorm.beans.Artist;

public class ArtistDAO {
	
	Session session;
	
	public ArtistDAO(Session session) {
		this.session = session;
	}
	
	public List<Artist> findAll(){
		// HQL - Hibernate Query Language (class, variables) not tables/columns
		String hql = "from com.skillstorm.beans.Artist"; // grab all columns ( you can get specific columns OR a single result )
		Query query = session.createQuery(hql);
		return query.list();
		// return session.createQuery("from Artist").list();
	}
	
	public List<Artist> findByName(String like){
		// named parameters
		String hql = "from Artist where name like :search";
		Query query = session.createQuery(hql);
		query.setString("search", "%"+like+"%"); // bind as a String / not sql
		return query.list();
	}
	
	public List<Artist> findByNameCriteria(String like){
		// programmatic query builder (Restrictions -- where, Projections -- aggregate functions)
		Criteria criteria = session.createCriteria(Artist.class);
		criteria.add(Restrictions.like("name", "%"+like+"%")); // Java property to search on // where name like %search%
		return criteria.list(); // criteria.uniqueResult();
	}
	
	public List<Artist> findByNameLike(String like){
		return session.createCriteria(Artist.class)
				.createAlias("albums", "albums") // INNER JOIN - fetches a LAZY collection
				.add(Restrictions.like("name", "%"+like+"%"))
				.add(Restrictions.between("id", 1, 50))
				.list();
	}

	public Artist findById(int id){
		Artist object = (Artist) session.get(Artist.class, id); // 
		return object;
	}

	// after the save, the artist has a generated Id  (HQL + "userinput")
	public Artist save(Artist artist) {
		Transaction tx = session.beginTransaction();
		session.save(artist);
		tx.commit();
		return artist; // (SQLException) (rethrow as RuntimeException)
	}
	
	public void update(Artist artist) {
		Transaction tx = session.beginTransaction();
		session.update(artist);
		tx.commit(); // (SQLException) (rethrow as RuntimeException)
	}
	
	public void delete(Artist artist) {
		Transaction tx = session.beginTransaction();
		session.delete(artist);
		tx.commit(); // (SQLException) (rethrow as RuntimeException)
	}
	
}
