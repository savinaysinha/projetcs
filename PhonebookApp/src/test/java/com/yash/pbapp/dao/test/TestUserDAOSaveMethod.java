package com.yash.pbapp.dao.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yash.pbapp.configuration.SpringRootConfig;
import com.yash.pbapp.dao.UserDAO;
import com.yash.pbapp.exception.UserNotFoundException;
import com.yash.pbapp.model.User;

public class TestUserDAOSaveMethod {

	public static void main(String[] args) throws UserNotFoundException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		User user = new User();
		user.setName("Savinay Sinha");
		user.setEmail("savinay.sinha@yash.com");
		user.setLoginname("savinaysinha");
		user.setPassword("savinay123");
		user.setRole(1);
		user.setStatus(1);
		user.setCreated_At(new Date());
		userDAO.save(user);
		System.out.println("User Inserted Succesfully");

	}

}
