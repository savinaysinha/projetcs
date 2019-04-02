package com.yash.tmsapp.test;

import java.util.List;

import com.yash.tmsapp.domain.Training;
import com.yash.tmsapp.exception.TrainingNotFoundException;
import com.yash.tmsapp.service.TrainingService;
import com.yash.tmsapp.serviceimpl.TrainingServiceImpl;

public class TrainingService_listByUserIDTest {

	public static void main(String[] args) {
		TrainingService trainingService = new TrainingServiceImpl();
		try {
		List<Training> trainings = trainingService.listByUserId(12);
		System.out.println(trainings.get(0).getTitle());
		} catch (TrainingNotFoundException e) {
			e.printStackTrace();
		}

	}

}
