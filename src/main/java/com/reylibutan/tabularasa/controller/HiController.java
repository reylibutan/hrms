package com.reylibutan.tabularasa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hi")
public class HiController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/hi")
	public String hi(@RequestParam(value="name", required=false, defaultValue="Chuck Norris") String name, Model model) {
		log.info("Saying hi to {}.", name);
		
		model.addAttribute("name", name);
		
		return "hi";
	}
}
