package com.mattaldrete.xtrails.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.mattaldrete.entities.Location;
import com.mattaldrete.xtrails.repositories.LocationRepository;

public class LocationServiceImpl implements LocationService {

	@Autowired
	LocationRepository LocationRepo;
	
	@Override
	public Location createLocation(Location location) {
		LocationRepo.saveAndFlush(location);
		return location;
	}

	@Override
	public Location updateLocation(Location updatedLocation) {
		Location managedLocation = LocationRepo.findById(updatedLocation.getId()).get();
		if (updatedLocation.getCity() != null) {
			managedLocation.setCity(updatedLocation.getCity());
		}
		
		LocationRepo.saveAndFlush(updatedLocation);
		return updatedLocation;
	}

}
