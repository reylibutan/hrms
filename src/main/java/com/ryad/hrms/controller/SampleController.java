package com.ryad.hrms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {
	
	@RequestMapping("/login")
	public String index() {
		return "index";
	}
}