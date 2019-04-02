package com.yash.tmsapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.tmsapp.dao.TrainingDAO;
import com.yash.tmsapp.domain.Training;
import com.yash.tmsapp.service.TrainingService;

@Service
public class TrainingServiceImpl implements TrainingService {

	@Autowired
	private TrainingDAO trainingDAO;
	public void register(Training training) {
		trainingDAO.create(training);

	}

	public Training listByid(int TrainingId) {
		
		return trainingDAO.listByid(TrainingId);
	}

	public List<Training> listByUserId(int loggedInUserId) {
		return trainingDAO.listByUserId(loggedInUserId);
	}

	public void delete(int trainingId) {
		trainingDAO.delete(trainingId);

	}

	public List<Training> searchText(int loggedInUserId, String text) {
		
		return trainingDAO.searchText(loggedInUserId, text);
	}

	public void delete(int TrainingId, int loggedInUserId) {
		// TODO Auto-generated method stub

	}

	public void update(Training training) {
		trainingDAO.update(training);

	}

}
