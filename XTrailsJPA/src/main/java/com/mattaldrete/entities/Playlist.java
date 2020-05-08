package com.mattaldrete.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "playlist")
public class Playlist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	private String description;
	private String hashtags;

	@ManyToMany
	@JoinTable(name = "playlist_has_trail", joinColumns = @JoinColumn(name = "playlist_id"), inverseJoinColumns = @JoinColumn(name = "trail_id"))
	private List<Trail> trails;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

//	Adders and Removers
	public void addTrail(Trail trail) {

		if (trails == null) {
			trails = new ArrayList<>();
		}

		if (!trails.contains(trail)) {
			trails.add(trail);
		}
	}

	public void removeTrail(Trail trail) {

		if (trails != null) {
			trails.remove(trail);
		}

	}

//	Getters and Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHashtags() {
		return hashtags;
	}

	public void setHashtags(String hashtags) {
		this.hashtags = hashtags;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Trail> getTrails() {
		return trails;
	}

	public void setTrails(List<Trail> trails) {
		this.trails = trails;
	}

	@Override
	public String toString() {
		return "Playlist [id=" + id + ", name=" + name + ", description=" + description + ", hashtags=" + hashtags
				+ ", trails=" + trails + ", user=" + user + "]";
	}

	public Playlist(Integer id, String name, String description, String hashtags, List<Trail> trails, User user) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.hashtags = hashtags;
		this.trails = trails;
		this.user = user;
	}

	public Playlist() {

	}

}
