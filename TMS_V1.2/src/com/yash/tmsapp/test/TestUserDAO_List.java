package com.yash.tmsapp.test;

import com.yash.tmsapp.dao.UserDAO;
import com.yash.tmsapp.daoimpl.UserDAOImpl;
import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.util.DBUtill;

public class TestUserDAO_List {

	public static void main(String[] args) {
		UserDAO userDAO =  new UserDAOImpl();
		System.out.println(userDAO.listUser());
		
		new DBUtill().closeSession();
	}

}
