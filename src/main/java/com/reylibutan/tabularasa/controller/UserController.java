package com.reylibutan.tabularasa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	private final String VIEW_FOLDER = "user/";
	
	@RequestMapping("/register")
	public String register() {
		return this.VIEW_FOLDER + "register";
	}
}
