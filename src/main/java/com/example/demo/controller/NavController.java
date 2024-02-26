
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NavController {
   
	@GetMapping("/map-register")
	public String registerMapping() {
		return "register";
	}
	@GetMapping("/map-login")
	public String loginMapping() {
		
		return "login";
	}
	@GetMapping("/map-songs")
	public String mapSongs() {
		return "addSongs";
	}
	@GetMapping("/map-admin")
	public String mapAdmin() {
		return "adminHome";
	}
	@GetMapping("/map-customer")
	public String mapcustomer() {
		return "customerHome";
	}
	@GetMapping("/createOrder")
	public String samplePayment() {
		return "samplepayment";
	}
	
}
