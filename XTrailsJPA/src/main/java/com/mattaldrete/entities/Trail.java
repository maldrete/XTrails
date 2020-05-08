package com.mattaldrete.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trail")
public class Trail {

//	comment_id field not used | List of comments mapped by trail

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	@Column(name = "dog_friendly")
	private Boolean dogFriendly;
	private String hashtags;
	private String description;
	private String photos;
	private String rating;
	private String review;

	@Column(name = "route_type")
	private String routeType;
	private String distance;

	@Column(name = "elevation_gain")
	private Integer elevationGain;

	@Column(name = "article_links")
	private String articleLinks;
	private String directions;
	private String share;
	private String difficulty;
	private String weather;
	private String exercise;

	@OneToMany(mappedBy = "trail")
	private List<Comment> comment;

//	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "location_id")
	private Location location;

	@ManyToMany(mappedBy = "trails")
	private List<Playlist> playlists;

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

	public Boolean getDogFriendly() {
		return dogFriendly;
	}

	public void setDogFriendly(Boolean dogFriendly) {
		this.dogFriendly = dogFriendly;
	}

	public String getHashtags() {
		return hashtags;
	}

	public void setHashtags(String hashtags) {
		this.hashtags = hashtags;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getRouteType() {
		return routeType;
	}

	public void setRouteType(String routeType) {
		this.routeType = routeType;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public Integer getElevationGain() {
		return elevationGain;
	}

	public void setElevationGain(Integer elevationGain) {
		this.elevationGain = elevationGain;
	}

	public String getArticleLinks() {
		return articleLinks;
	}

	public void setArticleLinks(String articleLinks) {
		this.articleLinks = articleLinks;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public String getShare() {
		return share;
	}

	public void setShare(String share) {
		this.share = share;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getExercise() {
		return exercise;
	}

	public void setExercise(String exercise) {
		this.exercise = exercise;
	}

	public List<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<Playlist> playlists) {
		this.playlists = playlists;
	}

	@Override
	public String toString() {
		return "Trail [id=" + id + ", name=" + name + ", dogFriendly=" + dogFriendly + ", hashtags=" + hashtags
				+ ", description=" + description + ", photos=" + photos + ", rating=" + rating + ", review=" + review
				+ ", routeType=" + routeType + ", distance=" + distance + ", elevationGain=" + elevationGain
				+ ", articleLinks=" + articleLinks + ", directions=" + directions + ", share=" + share + ", difficulty="
				+ difficulty + ", weather=" + weather + ", exercise=" + exercise + ", comment=" + comment
				+ ", location=" + location + ", playlists=" + playlists + "]";
	}

	public Trail(int id, String name, Boolean dogFriendly, String hashtags, String description, String photos,
			String rating, String review, String routeType, String distance, Integer elevationGain, String articleLinks,
			String directions, String share, String difficulty, String weather, String exercise, List<Comment> comment,
			Location location, List<Playlist> playlists) {
		super();
		this.id = id;
		this.name = name;
		this.dogFriendly = dogFriendly;
		this.hashtags = hashtags;
		this.description = description;
		this.photos = photos;
		this.rating = rating;
		this.review = review;
		this.routeType = routeType;
		this.distance = distance;
		this.elevationGain = elevationGain;
		this.articleLinks = articleLinks;
		this.directions = directions;
		this.share = share;
		this.difficulty = difficulty;
		this.weather = weather;
		this.exercise = exercise;
		this.comment = comment;
		this.location = location;
		this.playlists = playlists;
	}

	public Trail() {

	}

}
