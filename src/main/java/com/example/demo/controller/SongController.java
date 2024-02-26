package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Song;
import com.example.demo.services.SongService;

@Controller
public class SongController {
	
    @Autowired
	SongService songsrv;
    
    @PostMapping("/addsongs")
    public String addSong(@ModelAttribute Song song) {
    	 boolean existSong=songsrv.songExists(song.getName()) ; 
    	 if(existSong==false) {
    	songsrv.addSongs(song);
    	return "SuccessSong";
    	 }
    	 else {
    		 return "failSuccess";
    	 }
    }
    
    @GetMapping("/fetch-songs")
    public String getAllInfo(Model model) {
    	List<Song> songlist=songsrv.getAllInfo();
    	model.addAttribute("Song", songlist);
    	
    	return "viewSuccess";
    }
    
//    @GetMapping("/explore-songs")
//    public String getCustomerSongs(Model model) {
//    	boolean primeStatus =true;
//    	if(primeStatus==true) {
//    	List<Song> songlist=songsrv.getAllInfo();
//    	model.addAttribute("Song", songlist);
//    	return "viewsongs";
//    	}
//    	else {
//    		return "makepayment";
//    	}
//    }
//	
//	
	
}
