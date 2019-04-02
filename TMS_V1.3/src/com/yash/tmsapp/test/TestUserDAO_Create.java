package com.yash.tmsapp.test;

import com.yash.tmsapp.dao.UserDAO;
import com.yash.tmsapp.daoimpl.UserDAOImpl;
import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.util.DBUtill;

public class TestUserDAO_Create {

	public static void main(String[] args) {
		UserDAO userDAO =  new UserDAOImpl();
		User user = new User();
		user.setName("Savinay Sinha");
		user.setLoginName("savinaysinha1");
		user.setPassword("savinay123");
		user.setEmail("savinaysinha@gmail.com");
		user.setPhone("9914360114");
		user.setRole(2);
		user.setStatus(1);
		System.out.println(userDAO.insert(user));
		

	}

}
