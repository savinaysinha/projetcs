package com.yash.tmsapp.test;

import com.yash.tmsapp.service.TrainingService;
import com.yash.tmsapp.serviceimpl.TrainingServiceImpl;
import com.yash.tmsapp.util.DBUtill;

public class TestTrainingService_searchText {

	public static void main(String[] args) {
		TrainingService trainingService = new TrainingServiceImpl();
		System.out.println(trainingService.searchText(3, "gqa"));
		
	}

}
