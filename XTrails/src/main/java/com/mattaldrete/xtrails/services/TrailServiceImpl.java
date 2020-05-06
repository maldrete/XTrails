package com.mattaldrete.xtrails.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mattaldrete.entities.Trail;
import com.mattaldrete.xtrails.repositories.TrailRepository;

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
		Trail managedTrail = trailRepo.findByName(updatedTrail.getName());
		if ()
		return null;
	}

	@Override
	public Trail deleteTrail(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Trail> getAllTrails() {
		// TODO Auto-generated method stub
		return null;
	}

}
