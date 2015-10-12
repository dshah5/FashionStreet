package com.sapient.spring.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.model.AddCart;
import com.sapient.model.User;



@Controller
@Scope("session")
@SessionAttributes({"pID","quant","price"}) 
public class ViewcartController {
	
	@RequestMapping(value="/ViewCartController", method= RequestMethod.GET)
	public ModelAndView displayCart()	{
		ModelAndView mv=new ModelAndView();
	  
	     AddCart cart= new AddCart();
	    mv.addObject("pID",cart.getIDAllItems());
	    mv.addObject("quant",cart.getQuantityOfIndividualItem());
	    mv.addObject("price", cart.getTotalPrice());
	    mv.addObject("cart", cart);
		mv.setViewName("viewcart");
		return mv;
		
		
	}
	
	
	

}
