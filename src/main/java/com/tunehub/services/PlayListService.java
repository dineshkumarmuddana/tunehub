package com.tunehub.services;

import java.util.List;

import com.tunehub.entities.PlayList;

public interface PlayListService {

	public void addPlayList(PlayList playList);

	public List<PlayList> fetchAllPlayLists();

}
