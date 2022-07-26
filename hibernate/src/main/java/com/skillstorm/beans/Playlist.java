package com.skillstorm.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Playlist {

	@Id
	@Column(name = "PlaylistId")
	private int id;
	
	@ManyToMany
	@JoinTable(name = "playlisttrack", joinColumns = @JoinColumn(name="PlaylistId"), inverseJoinColumns = @JoinColumn(name="TrackId"))
	private Set<Track> tracks;
	
}
