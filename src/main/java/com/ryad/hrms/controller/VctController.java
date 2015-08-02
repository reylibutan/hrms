package com.ryad.hrms.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ryad.hrms.annotation.Layout;
import com.ryad.hrms.dto.VctDTO;
import com.ryad.hrms.enums.SexType;
import com.ryad.hrms.service.VctService;
import com.thedeanda.lorem.Lorem;

@Controller
@RequestMapping("/vct")
@Layout("layouts/default")
public class VctController {
	
	private final String VIEW_FOLDER = "vct/";
	
	@Autowired
	private Validator validator;
	
	@Autowired
	private VctService vctService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/vct/list";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		int max = 3;
		List<VctDTO> vctRecs = new ArrayList<VctDTO>(max);
		
		LocalDate localDate = new LocalDate();
		//DateTimeFormatter dateDisplayFormat = DateTimeFormat.forPattern("MMM dd, yyyy");
		
		VctDTO vctRec;
		for(int i = 0 ; i < max; i++) {
			vctRec = new VctDTO();
			vctRec.setFullName(i % 3 < 2 ? Lorem.getNameMale() : Lorem.getNameMale());
			vctRec.setCodeName((i % 3 < 2 ? Lorem.getFirstNameMale() : Lorem.getFirstNameFemale()).toUpperCase());
			vctRec.setUniqueIdCode("" + getRandomChar() + getRandomChar() + "-" + getRandomChar() + getRandomChar() + "-" + String.format("%02d", (i % 100)));
			vctRec.setBirthdate(localDate.plusDays(i).minusYears(20).toDate());
			vctRec.setSex(i % 3 < 2 ? "Male" : "Female");
			
			vctRecs.add(vctRec);
		}
		
		model.addAttribute("vctRecs", vctRecs);
		
		return this.VIEW_FOLDER + "list";
	}
	
	@RequestMapping("/create")
	public String create(Model model) {
		if (!model.containsAttribute("vctDTO")) {
	        model.addAttribute("vctDTO", new VctDTO());
	    }
		
		model.addAttribute("sexList", Arrays.asList(SexType.values()));
		model.addAttribute("hivRiskList", vctService.getHivRisks());
		return this.VIEW_FOLDER + "create";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid VctDTO vctDTO, BindingResult result, Model model, RedirectAttributes redirect) {
		
		if(result.hasErrors()) {
			redirect.addFlashAttribute("org.springframework.validation.BindingResult.vctDTO", result);
			redirect.addFlashAttribute("vctDTO", vctDTO);
		    return "redirect:/vct/create";
		} else {
			// ======================================================================
			// ======================================================================
			// @TODO: Resume here, save()
			// ======================================================================
			// ======================================================================
		}
		
		model.addAttribute("vctDTO", vctDTO);
		model.addAttribute("sexList", Arrays.asList(SexType.values()));
		model.addAttribute("hivRiskList", vctService.getHivRisks());
		return this.VIEW_FOLDER + "create";
	}
	
	private char getRandomChar() {
		Random r = new Random();
		return (char)(r.nextInt(26) + 'A');
	}
}