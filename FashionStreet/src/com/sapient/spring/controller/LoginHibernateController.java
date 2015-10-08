package com.sapient.spring.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sapient.model.User;


@Controller
public class LoginHibernateController {
	



	
	@RequestMapping(value = "/loginverify242", method = RequestMethod.POST)
	public ModelAndView employeeInfo(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		User user= new User();
	/*	
		String email= request.getParameter("email").toLowerCase();
		String password= request.getParameter("pword");
		
		User user=new User();
		
		user.setEmail(email);
		
		boolean status = user.validateLogin(email, password);
		
		if(status) {
			HttpSession session = request.getSession(true);
			//session.setMaxInactiveInterval(10);
			session.setAttribute("userBean", user);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		else {
			HttpSession session = request.getSession(true);
			session.setAttribute("errmessage", "<p style='text-align:center;color:red;font:24px;font-family:verdana'>"+"Enter"
					+ " correct username or password"+"</p>");
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
				

		}*/
		return new ModelAndView("login", "command", user);
	}


}