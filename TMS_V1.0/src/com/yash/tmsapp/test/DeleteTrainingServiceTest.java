package com.yash.tmsapp.test;

import com.yash.tmsapp.exception.TrainingNotFoundException;
import com.yash.tmsapp.service.TrainingService;
import com.yash.tmsapp.serviceimpl.TrainingServiceImpl;

public class DeleteTrainingServiceTest {

	public static void main(String[] args) {
		TrainingService trainingService = new TrainingServiceImpl();
		try {
			trainingService.delete(2);
		} catch (TrainingNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
