package com.yash.pbapp.dao.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yash.pbapp.configuration.SpringRootConfig;
import com.yash.pbapp.dao.UserDAO;
import com.yash.pbapp.exception.UserNotFoundException;

public class TestUserDAOFindByIdMethod {
	public static void main(String[] args) throws UserNotFoundException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		System.out.println(userDAO.findById(3).getName());
	}

}
