package com.mattaldrete.enitities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String city;
	private String park;
	private String state;
	private double longitude;
	private double latitude;
	private String county;
	private String street;
	private int zipcode;
	
	
	

}
