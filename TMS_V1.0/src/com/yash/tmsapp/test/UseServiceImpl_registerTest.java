package com.yash.tmsapp.test;

import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.service.UserService;
import com.yash.tmsapp.serviceimpl.UserServiceImpl;

public class UseServiceImpl_registerTest {

	public static void main(String[] args) {
		UserService userService  = new UserServiceImpl();
		User user = new User();
		user.setName("Parinay Sinha");
		user.setLoginName("parinaysinhafsgfsg");
		user.setPassword("parinay123");
		user.setEmail("parinaysinha@yash.com");
		user.setPhone("9914367774");
		userService.register(user);

	}

}
