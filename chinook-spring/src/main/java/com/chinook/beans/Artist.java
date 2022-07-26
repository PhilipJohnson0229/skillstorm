package com.chinook.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

// Data JPA - uses Hibernate


// JSR-303 (bean validation: validation belongs inside the model itself - encapsulation)

@Entity
@Table(name = "Artist")
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ArtistId")
	private int id;
	
	@Column(name="Name")
	//@javax.validation.constraints
	//@NotEmpty // null   not ''
	@NotBlank   //'   '
	private String name;
	
	@OneToMany(mappedBy = "artist")
	@JsonIgnore // mappedBy side to prevent recursion
	private Set<Album> discography;

	public Artist() {
		super();
	}

	public Artist(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Album> getDiscography() {
		return discography;
	}

	public void setDiscography(Set<Album> discography) {
		this.discography = discography;
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + "]"; // do not include mappedBy variables
	}

}
