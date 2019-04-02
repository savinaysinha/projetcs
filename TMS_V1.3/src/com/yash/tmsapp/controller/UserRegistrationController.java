package com.yash.tmsapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PingTarget;
import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.service.UserService;
import com.yash.tmsapp.serviceimpl.UserServiceImpl;

import javafx.scene.layout.Region;

/**
 * Servlet implementation class UserRegistrationController
 */
@WebServlet("/UserRegistrationController")
public class UserRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistrationController() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserService userService = new UserServiceImpl();
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setLoginName(request.getParameter("loginName"));
		user.setPassword(request.getParameter("password"));
		user.setPhone(request.getParameter("phone"));
		userService.register(user);
		response.sendRedirect("UserAuthentication.jsp?msg=Successfully Registerd");
	}

}
