package com.ryad.hrms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ryad.hrms.annotation.Layout;

@Controller
@RequestMapping("/enrollment")
@Layout("layouts/default")
public class EnrollmentController {
	
	private final String VIEW_FOLDER = "enrollment/";
	private final String ACTION_CREATE = "create";
	
	@Autowired
	private Validator validator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping("/")
	public String create(Model model) {
//		if (!model.containsAttribute("vctDTO")) {
//	        model.addAttribute("vctDTO", new VctDTO());
//	    }
//		
		model.addAttribute("action", this.ACTION_CREATE);
//		model.addAttribute("sexList", Arrays.asList(SexType.values()));
//		model.addAttribute("hivRiskList", vctService.getHivRisks());
		return VIEW_FOLDER + "create";
	}
}