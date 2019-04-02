package com.yash.tmsapp.test;

import com.yash.tmsapp.dao.TrainingDAO;
import com.yash.tmsapp.dao.UserDAO;
import com.yash.tmsapp.daoimpl.TrainingDAOImpl;
import com.yash.tmsapp.daoimpl.UserDAOImpl;
import com.yash.tmsapp.domain.Training;
import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.exception.TrainingNotFoundException;
import com.yash.tmsapp.util.DBUtill;

public class TestUserDAO_delete {

	public static void main(String[] args) {
		TrainingDAO trainingDAO = new TrainingDAOImpl();
		try {
			trainingDAO.delete(2);
			new DBUtill().closeSession();
		} catch (TrainingNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
