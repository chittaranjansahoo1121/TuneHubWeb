package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Playlist;
import com.example.demo.repositories.PlaylistRepository;

@Service
public class PlaylistServiceImplementation implements PlaylistService {
	@Autowired
	PlaylistRepository playrepo;

	@Override
	public String addPlaylist(Playlist playlist) {
		   
		playrepo.save(playlist);
		return "Data is saved";
	}

	@Override
	public List<Playlist> fetchPlaylist() {
		List<Playlist>viewSong=playrepo.findAll();
		return viewSong;
	}

}
