package com.yash.tmsapp.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yash.tmsapp.dao.UserDAO;
import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.util.DBUtill;

public class UserDAOImpl extends DBUtill implements UserDAO {

	private Session session = null;

	public UserDAOImpl() {
		session = getSession();
	}

	@Override
	public void create(User user) {
		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (Throwable t) {
			session.getTransaction().rollback();
			throw t;
		}

	}

	@Override
	public List<User> listUser() {
		List<User> list = new ArrayList<>();
		try {
			session.beginTransaction();
			Query query = session.createQuery("from User");
			list = query.list();
			session.getTransaction().commit();
		} catch (Throwable t) {
			session.getTransaction().rollback();
			throw t;
		}
		return list;
	}

	@Override
	public void update(User user) {
		try {
			session.beginTransaction();
			User updatebleUser =(User) session.get(User.class, user.getId());
			updatebleUser.setEmail(user.getEmail());
			updatebleUser.setLoginName(user.getLoginName());
			updatebleUser.setName(user.getName());
			updatebleUser.setPhone(user.getPhone());
			updatebleUser.setRole(user.getRole());
			updatebleUser.setStatus(user.getStatus());
			updatebleUser.setPassword(user.getPassword());
			session.update(updatebleUser);
			session.getTransaction().commit();
		} catch (Throwable t) {
			session.getTransaction().rollback();
			throw t;
		}

	}

	@Override
	public void delete(User user) {
		try {
			session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();
		} catch (Throwable t) {
			session.getTransaction().rollback();
			throw t;
		}

		
	}

}
