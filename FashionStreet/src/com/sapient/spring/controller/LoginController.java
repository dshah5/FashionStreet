package com.sapient.spring.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
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
public class LoginController {
	
	
	
	@RequestMapping(value="/log", method= RequestMethod.POST)
	public ModelAndView verifyUser(@ModelAttribute("userModel") User user,ModelMap model) throws ServletException, IOException{
		
		model.addAttribute("email",user.getEmail());

		model.addAttribute("fName",user.getFirstName());

		model.addAttribute("lName",user.getLastName());

		if(user.validateLogin(user.getEmail(), user.getPassword())) {
			ModelAndView mv = new ModelAndView("home","command",new User());
			mv.addObject("logsesh", user.getFirstName());
			mv.setViewName("home");
			System.out.println(user.getFirstName());
			return mv;
		
		}
		else 
		{
			return new ModelAndView("login");
		}
	}
}
