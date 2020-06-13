package com.mattaldrete.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String username;
	private String email;
	private Boolean active;

	@Column(name = "favorite_activities")
	private String favoriteActivities;

	private String stats;
	private String role;
	private Boolean enabled;
	private String password;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Comment> comment;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Playlist> playist;

//	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "location_id")
	private Location location;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getFavoriteActivities() {
		return favoriteActivities;
	}

	public void setFavoriteActivities(String favoriteActivities) {
		this.favoriteActivities = favoriteActivities;
	}

	public String getStats() {
		return stats;
	}

	public void setStats(String stats) {
		this.stats = stats;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public List<Playlist> getPlayist() {
		return playist;
	}

	public void setPlayist(List<Playlist> playist) {
		this.playist = playist;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(Integer id, String username, String email, Boolean active, String favoriteActivities, String stats,
			String role, Boolean enabled, String password, List<Comment> comment, List<Playlist> playist,
			Location location) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.active = active;
		this.favoriteActivities = favoriteActivities;
		this.stats = stats;
		this.role = role;
		this.enabled = enabled;
		this.password = password;
		this.comment = comment;
		this.playist = playist;
		this.location = location;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", active=" + active
				+ ", favoriteActivities=" + favoriteActivities + ", stats=" + stats + ", role=" + role + ", enabled="
				+ enabled + ", password=" + password + ", comment=" + comment + ", playist=" + playist + ", location="
				+ location + "]";
	}

	public User() {

	}

	public User(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.active = user.getActive();
		this.favoriteActivities = user.getFavoriteActivities();
		this.stats = user.getStats();
		this.role = user.getRole();
		this.enabled = user.getEnabled();
		this.password = user.getPassword();
		this.comment = user.getComment();
		this.playist = user.getPlayist();
		this.location = user.getLocation();
	}

}
