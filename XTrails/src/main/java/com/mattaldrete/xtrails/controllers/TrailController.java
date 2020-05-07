package com.mattaldrete.xtrails.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mattaldrete.entities.Trail;
import com.mattaldrete.entities.User;
import com.mattaldrete.xtrails.repositories.TrailRepository;
import com.mattaldrete.xtrails.repositories.UserRepository;
import com.mattaldrete.xtrails.services.TrailService;

@RestController
@RequestMapping(path = "api")
@CrossOrigin({ "*", "http://localhost:4289" })

public class TrailController {

	@Autowired
	TrailService trailSvc;

	@Autowired
	TrailRepository trailRepo;

	@Autowired
	UserRepository userRepo;

	@PostMapping("trails/new")
	public Trail createTrail(@RequestBody Trail trail, Principal prinicpal) {
		User user = userRepo.findByUsernameAndEnabledTrue(prinicpal.getName());

		try {
			Trail managedtrail = trailRepo.findByName(trail.getName());
			if (managedtrail.getName().equals(trail.getName())) {
				throw new RuntimeException("Trail name already exists");
			}
		} catch (NullPointerException e) {
			// Trail not found
		}

		Trail newTrailAdded = trailSvc.createTrail(trail);
		return newTrailAdded;
	}
	
	@GetMapping("trails/getAll")
	public List<Trail> getallTrails() {
		return trailRepo.findAll();
	}
	
	@GetMapping("trails/{name}")
	public Trail getTrailByName(@PathVariable String name) {
		return trailRepo.findByName(name);
	}
	
	@PutMapping("trails/update")
	public Trail updateTrail(@RequestBody Trail updatedTrail) {
		Trail trailWithUpdates = trailSvc.updateTrail(updatedTrail);
		return trailWithUpdates;
	}

}
