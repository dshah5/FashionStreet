package com.sapient.spring.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.model.AddCart;



@Controller
public class AddCartController {

	
	@RequestMapping(value="/addtocart/{productID}", method = RequestMethod.GET)
	public String addtoCart(@PathVariable Integer productID,Model model) {
		
		AddCart cart= new AddCart();
		cart.addtoCart(productID);
		return "handbags";
	}

		
		
		
}
