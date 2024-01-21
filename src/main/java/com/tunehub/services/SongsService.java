package com.tunehub.services;

import java.util.List;

import com.tunehub.entities.Songs;

public interface SongsService {

	public void addSong(Songs song);

	public List<Songs> fetchAllSongs();

	public boolean isSongNameExist(String name);

	public void updateSong(Songs song);

}
