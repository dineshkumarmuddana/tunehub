package com.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.tunehub.entities.PlayList;
import com.tunehub.entities.Songs;
import com.tunehub.services.PlayListService;
import com.tunehub.services.SongsService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PlayListController {
	@Autowired
	SongsService songService;

	@Autowired
	PlayListService playListService;

	@GetMapping("/createPlayList")
	public String createPlayList(Model model) {
		List<Songs> songList = songService.fetchAllSongs();
		model.addAttribute("songs", songList);
		return "createPlayList";
	}

	@PostMapping("/addPlayList")
	public String addPlayList(@ModelAttribute PlayList playList) {
//		updating the playlist in db
		playListService.addPlayList(playList);
//		updating the song table
		List<Songs> songList = playList.getSongs();
		for(Songs s: songList) {
			s.getPlayList().add(playList);
//			update song object in db
			songService.updateSong(s);
		}

		return "admin_home";
	}
	
	@GetMapping("/viewPlayLists")
	public String viewPlayLists(Model model) {
		List<PlayList> allPlayLists = playListService.fetchAllPlayLists();
		model.addAttribute("allPlayLists", allPlayLists);
		return "displayPlayLists";
	}
	

}
