package com.mattaldrete.xtrails.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mattaldrete.entities.Playlist;
import com.mattaldrete.xtrails.repositories.PlaylistRepository;

@Service
public class PlaylistServiceImpl implements PlaylistService {

	@Autowired
	PlaylistRepository playlistRepo;
	
	@Override
	public Playlist createPlaylist(Playlist newPlaylist) {
		
		Playlist persistedPlaylist = playlistRepo.saveAndFlush(newPlaylist);
		return persistedPlaylist;
	}

	@Override
	public Playlist update(Playlist playlist) {
		// TODO Auto-generated method stub
		return null;
	}

}
