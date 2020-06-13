package com.mattaldrete.xtrails.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mattaldrete.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
	

}
