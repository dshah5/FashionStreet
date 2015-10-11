package com.sapient.spring.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.model.User;



@Controller
@Scope("session")
@SessionAttributes("logsesh")
public class UpdateController {
	
	
	@RequestMapping(value="/update", method= RequestMethod.POST)
	public String registerUser(@ModelAttribute("userModel") User user,ModelMap model) {
		
	//	model.addAttribute("email",user.getEmail());

	//	model.addAttribute("firstName",user.getFirstName());

//		model.addAttribute("lastName",user.getLastName());
		
	//	model.addAttribute("password",user.getPassword());

		
			
			user.editUser(user.getFirstName(),user.getEmail(), user.getPassword());
	//	ModelAndView mv = new ModelAndView("login","command",new User());
		//	mv.addObject("logsesh", user.getFirstName());
		//	mv.setViewName("login");
		//	System.out.println(user.getFirstName());
		//	return mv;
		return "home";
	
	}

}
