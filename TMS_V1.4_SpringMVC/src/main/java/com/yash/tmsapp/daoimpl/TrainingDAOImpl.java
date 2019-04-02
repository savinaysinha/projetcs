package com.yash.tmsapp.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.yash.tmsapp.dao.TrainingDAO;
import com.yash.tmsapp.domain.Training;

@Repository
public class TrainingDAOImpl implements TrainingDAO {

	private List<Training> trainingRepository = new ArrayList<Training>();

	public void create(Training training) {
		trainingRepository.add(training);
		System.out.println(trainingRepository);

	}

	public void update(int id) {
		// TODO Auto-generated method stub

	}

	public void update(Training training1) {
		int index=0;
		for (Training training : trainingRepository) {
			if(training.getId()==training1.getId()) {
				trainingRepository.remove(index);
				trainingRepository.add(index, training1);
				break;
			}
			index++;
		}
		
		System.out.println(trainingRepository);
		
	}

	public List<Training> listTraining() {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(int trainingId) {
		for (Training training : trainingRepository) {
			if(training.getId()==trainingId) {
				trainingRepository.remove(training);
				break;
			}
		}

	}

	public List<Training> listByUserId(int loggedInUserId) {
		List<Training> trainings=new ArrayList<Training>();
		for (Training training : trainingRepository) {
			if(training.getUserId()==loggedInUserId) {
				trainings.add(training);
			}
		}
		return trainings;
	}

	public Training listByid(int TrainingId) {
		Training training1 = null;
		for (Training training : trainingRepository) {
			if(training.getId()==TrainingId) {
				training1=training;
			}
		}
		return training1;
	}

	public List<Training> searchText(int loggedInUserId, String text) {
		List<Training> trainings = new ArrayList<Training>();
				
		for (Training training : trainingRepository) {
			if(training.getUserId()==loggedInUserId) {
				if(training.getTitle().contains(text)||training.getObjective().contains(text)||training.getCourse().contains(text)) {
					trainings.add(training);
				}
			}
		}
		return trainings;
	}

}
