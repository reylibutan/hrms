package com.ryad.hrms.controller;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ryad.hrms.dto.PatientDTO;

@Controller
public class SampleController {
	
	@RequestMapping("/")
	public String index() {
		return this.login();
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/home")
	public String home(Model model) {
		int max = 125;
		List<PatientDTO> patients = new ArrayList<PatientDTO>(max);
		
		LocalDate localDate = new LocalDate();
		DateTimeFormatter dateDisplayFormat = DateTimeFormat.forPattern("MMM dd, yyyy");
		
		PatientDTO patient;
		for(int i = 0 ; i < max; i++) {
			patient = new PatientDTO();
			patient.setFullName("Juan de la Cruz #" + i);
			patient.setCodeName("JUAN#" + i);
			patient.setUniqueIdCode("AA-BB-" + String.format("%02d", (i % 100)));
			patient.setBirthdate(dateDisplayFormat.print(localDate.plusDays(i)));
			patient.setSex(i % 3 < 2 ? "Male" : "Female");
			
			patients.add(patient);
		}
		
		model.addAttribute("patients", patients);
		
		return "home";
	}
}