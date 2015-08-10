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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ryad.hrms.annotation.Layout;
import com.ryad.hrms.dto.PatientDTO;
import com.ryad.hrms.dto.VctDTO;
import com.ryad.hrms.entity.Vct;
import com.ryad.hrms.enums.SexType;
import com.ryad.hrms.repository.PatientRepository;
import com.ryad.hrms.repository.VctRepository;
import com.ryad.hrms.service.VctService;
import com.thedeanda.lorem.Lorem;

@Controller
@RequestMapping("/vct")
@Layout("layouts/default")
public class VctController {
	
	private final String VIEW_FOLDER = "vct/";
	private final String ACTION_CREATE = "create";
	private final String ACTION_VIEW = "view";
	private final String ACTION_EDIT = "edit";
	
	@Autowired
	private Validator validator;
	
	@Autowired
	private VctService vctService;
	
	@Autowired
	private PatientRepository patientRepo;
	
	@Autowired
	private VctRepository vctRepo;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
		
	@RequestMapping("/list")
	public String list(Model model) {
		int max = 3;
		List<VctDTO> vctDTOs = new ArrayList<VctDTO>(max);
		
		LocalDate localDate = new LocalDate();
		//DateTimeFormatter dateDisplayFormat = DateTimeFormat.forPattern("MMM dd, yyyy");
		
		VctDTO vctDTO;
		for(int i = 0 ; i < max; i++) {
			vctDTO = new VctDTO();
			vctDTO.setFullName(i % 3 < 2 ? Lorem.getNameMale() : Lorem.getNameMale());
			vctDTO.setCodeName((i % 3 < 2 ? Lorem.getFirstNameMale() : Lorem.getFirstNameFemale()).toUpperCase());
			/*vctRec.setUniqueIdCode("" + getRandomChar() + getRandomChar() + "-" + getRandomChar() + getRandomChar() + "-" + String.format("%02d", (i % 100)));
			vctRec.setBirthdate(localDate.plusDays(i).minusYears(20).toDate());
			vctRec.setSex(i % 3 < 2 ? "Male" : "Female");*/
			
			PatientDTO patientDTO = new PatientDTO();
			patientDTO.setUniqueIdCode("" + getRandomChar() + getRandomChar() + "-" + getRandomChar() + getRandomChar() + "-" + String.format("%02d", (i % 100)));
			patientDTO.setBirthdate(localDate.plusDays(i).minusYears(20).toDate());
			patientDTO.setSex(i % 3 < 2 ? "Male" : "Female");
			vctDTO.setPatientDTO(patientDTO);
			
			vctDTOs.add(vctDTO);
		}
		
		model.addAttribute("vctDTOs", vctDTOs);
		
		return this.VIEW_FOLDER + "list";
	}
	
	@RequestMapping("/")
	public String create(Model model) {
		if (!model.containsAttribute("vctDTO")) {
	        model.addAttribute("vctDTO", new VctDTO());
	    }
		
		model.addAttribute("action", this.ACTION_CREATE);
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
			vctDTO = vctService.save(vctDTO);
			return "redirect:/vct/" + vctDTO.getId();
		}
	}
	
	@RequestMapping("/{id}")
	public String view(@PathVariable Long id, Model model) {
		VctDTO vctDTO = vctService.findById(id);
		
		model.addAttribute("vctDTO", vctDTO);
		model.addAttribute("action", this.ACTION_VIEW);
		model.addAttribute("sexList", Arrays.asList(SexType.values()));
		model.addAttribute("hivRiskList", vctService.getHivRisks());
		return this.VIEW_FOLDER + "create";
	}
	
	@RequestMapping(value = "/test")
	@ResponseBody
	public String test() {
		Vct vct = vctRepo.findOne(1L);
		
		return vct.toString();
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		VctDTO vctDTO = vctService.findById(id);
		
		// ====================================================================
		// ====================================================================
		// @TODO: implement this
		// ====================================================================
		// ====================================================================
		
		model.addAttribute("vctDTO", vctDTO);
		model.addAttribute("action", this.ACTION_EDIT);
		model.addAttribute("sexList", Arrays.asList(SexType.values()));
		model.addAttribute("hivRiskList", vctService.getHivRisks());
		return this.VIEW_FOLDER + "create";
	}
	
	private char getRandomChar() {
		Random r = new Random();
		return (char)(r.nextInt(26) + 'A');
	}
}