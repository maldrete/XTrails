package com.mattaldrete.xtrails.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mattaldrete.entities.Trail;

public interface TrailRepository extends JpaRepository<Trail, Integer> {
	
	public Trail findByName(String name);
	
	

}
