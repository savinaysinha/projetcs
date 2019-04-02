package com.yash.tmsapp.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.yash.tmsapp.dao.UserDAO;
import com.yash.tmsapp.domain.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	private List<User> userRepository=new ArrayList<User>(); 

	public void create(User user) {
		userRepository.add(user);
		System.err.println(userRepository);
		
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	public User freeSeach(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> listUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUser(String userName, String password) {
		User user=null;
		for (User user1 : userRepository) {
			if(user1.getLoginName().equals(userName)&& user1.getPassword().equals(password)) {
				user=user1;
			}
		}
		return user;
	}
	

}
