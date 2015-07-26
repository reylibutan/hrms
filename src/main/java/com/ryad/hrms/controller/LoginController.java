package com.ryad.hrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ryad.hrms.entity.User;
import com.ryad.hrms.repository.UserRepository;

@Controller
public class LoginController {
	
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:vct/list";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public User test() {
		User user = userRepo.findByEmail("gregory.house@hrms.com");
		user.getRoles();
		return user;
	}
}