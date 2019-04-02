package com.yash.tmsapp.serviceimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Query;
import org.hibernate.Session;

import com.yash.tmsapp.dao.UserDAO;
import com.yash.tmsapp.daoimpl.UserDAOImpl;
import com.yash.tmsapp.domain.Training;
import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.exception.UserNotFoundException;
import com.yash.tmsapp.service.UserService;
import com.yash.tmsapp.util.DBUtill;

public class UserServiceImpl extends DBUtill implements UserService {
	
	private UserDAO userDAO=null;;

	public UserServiceImpl() {
		userDAO = new UserDAOImpl();
	}
	
	@Override
	public void register(User user) {
		user.setRole(UserService.ROLE_BUSINESS);
		user.setStatus(UserService.STATUS_ACTIVE);
		userDAO.create(user);

	}

	@Override
	public User authenticate(String loginName, String password) throws UserNotFoundException {
		User user = new User();
		Session session=null;
		try {
			session = getSession();
			session.beginTransaction();
			Query query = session.createQuery("from User where loginName = :loginName And password= :password");
			query.setParameter("loginName", loginName);
			query.setParameter("password", password);
			user = (User) query.list().get(0);
			session.getTransaction().commit();
		} catch (Throwable t) {
			session.getTransaction().rollback();
			throw t;
		}
		return user;
	}

}
