package com.yash.tmsapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yash.tmsapp.exception.TrainingNotFoundException;
import com.yash.tmsapp.service.TrainingService;
import com.yash.tmsapp.serviceimpl.TrainingServiceImpl;

/**
 * Servlet implementation class DeleteCheckbox
 */
@WebServlet("/DeleteSelectedController")
public class DeleteSelectedController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		TrainingService trainingService = new TrainingServiceImpl();
		String[] id = {};
		id = request.getParameterValues("trainingId");
		for (int i = 0; i < id.length; i++) {

			try {
				trainingService.delete(Integer.parseInt(id[i]));

			} catch (TrainingNotFoundException e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect("UserDashboardController");
	}

}
