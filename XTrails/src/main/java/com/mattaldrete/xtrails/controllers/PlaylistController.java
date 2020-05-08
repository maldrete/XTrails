package com.mattaldrete.xtrails.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mattaldrete.entities.Playlist;
import com.mattaldrete.xtrails.repositories.PlaylistRepository;
import com.mattaldrete.xtrails.services.PlaylistService;

@RestController
@RequestMapping(path = "api")
@CrossOrigin({ "*", "http://localhost:4289" })

public class PlaylistController {

	@Autowired
	PlaylistRepository playlistRepo;

	@Autowired
	PlaylistService playlistSvc;

	@PostMapping("playlist/new")
	public Playlist createPlaylist(@RequestBody Playlist playlist) {
		try {
			Playlist managedPlaylist = playlistRepo.findByName(playlist.getName());
			if (managedPlaylist.getName().equals(playlist.getName())) {
				throw new RuntimeException("Playlist name already exist");
			}
		} catch (NullPointerException e) {
			// TODO: ha
		}

		Playlist newPlaylist = playlistSvc.createPlaylist(playlist);
		return newPlaylist;
	}

	@GetMapping("playlist/getAll")
	public List<Playlist> getAllPlaylist() {
		return playlistRepo.findAll();
	}

	@GetMapping("playlist/{trailName}")
	public Playlist getPlaylistbyName(@PathVariable String trailName) {
		return playlistRepo.findByName(trailName);
	}
}
