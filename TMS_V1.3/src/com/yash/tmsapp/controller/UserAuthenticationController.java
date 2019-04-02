package com.yash.tmsapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.exception.UserNotFoundException;
import com.yash.tmsapp.service.UserService;
import com.yash.tmsapp.serviceimpl.UserServiceImpl;

/**
 * Servlet implementation class UserAuthenticationController
 */
@WebServlet("/UserAuthenticationController")
public class UserAuthenticationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserService userService = new UserServiceImpl();
		try {
			User loggedInUser = userService.authenticate(request.getParameter("loginName"), request.getParameter("password"));
			System.out.println(loggedInUser);
			if(loggedInUser.getId()!=0) {
				HttpSession session = request.getSession();
				session.setAttribute("loggedInUser", loggedInUser);
				session.setAttribute("loggedInUserId", loggedInUser.getId());
				session.setAttribute("loggedInUseRole", loggedInUser.getRole());
				response.sendRedirect("UserDashboardController");	
			}else {
				response.sendRedirect("UserAuthentication.jsp?msg=Incorrect Username or Password");
				
			}
		
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
