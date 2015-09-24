package com.sapient.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.model.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email= request.getParameter("email").toLowerCase();
		String password= request.getParameter("pword");
		
		//PrintWriter out = response.getWriter();
		
		User user=new User();
		
		user.setEmail(email);
		
		boolean status = user.validateLogin(email, password);
		
		if(status) {
			request.setAttribute("userBean", user);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		else {
			
			request.setAttribute("errmessage", "<p style='text-align:center;color:red;font:24px;font-family:verdana'>"+"Enter"
					+ "correct username or password"+"</p>");
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
				

		}
	}

}
