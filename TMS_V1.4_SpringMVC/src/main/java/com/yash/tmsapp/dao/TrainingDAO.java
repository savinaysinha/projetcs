package com.yash.tmsapp.dao;

import java.util.List;
import com.yash.tmsapp.domain.Training;
import com.yash.tmsapp.domain.User;


/**
 * this will do the all the CRUD related operation with the Training 
 * @author savinay.sinha
 *
 */
public interface TrainingDAO {
	
	/**
	 * this will create a training in the database
	 * @param training to be created
	 */
	void create(Training training);
	
	/**
	 * this will update the training on the basis of id
	 * @param id to be updated
	 */
	void update(int id);
	/**
	 * this will update the training on the the basis of training to be passed
	 * @param training to be updated
	 */
	void update(Training training);
	
	/**
	 * this will list the training 
	 * @return a list of all the available training
	 */
	List<Training> listTraining();
	
	/**
	 * this will delete a training
	 * @param TrainingId
	 *            to be deleted
	 * @throws TrainingNotFoundException
	 */
	void delete(int trainingId) ;
	
	List<Training> listByUserId(int loggedInUserId);
	
	Training listByid(int TrainingId);
	List<Training> searchText(int loggedInUserId, String text);
}
