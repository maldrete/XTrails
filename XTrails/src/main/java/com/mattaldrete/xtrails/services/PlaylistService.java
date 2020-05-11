package com.mattaldrete.xtrails.services;

import com.mattaldrete.entities.Playlist;

public interface PlaylistService {
	
	public Playlist createPlaylist(Playlist newPlaylist);
	
	public Playlist update(Playlist playlist);
	

}
