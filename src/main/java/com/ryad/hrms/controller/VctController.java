package com.ryad.hrms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ryad.hrms.annotation.Layout;
import com.ryad.hrms.dto.PatientDTO;
import com.thedeanda.lorem.Lorem;

@Controller
@RequestMapping("/vct")
@Layout("layouts/default")
public class VctController {
	
	private final String VIEW_FOLDER = "vct/";
	
	@RequestMapping("/list")
	public String list(Model model) {
		int max = 125;
		List<PatientDTO> patients = new ArrayList<PatientDTO>(max);
		
		LocalDate localDate = new LocalDate();
		DateTimeFormatter dateDisplayFormat = DateTimeFormat.forPattern("MMM dd, yyyy");
		
		PatientDTO patient;
		for(int i = 0 ; i < max; i++) {
			patient = new PatientDTO();
			patient.setFullName(i % 3 < 2 ? Lorem.getNameMale() : Lorem.getNameMale());
			patient.setCodeName((i % 3 < 2 ? Lorem.getFirstNameMale() : Lorem.getFirstNameFemale()).toUpperCase());
			patient.setUniqueIdCode("" + getRandomChar() + getRandomChar() + "-" + getRandomChar() + getRandomChar() + "-" + String.format("%02d", (i % 100)));
			patient.setBirthdate(dateDisplayFormat.print(localDate.plusDays(i).minusYears(20)));
			patient.setSex(i % 3 < 2 ? "Male" : "Female");
			
			patients.add(patient);
		}
		
		model.addAttribute("patients", patients);
		
		return this.VIEW_FOLDER + "list";
	}
	
	@RequestMapping("/create")
	public String create() {
		return this.VIEW_FOLDER + "create";
	}
	
	private char getRandomChar() {
		Random r = new Random();
		return (char)(r.nextInt(26) + 'A');
	}
}