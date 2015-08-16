package com.ryad.hrms.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ryad.hrms.annotation.Layout;
import com.ryad.hrms.dto.DTCriteria;
import com.ryad.hrms.dto.DTDataSet;
import com.ryad.hrms.dto.DTResponse;
import com.ryad.hrms.dto.VctDTO;
import com.ryad.hrms.enums.SexType;
import com.ryad.hrms.repository.VctRepository;
import com.ryad.hrms.service.VctService;

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
	private VctRepository vctRepo;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping("/list")
	public String list() {
		return VIEW_FOLDER + "list";
	}
	
	@RequestMapping(value = "/search")
	@ResponseBody
	public DTResponse<VctDTO> search(HttpServletRequest request) {
		String[] customFilterNames = {"vctName", "uniqueIdCode"};
		DTCriteria criteria = DTCriteria.getFromRequest(request);
		DTCriteria.extractCustomFilters(criteria, request, customFilterNames);
		
		DTDataSet<VctDTO> dataSet = vctService.findVctWithDatatablesCriteria(criteria);
		
		return DTResponse.build(dataSet, criteria);
	}
	
	@RequestMapping("/")
	public String create(Model model) {
		if (!model.containsAttribute("vctDTO")) {
	        model.addAttribute("vctDTO", new VctDTO());
	    }
		
		model.addAttribute("action", this.ACTION_CREATE);
		model.addAttribute("sexList", Arrays.asList(SexType.values()));
		model.addAttribute("hivRiskList", vctService.getHivRisks());
		return VIEW_FOLDER + "create";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid VctDTO vctDTO, BindingResult result, Model model, RedirectAttributes redirect) {
		
		if(result.hasErrors()) {
			redirect.addFlashAttribute("org.springframework.validation.BindingResult.vctDTO", result);
			redirect.addFlashAttribute("vctDTO", vctDTO);
		    return "redirect:/" + VIEW_FOLDER;
		} else {
			vctDTO = vctService.save(vctDTO);
			return "redirect:/" + VIEW_FOLDER + vctDTO.getId();
		}
	}
	@RequestMapping("/{id}")
	public String viewOrEdit(@PathVariable Long id, @RequestParam(required = false) String mode, Model model) {
		VctDTO vctDTO = vctService.findById(id);
		
		if(vctDTO == null) {
			// ================================================================
			// @TODO: display a message or something using flash attributes
			// ================================================================
			return "redirect:/" + VIEW_FOLDER;
		} else {
			String action = ACTION_VIEW; // default
			if(ACTION_EDIT.equals(mode)) {
				action = ACTION_EDIT;
			}
			
			model.addAttribute("vctDTO", vctDTO);
			model.addAttribute("action", action);
			model.addAttribute("sexList", Arrays.asList(SexType.values()));
			model.addAttribute("hivRiskList", vctService.getHivRisks());
			return VIEW_FOLDER + "create";
		}
	}
}