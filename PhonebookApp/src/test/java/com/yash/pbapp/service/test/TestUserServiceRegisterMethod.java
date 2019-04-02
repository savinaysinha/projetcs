package com.yash.pbapp.service.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yash.pbapp.configuration.SpringRootConfig;
import com.yash.pbapp.exception.UserNotFoundException;
import com.yash.pbapp.model.User;
import com.yash.pbapp.service.UserService;
import com.yash.pbapp.serviceimpl.UserServiceImpl;

public class TestUserServiceRegisterMethod {

	public static void main(String[] args) throws UserNotFoundException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserService userService = ctx.getBean(UserService.class);
		User user = new User();
		user.setName("Savinay Sinha");
		user.setEmail("savinay.sinha@yash.com");
		user.setLoginname("savinaysinha");
		user.setPassword("savinay123");
		user.setRole(1);
		user.setStatus(1);
		user.setCreated_At(new Date());
		userService.register(user);

	}

}
