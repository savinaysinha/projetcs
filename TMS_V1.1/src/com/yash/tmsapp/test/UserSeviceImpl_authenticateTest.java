package com.yash.tmsapp.test;

import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.exception.UserNotFoundException;
import com.yash.tmsapp.service.UserService;
import com.yash.tmsapp.serviceimpl.UserServiceImpl;

public class UserSeviceImpl_authenticateTest {

	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		User user=null;
		
		try {
			user = userService.authenticate("savinaysinha", "savinay13");
		} catch (UserNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(user.getName());
		System.out.println(user.getEmail());
		

	}

}
