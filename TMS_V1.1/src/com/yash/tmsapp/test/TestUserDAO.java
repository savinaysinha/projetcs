package com.yash.tmsapp.test;

import java.util.Iterator;
import java.util.List;

import com.yash.tmsapp.dao.UserDAO;
import com.yash.tmsapp.daoimpl.UserDAOImpl;
import com.yash.tmsapp.domain.User;

public class TestUserDAO {
	public static void main(String[] args) {
		UserDAO userDAO  = new UserDAOImpl();
//		User user = new User();
//		user.setId(3);
//		user.setName("Anunay Sinha");
//		user.setLoginName("anunaysinha");
//		user.setPassword("anunay123");
//		user.setEmail("anunaysinha@yash.com");
//		user.setPhone("9914360114");
//		user.setRole(1);
//		user.setStatus(1);
//
//	
////		userDAO.create(user);
//		
//		
//		userDAO.update(user);
		
		List<User> list = userDAO.listUser();
		
		System.out.println(list);
		
		
		
	}
	
	
}
