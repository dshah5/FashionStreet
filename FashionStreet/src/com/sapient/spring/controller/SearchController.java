package com.sapient.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sapient.model.SearchString;

@Controller
public class SearchController {

	@RequestMapping(value="/search", method = RequestMethod.POST)
	public String search(@ModelAttribute("empModel") SearchString emp, ModelMap model){
		model.addAttribute("search", emp.getSearch());
		return "belts";
	}
}
