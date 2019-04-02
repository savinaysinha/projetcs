package com.yash.tmsapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.tmsapp.domain.Training;
import com.yash.tmsapp.exception.TrainingNotFoundException;
import com.yash.tmsapp.service.TrainingService;
import com.yash.tmsapp.serviceimpl.TrainingServiceImpl;

/**
 * Servlet implementation class SearchTextController
 */
@WebServlet("/SearchTextController")
public class SearchTextController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text = request.getParameter("search");
		TrainingService trainingService = new TrainingServiceImpl();
		List<Training> trainings = new ArrayList<>();
		Training training = new Training();
		int loggedInUserId = (int) request.getSession().getAttribute("loggedInUserId");
		trainings = trainingService.searchText(loggedInUserId, text);
		System.out.println(trainings);
		request.setAttribute("listByUserId", trainings);
		request.getRequestDispatcher("user-dashboard.jsp").forward(request, response);
		
	}

}
