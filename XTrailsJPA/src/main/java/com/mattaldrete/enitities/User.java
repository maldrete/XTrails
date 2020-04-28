package com.mattaldrete.enitities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String userName;
	private String email;
	private Boolean active;
	private String playist;
	private String comments;
	private String favoriteActivities;
	private String stats;

	@JoinColumn(name = "Location_id")
	private Integer location;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getPlayist() {
		return playist;
	}

	public void setPlayist(String playist) {
		this.playist = playist;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	public Integer getLocation() {
		return location;
	}

	public void setLocation(Integer location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", email=" + email + ", active=" + active + ", playist="
				+ playist + ", comments=" + comments + ", favoriteActivities=" + favoriteActivities + ", stats=" + stats
				+ ", location=" + location + "]";
	}

	public User(Integer id, String userName, String email, Boolean active, String playist, String comments,
			String favoriteActivities, String stats, Integer location) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.active = active;
		this.playist = playist;
		this.comments = comments;
		this.favoriteActivities = favoriteActivities;
		this.stats = stats;
		this.location = location;
	}

	public User() {

	}
}
