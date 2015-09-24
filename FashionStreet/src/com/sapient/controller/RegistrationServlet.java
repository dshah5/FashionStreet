package com.sapient.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.model.User;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	List<String> emails = new ArrayList<String>();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// emails.add("dlredmond@gatech.edu");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User user = new User();
		request.setAttribute("userBean", user);

		if (user.validateName(fname, lname)) {

			boolean status = user.isEmailRegistered(email);

			if (status) {
				request.setAttribute("errmessage",
						"<p style='text-align:center;color:red;font:24px;font-family:verdana'>"
								+ "Email" + "already registered" + "</p>");

				request.getRequestDispatcher("register.jsp").forward(request,
						response);

			} else {

				user.updateUser(email, password, fname, lname);
				request.setAttribute("errmessage",
						"<p style='text-align:center;color:red;font:24px;font-family:verdana'>"
								+ "Succussful" + "registration. please login"
								+ "</p>");
				request.getRequestDispatcher("login.jsp").forward(request,
						response);

			}
		} else {
			request.setAttribute("errmessage",
					"<p style='text-align:center;color:red;font:24px;font-family:verdana'>"
							+ "Firstname"
							+ " and Lastname can't contain digits" + "</p>");

			request.getRequestDispatcher("register.jsp").forward(request,
					response);
		}
	}

}
