package com.tunehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.entities.Songs;
import com.tunehub.repositories.SongsRepository;

@Service
public class SongsServiceImplementation implements SongsService {
	@Autowired
	SongsRepository repo;

	@Override
	public void addSong(Songs song) {
		repo.save(song);

	}

	@Override
	public List<Songs> fetchAllSongs() {

		return repo.findAll();
	}

	@Override
	public boolean isSongNameExist(String name) {
		if(repo.findByName(name) == null) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public void updateSong(Songs song) {
		repo.save(song);
		
	}

}
