package com.mattaldrete.enitities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String userName;
	private String email;
	private int active;
	private String playist;
	private String comments;
	private  String favoriteActivities;
	private String stats;
	
	@JoinColumn(name = "Location_id")
	private int location;
	
	
}
