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
 * Servlet implementation class UpdateTraining
 */
@WebServlet("/UpdateTraining")
public class UpdateTraining extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int trainingId = Integer.parseInt(request.getParameter("trainingId"));
		Training training = new Training();
		TrainingService trainingService = new TrainingServiceImpl();
		try {
			training = trainingService.listByid(trainingId);
		} catch (TrainingNotFoundException e) {
			
			e.printStackTrace();
		}
		request.setAttribute("training", training);
		request.getRequestDispatcher("UpdateTraining.jsp").forward(request, response);
		
	}

}
