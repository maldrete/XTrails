package com.mattaldrete.xtrails.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mattaldrete.entities.Location;
import com.mattaldrete.xtrails.repositories.LocationRepository;
import com.mattaldrete.xtrails.services.LocationService;

@RestController
//@RequestMapping(path = "api")
@CrossOrigin({ "*", "http://localhost:4289" })
public class LocationController {
	
	@Autowired
	LocationService locationSvc;
	
	@Autowired
	LocationRepository locationRepo;
	
	@GetMapping("location/{id}")
	public Location getLocation(@PathVariable int id) {
		return locationSvc.getLocation(id);
		
	}
	
	@PostMapping("location")
	public Location createLocation(@RequestBody Location location) {
		return locationSvc.createLocation(location);
	}

}
