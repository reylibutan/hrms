package com.reylibutan.tabularasa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	@RequestMapping("/")
	public String index() {
		return "index()";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "home()";
	}
}
