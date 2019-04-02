package com.yash.tmsapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yash.tmsapp.domain.Training;
import com.yash.tmsapp.service.TrainingService;
import com.yash.tmsapp.serviceimpl.TrainingServiceImpl;

/**
 * Servlet implementation class AddTrainingController
 */
@WebServlet("/AddTrainingController")
public class AddTrainingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrainingService trainingService = new TrainingServiceImpl();
		Training training = new Training();
		HttpSession session = request.getSession();
		int loggedInUserId  = (int) session.getAttribute("loggedInUserId");
		training.setUserId(loggedInUserId);
		training.setTitle(request.getParameter("title"));
		training.setBatchSize((Integer.parseInt(request.getParameter("batchSize"))));
		training.setCourse(request.getParameter("course"));
		training.setObjective(request.getParameter("objective"));
		training.setDuation(Integer.parseInt(request.getParameter("duration")));
		training.setExpectation(request.getParameter("expectation"));
		training.setMode(Integer.parseInt(request.getParameter("mode")));
		trainingService.register(training);
		response.sendRedirect("UserDashboardController?msg=Successfully Registerd");
	}

}
