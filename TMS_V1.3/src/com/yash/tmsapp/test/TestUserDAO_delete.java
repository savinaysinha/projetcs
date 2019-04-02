package com.yash.tmsapp.test;


import com.yash.tmsapp.dao.UserDAO;

import com.yash.tmsapp.daoimpl.UserDAOImpl;

import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.exception.TrainingNotFoundException;


public class TestUserDAO_delete {

	public static void main(String[] args) throws TrainingNotFoundException {
		UserDAO userDAO = new UserDAOImpl();
		User user = new User();
				user.setId(2);
		userDAO.delete(user);
		
		
	}

}
