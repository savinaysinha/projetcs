package com.yash.tmsapp.test;

import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.exception.UserNotFoundException;
import com.yash.tmsapp.serviceimpl.UserServiceImpl;
import com.yash.tmsapp.util.DBUtill;

public class TestUserServiceImpl_authenticate {

	public static void main(String[] args) {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		try {
			User user = userServiceImpl.authenticate("savinay1", "savinay");
			
			System.out.println(user);
			
			new DBUtill().closeSession();
		} catch (UserNotFoundException e) {
			
			e.printStackTrace();
		}

	}

}
