package com.sapient.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.model.User;


@Controller
public class NavigController {
	

	@RequestMapping(value="/home", method= RequestMethod.GET)
	
	public String homePage() {
		return "home";
	}


	
@RequestMapping(value="/register", method= RequestMethod.GET)

public String registerPage() {
	return "register";
}

@RequestMapping(value="/login", method= RequestMethod.GET)

public ModelAndView registersPage() {
	return new ModelAndView("login" , "command" , new User());
}


	}





