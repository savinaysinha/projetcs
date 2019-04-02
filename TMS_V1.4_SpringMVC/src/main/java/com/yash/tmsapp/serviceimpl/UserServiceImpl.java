package com.yash.tmsapp.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.tmsapp.dao.UserDAO;
import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	public void register(User user) {
		
		userDAO.create(user);

	}

	public User authenticate(String loginName, String password) {
		return userDAO.getUser(loginName, password);
	}

}
