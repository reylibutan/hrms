package com.reylibutan.tabularasa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.reylibutan.tabularasa.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {

	private final String VIEW_FOLDER = "user/";
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(Model model) {
		User user = new User();
		
		//=======================================================================
		//=======================================================================
		//@TODO: confirm that User can function both as a DTO and as an Entity 
		//=======================================================================
		//=======================================================================
		
		model.addAttribute("user", user);
		return this.VIEW_FOLDER + "register";
	}
}
