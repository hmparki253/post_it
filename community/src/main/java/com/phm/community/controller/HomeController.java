package com.phm.community.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	private Logger logger = Logger.getLogger(getClass().getName());
	
	@GetMapping("/")
	public String index(Model theModel) {
		return "index";
	}
	
	@GetMapping("/about")
	public String about(Model theModel) {
		return "about";
	}
}
