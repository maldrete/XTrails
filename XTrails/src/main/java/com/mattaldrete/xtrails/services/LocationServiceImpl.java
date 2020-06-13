package com.mattaldrete.xtrails.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mattaldrete.entities.Location;
import com.mattaldrete.xtrails.repositories.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	LocationRepository locationRepo;
	
	@Override
	public Location createLocation(Location location) {
		locationRepo.saveAndFlush(location);
		return location;
	}

	@Override
	public Location updateLocation(Location updatedLocation) {
		Location managedLocation = locationRepo.findById(updatedLocation.getId()).get();
		if (updatedLocation.getCity() != null) {
			managedLocation.setCity(updatedLocation.getCity());
		}
		
		locationRepo.saveAndFlush(updatedLocation);
		return updatedLocation;
	}

	@Override
	public Location getLocation(int id) {
		return locationRepo.findById(id).get();
	}

}
