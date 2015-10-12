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
@SessionAttributes({"logsesh1", "logsesh2", "dispLName", "dispEmail"} ) 
public class LogoutController {
	
	@RequestMapping(value="/out", method= RequestMethod.GET)
	public ModelAndView verifyUser(@ModelAttribute("userModel") User user,ModelMap model,HttpSession session) throws ServletException, IOException{
			String DisplayLogin = "";
		//	String DisplayRegister = "Register";
			
			String lastDisplay = "";
			String emailDisplay = "";
			ModelAndView mv = new ModelAndView("login","logUser",new User());
			mv.addObject("logsesh", DisplayLogin);
			mv.addObject("logsesh2", "");
			mv.addObject("dispLName", lastDisplay);
			mv.addObject("dispEmail", emailDisplay);
			
		   session.invalidate();  
		
			return mv;
		
	}
}
