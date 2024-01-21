package com.tunehub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tunehub.entities.PlayList;
import com.tunehub.repositories.PlayListRepositiory;

@Service
public class PlayListServiceImplementation implements PlayListService {
	@Autowired
	PlayListRepositiory repo;

	@Override
	public void addPlayList(PlayList playList) {
		repo.save(playList);

	}

	@Override
	public List<PlayList> fetchAllPlayLists() {
		
		return repo.findAll();
	}

}
