package com.yash.tmsapp.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.regexp.internal.recompile;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import com.yash.tmsapp.domain.Training;
import com.yash.tmsapp.service.TrainingService;
import com.yash.tmsapp.serviceimpl.TrainingServiceImpl;

/**
 * Servlet implementation class TestSeviceSearchTextTest
 */
@WebServlet("/TestSeviceSearchTextTest")
public class TestSeviceSearchTextTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrainingService trainingService = new TrainingServiceImpl();
		List<Training> trainings = new ArrayList<>();
		Training training = new Training();
		int loggedInUserId = (int) request.getSession().getAttribute("loggedInUserId");
		trainings = trainingService.searchText(loggedInUserId, "savinay");
		System.out.println(trainings);
	}

}
