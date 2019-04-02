package com.yash.tmsapp.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yash.tmsapp.domain.Training;
import com.yash.tmsapp.service.TrainingService;
import com.yash.tmsapp.serviceimpl.TrainingServiceImpl;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrainingService trainingService = new TrainingServiceImpl();
		Training training = new Training();
		training.setId(13);
		training.setTitle("savinay");
		training.setBatchSize(2);
		training.setCourse("fjk");
		training.setDuation(5);
		training.setMode(5);
		training.setObjective("dabjkagd");
		training.setExpectation("gikbkbkvk");
		trainingService.update(training);
	}

}
