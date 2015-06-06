package com.reylibutan.tabularasa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {
	
	private final String VIEW_FOLDER = "profile";
	
	@RequestMapping("/")
	public String index() {
		return VIEW_FOLDER + "/index";
	}
}
