package com.chinook.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Track {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TrackId")
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AlbumId")
	private Album album;

	@Column(name = "Name")
	private String name;

	@Column(name = "Composer")
	private String composer;

	@Column(name = "UnitPrice")
	private double unitPrice;

	public Track() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "Track [id=" + id + ", album=" + album + ", name=" + name + ", composer=" + composer + ", unitPrice="
				+ unitPrice + "]";
	}

}
