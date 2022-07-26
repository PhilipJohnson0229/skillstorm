package com.skillstorm.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Track {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TrackId")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "AlbumId")
	private Album album;
	
	@ManyToMany(mappedBy = "tracks") // other side is owner
	private Set<Playlist> playlists;
	
}
