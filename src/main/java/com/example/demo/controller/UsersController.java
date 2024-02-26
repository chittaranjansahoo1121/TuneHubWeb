package com.example.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Song;
import com.example.demo.entities.Users;
import com.example.demo.services.SongService;
import com.example.demo.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {
	@Autowired
	UsersService userv;
	@Autowired
	SongService songsrv;

	@PostMapping("/register")
	public String addUser(@ModelAttribute Users user) {

		boolean existUser = userv.emailExists(user.getEmail());
		if (existUser == false) {
			userv.addUser(user);
			return "registerSuccess";
		} else {
			return "registerFail";
		}
	}

	@PostMapping("/login")
	public String validateUser(@RequestParam String email, @RequestParam String password,HttpSession session ) {
		boolean loginStatus = userv.validateUser(email, password);
		if (loginStatus == true) {
			session.setAttribute("email",email);
			if (userv.getRole(email).equals("admin")) {
				return "adminHome";
			} else {
				return "customerHome";
			}
		} else {

			return "loginFail";
		}
	}
	
	@GetMapping("/explore-songs")
	public String exploreSongs(HttpSession session,Model model) {
		String email=(String) session.getAttribute("email");
		Users user=userv.getUser(email);
		boolean userStatus=user.isPremium();
		if(userStatus) {
			List<Song> songlist=songsrv.getAllInfo();
	    	model.addAttribute("Song", songlist);
			return "viewsongs";
		}
		else {
			return "samplepayment";
		}
	}
	@GetMapping("/logout")
	public String logout() {
			
		return "thnks";
	}

}
