package com.yash.tmsapp.test;

import com.yash.tmsapp.dao.TrainingDAO;

import com.yash.tmsapp.daoimpl.TrainingDAOImpl;

import com.yash.tmsapp.domain.Training;

public class Test {
	public static void main(String[] args) {
		TrainingDAO trainingDAO = new TrainingDAOImpl();
		Training training = new Training();
		training.setId(1);
		training.setUserId(1);
		training.setBatchSize(5);
		training.setCourse("bkalgbf");
		training.setDuration(5);
		training.setMode(2);
		training.setObjective("avfuagf");
		training.setTitle("Hii");
		trainingDAO.create(training);
		
		
		Training training2 = new Training();
		training2.setId(1);
		training2.setUserId(1);
		training2.setBatchSize(5);
		training2.setCourse("Hello World");
		training2.setDuration(5);
		training2.setMode(2);
		training2.setObjective("avfuagf");
		training2.setTitle("Hello");
		trainingDAO.update(training2);
		
		System.out.println(trainingDAO.searchText(1, "Hel"));
		
		
		
	}
}
