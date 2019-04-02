package com.yash.pbapp.dao.test;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yash.pbapp.configuration.SpringRootConfig;
import com.yash.pbapp.dao.UserDAO;
import com.yash.pbapp.exception.UserNotFoundException;
import com.yash.pbapp.model.User;

public class TestUserDAOFindAllMethod {

	public static void main(String[] args) throws UserNotFoundException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		List<User> users = userDAO.findAll();
		for (User user : users) {
			System.out.println(user.getName());
		}

	}

}
