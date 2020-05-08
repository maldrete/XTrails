package com.mattaldrete.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
@Table(name = "playlist_has_trail")
public class PlaylistHasTrail {

	@Column(name = "playlist_id")
	private Integer playlistId;

	@Column(name = "trail_id")
	private Integer trailId;

	public Integer getPlaylistId() {
		return playlistId;
	}

	public void setPlaylistId(Integer playlistId) {
		this.playlistId = playlistId;
	}

	public Integer getTrailId() {
		return trailId;
	}

	public void setTrailId(Integer trailId) {
		this.trailId = trailId;
	}

	@Override
	public String toString() {
		return "PlaylistHasTrail [playlistId=" + playlistId + ", trailId=" + trailId + "]";
	}

	public PlaylistHasTrail(Integer playlistId, Integer trailId) {
		super();
		this.playlistId = playlistId;
		this.trailId = trailId;
	}

	public PlaylistHasTrail() {

	}

}
