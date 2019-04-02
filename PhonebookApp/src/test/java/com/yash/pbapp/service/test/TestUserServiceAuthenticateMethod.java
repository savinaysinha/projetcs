package com.yash.pbapp.service.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yash.pbapp.configuration.SpringRootConfig;
import com.yash.pbapp.exception.BlockedUserException;
import com.yash.pbapp.exception.UserNotFoundException;
import com.yash.pbapp.model.User;
import com.yash.pbapp.service.UserService;

public class TestUserServiceAuthenticateMethod {

	public static void main(String[] args) throws BlockedUserException  {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserService userService = ctx.getBean(UserService.class);
		User user = userService.authenticate("savinaysinha","savinay12");
		System.out.println(user.getName());

	}

}
