package com.phm.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

	// 로그인 할 form 보여주기 
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "access-denied";
	}
}
