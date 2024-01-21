package com.tunehub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tunehub.entities.Songs;
import com.tunehub.services.SongsService;

@Controller
public class SongsController {
	@Autowired
	SongsService service;

	@PostMapping("/addSong")
	public String addSong(@ModelAttribute Songs song) {
		boolean isSongExist = service.isSongNameExist(song.getName());
		if (isSongExist == false) {
			service.addSong(song);
			System.out.println("Song id Added");
		} else {
			System.out.println("Song Name is already exists");
		}
		return "admin_Home";
	}

	@GetMapping("/viewSongs")
	public String fetchAllSongs(Model model) {
		List<Songs> songsList = service.fetchAllSongs();
		model.addAttribute("songs", songsList);
		return "displaySongs";
	}

	@GetMapping("/playSongs")
	public String playSongs(Model model) {

		boolean ispremiumUser = true;
		if (ispremiumUser) {
			List<Songs> songsList = service.fetchAllSongs();
			model.addAttribute("songs", songsList);
			return "displaySongs";
		}else {
			return "makePayment";
		}
	}

}
