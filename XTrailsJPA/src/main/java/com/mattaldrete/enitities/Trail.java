package com.mattaldrete.enitities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "trail")
public class Trail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private String location;
	private Boolean dogFriendly;
	private String hashtags;
	private String description;
	private String photos;
	private String rating;
	private String review;
	private String routeType;
	private String distance;
	private Integer	elevationGain;
	private String articleLinks;
	private String directions;
	private String share;
	private String difficulty;
	private String weather;
	
	@JoinColumn(name = "Comment_id")
	private Integer comment;
	
	@JoinColumn(name = "Location_id")
	private Integer locationId;
	
	
	

}
