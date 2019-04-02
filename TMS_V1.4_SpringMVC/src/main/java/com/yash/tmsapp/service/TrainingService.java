package com.yash.tmsapp.service;

import java.util.List;

import com.yash.tmsapp.domain.Training;

/**
 * This will perform all service related logic for training
 * 
 * @author savinay.sinha
 *
 */
public interface TrainingService {

	/**
	 * this will register a new training
	 * 
	 * @param training
	 *            to be registered
	 */
	void register(Training training);

	/**
	 * this will list out a training
	 * 
	 * @param TrainingId
	 *            to be to given to fetch the training
	 * @return training if found other wise throw TrainingNotFoundException
	 * @throws TrainingNotFoundException
	 */
	Training listByid(int TrainingId);

	/**
	 * This will return a list of training specific to a User
	 * 
	 * @param loggedInUserId
	 *            to be given to fetch the training
	 * @return list of training if found otherwise throw TrainingNotFoundException
	 * @throws TrainingNotFoundException
	 */
	List<Training> listByUserId(int loggedInUserId);

	/**
	 * this will delete a training
	 * 
	 * @param TrainingId
	 *            to be deleted
	 * @throws TrainingNotFoundException
	 */
	void delete(int trainingId);

	/**
	 * This will search for the text in database
	 * 
	 * @param loggedInUserId
	 *            of current user
	 * @param text
	 *            to be searched
	 * @return list of training if found otherwise TrainingNotFoundException
	 */
	List<Training> searchText(int loggedInUserId, String text);

	/**
	 * this will delete a training
	 * 
	 * @param TrainingId
	 *            to be deleted
	 * @param loggedInUserId
	 * @throws TrainingNotFoundException
	 */
	void delete(int TrainingId, int loggedInUserId);

	/**
	 * this will update the training
	 * 
	 * @param training
	 *            of training to be updated
	 */
	void update(Training training);

}
