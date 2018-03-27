package com.phm.community.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.phm.community.entity.Authority;
import com.phm.community.entity.User;
import com.phm.community.service.UserService;

@Controller
public class AuthController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	// 로그인 할 form 보여주기 
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "access-denied";
	}
	
	@GetMapping("/join")
	public String showJoin(Model model) {
		User user = new User();
		model.addAttribute(user);
		return "join";
	}
	
	@GetMapping("/registrationSuccess")
	public String showRegistrationSuccess() {
		return "registrationSuccess";
	}
	
	@PostMapping("/userRegistration")
	public String userRegistration(@ModelAttribute("user") User user) {
		
		// 모델에 담긴 값 중 username, email 토대로 true false 확인
		if(!(userService.checkId(user.getUsername())) && 
				!(userService.checkEmail(user.getEmail()))) {
			// id와 email값에 문제가 없다면
			// 패스워드 암호화 
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setEnabled(1);
			List<Authority> authorities = new ArrayList<>();
			authorities.add(new Authority("ROLE_USER"));
			userService.saveUserAndAuthorities(user, authorities);
			
			return "redirect:registrationSuccess";
		} else {
			return "redirect:registrationFail";
		}
	}
	
	@RequestMapping("/checkId")
	@ResponseBody
	public String checkId(@RequestParam(value="username") String username) {
		if(userService.checkId(username) == true) {
			return "{\"result\":1}";
		} else {
			return "{\"result\":0}";
		}
	}
	
	@RequestMapping("/checkEmail")
	@ResponseBody
	public String checkEmail(@RequestParam(value="email") String email) {
		if(userService.checkEmail(email) == true) {
			return "{\"result\":1}";
		} else {
			return "{\"result\":0}";
		}
	}
	
	@RequestMapping("/jsontest")
	@ResponseBody
	public String jsonTest(@RequestParam(value="testVal") String testVal) {
		String returnVal = "{\"success\":" + testVal + "}";
		return returnVal;
	}
}
