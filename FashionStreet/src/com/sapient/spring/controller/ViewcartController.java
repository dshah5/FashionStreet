package com.sapient.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class ViewcartController {
	
	@RequestMapping(value="/ViewCartController", method= RequestMethod.GET)
	public String displayCart(ModelMap model)	{
		
	     
		return "viewcart";
		
		
	}
	
	
	

}
