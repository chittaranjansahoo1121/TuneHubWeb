package com.example.demo.services;

import java.util.List;

import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Song;
import com.example.demo.repositories.SongRepository;

@Service
public class SongServiceImplementation implements SongService {
	@Autowired
	SongRepository srepo;

	@Override
	public String addSongs(Song song) {
		  srepo.save(song);
		return "Songs is saved";
	}
	
	@Override
	public boolean songExists(String name) {
		if(srepo.findByName(name)==null) {
		return false;
		}
		else {
			return true;
		}
	}

	@Override
	public List<Song> getAllInfo() {
		List<Song>songlist=srepo.findAll();
		return songlist;
	}

	@Override
	public String updateSong(Song s) {
		srepo.save(s);
		return "Songs is update";
	}



}
