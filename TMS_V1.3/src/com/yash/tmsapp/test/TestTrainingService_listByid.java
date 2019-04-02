package com.yash.tmsapp.test;

import java.util.List;

import com.yash.tmsapp.domain.Training;
import com.yash.tmsapp.exception.TrainingNotFoundException;
import com.yash.tmsapp.service.TrainingService;
import com.yash.tmsapp.serviceimpl.TrainingServiceImpl;
import com.yash.tmsapp.util.DBUtill;

public class TestTrainingService_listByid {
	public static void main(String[] args) {
		TrainingService trainingService  = new TrainingServiceImpl();
		try {
		List<Training> trainings = trainingService.listByUserId(2);
		System.out.println(trainings);
		} catch (TrainingNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
