package com.ryad.hrms.controller;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ryad.hrms.annotation.Layout;
import com.ryad.hrms.dto.PatientDTO;

@Controller
@RequestMapping("/patient")
@Layout("layouts/default")
public class PatientController {
	
	private final String VIEW_FOLDER = "patient/";
	
	@RequestMapping("/list")
	public String list(Model model) {
		int max = 3;
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
		
		return this.VIEW_FOLDER + "list";
	}
}