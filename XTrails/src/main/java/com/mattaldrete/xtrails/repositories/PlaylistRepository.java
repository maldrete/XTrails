package com.mattaldrete.xtrails.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mattaldrete.entities.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
	
	public Playlist findByName(String name);

}
