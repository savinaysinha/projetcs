package com.yash.tmsapp.test;

import com.yash.tmsapp.dao.UserDAO;
import com.yash.tmsapp.daoimpl.UserDAOImpl;
import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.util.DBUtill;

public class TestUserDAO_update {

	public static void main(String[] args) {
		UserDAO userDAO =  new UserDAOImpl();
		User user = new User();
		user.setId(1);
		user.setName("Anunay Sinha");
		user.setLoginName("anunaysinha");
		user.setPassword("anunay123");
		user.setEmail("anunaysinha@gmail.com");
		user.setPhone("8956231478");
		user.setRole(2);
		user.setStatus(1);
		
		userDAO.update(user);
		
		new DBUtill().closeSession();
	}

}
