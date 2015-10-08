package com.sapient.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.model.SearchString;
import com.sapient.model.User;

@Controller
public class NavigController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homePage() {
		return "home";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerPage() {
		return new ModelAndView("register", "regUser", new User());
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView registersPage() {
		return new ModelAndView("login", "logUser", new User());
	}

	@RequestMapping(value = "/belts", method = RequestMethod.GET)
	public String beltsPage() {
		return "belts";
	}

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String cartPage() {
		return "cart";
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contactPage() {
		return "contact";
	}

	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public String detailsPage() {
		return "details";
	}
	
	@RequestMapping(value = "/handbags", method = RequestMethod.GET)
	public String handbagsPage() {
		return "handbags";
	}
	
	@RequestMapping(value = "/jewelry", method = RequestMethod.GET)
	public String jewelryPage() {
		return "jewelry";
	}
	
	@RequestMapping(value = "/sale", method = RequestMethod.GET)
	public String salePage() {
		return "sale";
	}
	
	@RequestMapping(value = "/shoes", method = RequestMethod.GET)
	public ModelAndView shoesPage() {
		return new ModelAndView("shoes", "info", new SearchString());
	}
	
	@RequestMapping(value = "/service", method = RequestMethod.GET)
	public String servicePage() {
		return "service";
	}
	
	@RequestMapping(value = "/wallets", method = RequestMethod.GET)
	public String walletsPage() {
		return "wallets";
	}
}
