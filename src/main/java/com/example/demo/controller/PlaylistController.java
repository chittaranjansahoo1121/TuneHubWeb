package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;
import com.example.demo.services.PlaylistService;
import com.example.demo.services.SongService;



@Controller
public class PlaylistController {
	
    @Autowired
	SongService sserv;
    @Autowired
    PlaylistService playserv;
    
	@GetMapping("/create-playlist")
	public String createPlaylist(Model model) {
		
		List<Song> songlist=sserv.getAllInfo();
    	model.addAttribute("songlist", songlist);
		
		//sending createplaylist
		return "createplaylist";
	}
	@PostMapping("/addPlaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist) {
		   //adding the playlist
		   playserv.addPlaylist(playlist); 
		   //update song
		  List<Song> songlist=playlist.getSong();
		  
		  for(Song song:songlist) {
			  song.getPlaylist().add(playlist);
			  sserv.updateSong(song);
		  }  
		return "addSuccess";
	}
	@GetMapping("/view-playlist")
	public String viewPlaylist( Model model) {
		List<Playlist> playlist=playserv.fetchPlaylist();
		//System.out.println(playlist);
		model.addAttribute("playlist", playlist);
		
		return "viewplaylist";
	}
}
