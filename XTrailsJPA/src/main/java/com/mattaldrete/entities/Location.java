package com.mattaldrete.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String city;
	private String park;
	private String state;
	private Double longitude;
	private Double latitude;
	private String county;
	private String street;
	private Integer zipcode;

	@OneToOne(mappedBy = "location")
	private Trail trail;
	
	@OneToOne(mappedBy = "location")
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPark() {
		return park;
	}

	public void setPark(String park) {
		this.park = park;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getZipcode() {
		return zipcode;
	}

	public void setZipcode(Integer zipcode) {
		this.zipcode = zipcode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", city=" + city + ", park=" + park + ", state=" + state + ", longitude="
				+ longitude + ", latitude=" + latitude + ", county=" + county + ", street=" + street + ", zipcode="
				+ zipcode + ", user=" + user + "]";
	}

	public Location(Integer id, String city, String park, String state, Double longitude, Double latitude,
			String county, String street, Integer zipcode, User user) {
		super();
		this.id = id;
		this.city = city;
		this.park = park;
		this.state = state;
		this.longitude = longitude;
		this.latitude = latitude;
		this.county = county;
		this.street = street;
		this.zipcode = zipcode;
		this.user = user;
	}

	public Location() {

	}

}
