package com.yash.tmsapp.test;

import com.yash.tmsapp.dao.TrainingDAO;
import com.yash.tmsapp.dao.UserDAO;
import com.yash.tmsapp.daoimpl.TrainingDAOImpl;
import com.yash.tmsapp.daoimpl.UserDAOImpl;
import com.yash.tmsapp.domain.Training;
import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.util.DBUtill;

public class TestTrainingDAO_Create {

	public static void main(String[] args) {
		TrainingDAO trainingDAO = new TrainingDAOImpl();
		Training training = new Training();
		training.setBatchSize(10);
		training.setCourse("Java");
		training.setDuation(2);
		training.setExpectation("Hell No");
		training.setMode(0);
		training.setObjective("aggahfa");
		training.setTitle("Training on Java");
		training.setUserId(2);
		
		trainingDAO.create(training);
		
	
	}

}
