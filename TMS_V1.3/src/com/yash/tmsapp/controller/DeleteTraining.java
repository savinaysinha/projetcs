package com.yash.tmsapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.tmsapp.exception.TrainingNotFoundException;
import com.yash.tmsapp.service.TrainingService;
import com.yash.tmsapp.serviceimpl.TrainingServiceImpl;

/**
 * Servlet implementation class DeleteTraining
 */
@WebServlet("/DeleteTraining")
public class DeleteTraining extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int trainingId = Integer.parseInt(request.getParameter("trainingId"));
		TrainingService trainingService = new TrainingServiceImpl();
		try {
			trainingService.delete(trainingId);
		} catch (TrainingNotFoundException e) {
			e.printStackTrace();
		}
		response.sendRedirect("UserDashboardController?msg=Successfully Deleted");
	}

}
