package com.reylibutan.tabularasa.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reylibutan.tabularasa.dto.PersonDTO;
import com.reylibutan.tabularasa.service.MessageByLocaleService;
import com.reylibutan.tabularasa.service.SampleService;

@Controller
@RequestMapping("/sample")
public class SampleController {
	
	private final String VIEW_ROOT = "sample/";
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SampleService sampleService;
	
	@Autowired
	private MessageByLocaleService messageByLocaleService;
	
	/**
	 * Example controller method that accepts a request parameter and passes the value to the view.
	 * 
	 * @param name - name of a person
	 * @param model - model to be passed to the view
	 */
	@RequestMapping("/sayHi")
	public String sayHi(@RequestParam(value="name", required=false, defaultValue="Chuck Norris") String name, Model model) {
		log.info("Saying hi to {}.", name);
		
		model.addAttribute("name", name);
		
		return this.VIEW_ROOT + "sayHi";
	}
	
	/**
	 * Example controller method that returns JSON. Typically used for AJAX requests
	 * 
	 * @return JSON response
	 */
	@ResponseBody
	@RequestMapping("/getPerson")	
	public HashMap<String, String> getPerson() {
		LinkedHashMap<String, String> response = new LinkedHashMap<String, String>();
		
		response.put("name", "Juan de la Cruz");
		response.put("gender", "Male");
		response.put("age", "21");
		response.put("occupation", "Software Developer");
		
		return response;
	}
	
	@ResponseBody
	@RequestMapping("/getPersonList")
	public List<PersonDTO> getPersonList() {
		List<PersonDTO> personList = sampleService.findAll();
		
		return personList;
	}
	
	@ResponseBody
	@RequestMapping("/getMessageFromProperty")
	public String getMessageFromProperty() {
		return messageByLocaleService.getMessage("msg.firstName", null);
	}
}