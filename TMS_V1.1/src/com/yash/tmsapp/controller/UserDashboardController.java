package com.yash.tmsapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yash.tmsapp.domain.Training;
import com.yash.tmsapp.exception.TrainingNotFoundException;
import com.yash.tmsapp.service.TrainingService;
import com.yash.tmsapp.service.UserService;
import com.yash.tmsapp.serviceimpl.TrainingServiceImpl;
import com.yash.tmsapp.serviceimpl.UserServiceImpl;

/**
 * Servlet implementation class UserDashboardController
 */
@WebServlet("/UserDashboardController")
public class UserDashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrainingService trainingService = new TrainingServiceImpl();
		HttpSession session=request.getSession();
		request.setAttribute("msg",request.getParameter("msg"));
		int loggedInUserId = (int) session.getAttribute("loggedInUserId");
		try {
			request.setAttribute("listByUserId", trainingService.listByUserId(loggedInUserId));
			request.getRequestDispatcher("user-dashboard.jsp").forward(request, response);
		} catch (TrainingNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
