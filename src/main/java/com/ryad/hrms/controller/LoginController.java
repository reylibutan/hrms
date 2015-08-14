package com.ryad.hrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ryad.hrms.repository.UserRepository;

@Controller
public class LoginController {
	
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/vct/list";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}