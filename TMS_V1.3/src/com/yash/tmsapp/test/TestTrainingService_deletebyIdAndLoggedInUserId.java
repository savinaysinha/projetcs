package com.yash.tmsapp.test;

import com.yash.tmsapp.exception.TrainingNotFoundException;
import com.yash.tmsapp.service.TrainingService;
import com.yash.tmsapp.serviceimpl.TrainingServiceImpl;
import com.yash.tmsapp.util.DBUtill;

public class TestTrainingService_deletebyIdAndLoggedInUserId {

	public static void main(String[] args) {
		TrainingService trainingService = new TrainingServiceImpl();
		try {
			trainingService.delete(1);
		} catch (TrainingNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
