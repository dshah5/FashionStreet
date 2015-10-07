package com.sapient.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class NavigController {
	

	@RequestMapping(value="/home", method= RequestMethod.GET)
	
	public String homePage() {
		return "home";
	}

@RequestMapping(value="/login", method= RequestMethod.GET)
	
	public String loginPage() {
		return "login";
	}
	
@RequestMapping(value="/register", method= RequestMethod.GET)

public String registerPage() {
	return "register";
}

}
