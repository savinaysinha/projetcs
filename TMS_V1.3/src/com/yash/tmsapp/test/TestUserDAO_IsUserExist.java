package com.yash.tmsapp.test;

import com.yash.tmsapp.dao.UserDAO;
import com.yash.tmsapp.daoimpl.UserDAOImpl;
import com.yash.tmsapp.domain.User;

public class TestUserDAO_IsUserExist {

	public static void main(String[] args) {
		UserDAO userDAO = new UserDAOImpl();
		User user = new User();
		user.setEmail("anunaysinha@gmail.com");
		user.setLoginName("anunay");
		System.out.println(userDAO.isUserExist(user));
	}

}
