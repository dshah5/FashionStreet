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
public class RegistrationController {
	
	
	
	@RequestMapping(value="/reg", method= RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("userModel") User user,ModelMap model) throws ServletException, IOException{
		
		model.addAttribute("email",user.getEmail());

		model.addAttribute("firstName",user.getFirstName());

		model.addAttribute("lastName",user.getLastName());
		
		model.addAttribute("password",user.getPassword());

		if(!user.isEmailRegistered(user.getEmail())&&user.validateName(user.getFirstName(), user.getLastName())) {
			
			user.updateUser(user.getEmail(), user.getPassword(), user.getFirstName(), user.getLastName());
			ModelAndView mv = new ModelAndView("login","command",new User());
			mv.addObject("logsesh", user.getFirstName());
			mv.setViewName("login");
			System.out.println(user.getFirstName());
			return mv;
		
		}
		else 
		{
			return new ModelAndView("register");
		}
	}
}

