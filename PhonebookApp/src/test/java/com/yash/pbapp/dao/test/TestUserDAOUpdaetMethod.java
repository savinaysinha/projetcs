package com.yash.pbapp.dao.test;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yash.pbapp.configuration.SpringRootConfig;
import com.yash.pbapp.dao.UserDAO;
import com.yash.pbapp.exception.UserNotFoundException;
import com.yash.pbapp.model.User;

public class TestUserDAOUpdaetMethod {

	public static void main(String[] args) throws UserNotFoundException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		User user = new User();
		user.setId(2);
		user.setName("Savinay Sinha");
		user.setEmail("savinay.sinha@yash.com");
		user.setLoginname("Anunay Sinha");
		user.setPassword("savinay123");
		user.setRole(1);
		user.setStatus(1);
		user.setCreated_At(new Date());
		userDAO.update(user);
		System.out.println("User update Succesfully");
		

	}

}
