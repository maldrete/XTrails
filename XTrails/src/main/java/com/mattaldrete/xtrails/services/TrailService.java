package com.mattaldrete.xtrails.services;

import java.util.List;

import com.mattaldrete.entities.Trail;

public interface TrailService {
	
	public Trail createTrail(Trail trail);
	
	public Trail updateTrail(Trail updatedTrail);
	
	public Trail deleteTrail(String name);
	
	public List<Trail> getAllTrails();

}
