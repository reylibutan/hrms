package com.reylibutan.tabularasa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.reylibutan.tabularasa.entity.User;
import com.reylibutan.tabularasa.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private final String VIEW_FOLDER = "user/";
	
	@Autowired
	private Validator validator;
	
	@Autowired
	private UserService userService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(Model model) {
		User user = new User();
		
		model.addAttribute("user", user);
		return this.VIEW_FOLDER + "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(Model model, @Valid User user, BindingResult result) {	
		if(!result.hasErrors()) {
			userService.save(user);
		}
		
		model.addAttribute("user", user);
		return this.VIEW_FOLDER + "register";
	}
}