package com.sapient.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/search")
public class SearchController {

	@RequestMapping(value="/test", method = RequestMethod.POST)
	public String search() {
		return "home";
	}
}
