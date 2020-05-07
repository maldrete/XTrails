package com.mattaldrete.xtrails.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mattaldrete.entities.Trail;
import com.mattaldrete.xtrails.repositories.TrailRepository;

@Service
public class TrailServiceImpl implements TrailService {
	
	@Autowired
	TrailRepository trailRepo;

	@Override
	public Trail createTrail(Trail trail) {
		
//		Add some checks if fields are not input
//		Controller will check in trail name was already taken
		
		trailRepo.saveAndFlush(trail);
		return trail;
	}

	@Override
	public Trail updateTrail(Trail updatedTrail) {
//		can update dog friendly, description, route type, distance, eleavtion gain, difficulty
//		future update location
		Trail managedTrail = trailRepo.findByName(updatedTrail.getName());
		if (updatedTrail.getDogFriendly() != null) {
			managedTrail.setDogFriendly(updatedTrail.getDogFriendly());
		}
		if (updatedTrail.getDescription() != null) {
			managedTrail.setDescription(updatedTrail.getDescription());
		}
		if (updatedTrail.getRouteType() != null) {
			managedTrail.setRouteType(updatedTrail.getRouteType());
		}
		if (updatedTrail.getDistance() != null) {
			managedTrail.setDistance(updatedTrail.getDistance());
		}
		if (updatedTrail.getElevationGain() != null) {
			managedTrail.setElevationGain(updatedTrail.getElevationGain());
		}
		if (updatedTrail.getDifficulty() != null) {
			managedTrail.setDifficulty(updatedTrail.getDifficulty());
		}
		
		return null;
	}

	@Override
	public Boolean deleteTrail(String name) {
		Trail trail = trailRepo.findByName(name);
		trailRepo.delete(trail);
		
		if(trailRepo.existsById(trail.getId())) {
			return false;
		}
		return true;
	}

	@Override
	public List<Trail> getAllTrails() {
		return trailRepo.findAll();
	}

}
