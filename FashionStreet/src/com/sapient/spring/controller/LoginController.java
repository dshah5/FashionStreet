package com.sapient.spring.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sapient.model.User;


@Controller
public class LoginController {
	
	@RequestMapping(value="/loginverify", method= RequestMethod.POST)
	public String verifyUser(@ModelAttribute("userModel") User user, ModelMap model){
		model.addAttribute("email",user.getEmail() );
		model.addAttribute("email",user.getEmail() );
		
		return "login" ;
	}
}
