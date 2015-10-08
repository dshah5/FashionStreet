package com.sapient.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sapient.model.Cart;

@Controller
@RequestMapping(value="/sp")
public class CartController {
	
	@RequestMapping(value="/form")
	public String index(ModelMap model){
		model.put("cart", new Cart());
		return "form";
	}
	
	@RequestMapping(value="/addcart", method=RequestMethod.POST)
	public String addcart(@ModelAttribute("cart") Cart c, HttpSession session){
		List<Cart> list = (List<Cart>) session.getAttribute("cart");
		if (list==null){
			list = new ArrayList<>();
			list.add(c);
		}
		else {
			boolean flag=false;
			for (Cart cart : list){
				if (cart.getID()==c.getID()){
					cart.setQuantity(cart.getQuantity()+1);
					flag=true;
					break;
				}
			} if (flag==false){
				list.add(c);
			}
			
		}
		session.setAttribute("cart", list);
		session.setAttribute("total", getTotal(list));
		return "cart";
	}
	
	public float getTotal(List<Cart> list){
		float total = 0;
		for (Cart cart : list){
			total += (cart.getQuantity()*cart.getPrice());
		}
		return total;
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.GET)
	public String remove(@RequestParam(value="id") int id, HttpSession session){
		List<Cart> list = (List<Cart>) session.getAttribute("cart");
		if(list != null){
			for (Cart cart : list){
				if(cart.getID()==id){
					list.remove(cart);
					break;
				}
			}
		}
		session.setAttribute("cart", list);
		session.setAttribute("total", getTotal(list));
		return "cart";
	}
}
