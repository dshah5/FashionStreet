package com.sapient.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sapient.model.SearchString;

@Controller
public class SearchController {
	String[] list = {"belts", "cart", "contact", "details", "handbags", "home", "jewelry", "login", "profile", "register", "sale", "service", "shoes", "wallets"};
	@RequestMapping(value="/search", method = RequestMethod.POST)
	public String search(@ModelAttribute("empModel") SearchString text, ModelMap model){
		model.addAttribute("search", text.getSearch());
		for (String check : list){
			if(text.getSearch().trim().toLowerCase().equals(check)){
				return text.getSearch();
			}
		}
		return "home";
	}
}
