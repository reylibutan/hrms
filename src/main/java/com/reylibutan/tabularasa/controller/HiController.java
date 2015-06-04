package com.reylibutan.tabularasa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HiController {
	
	@RequestMapping("/hi")
	public String hi(@RequestParam(value="name", required=false, defaultValue="Chuck Norris") String name, Model model) {
		model.addAttribute("name", name);
		return "hi";
	}
}
