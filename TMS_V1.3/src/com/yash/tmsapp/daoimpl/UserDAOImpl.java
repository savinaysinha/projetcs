package com.yash.tmsapp.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yash.tmsapp.dao.UserDAO;
import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.util.CipherUtill;
import com.yash.tmsapp.util.DBUtill;

public class UserDAOImpl extends DBUtill implements UserDAO {



	@Override
	public boolean insert(User user) {
		Session session = DBUtill.getSession();
		if (isUserExist(user))
			return false;
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			user.setPassword(CipherUtill.encrypt(user.getPassword(),"S@cr@t!@#"));
			session.save(user);
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return true;

	}

	@Override
	public List<User> listUser() {
		Session session = DBUtill.getSession();
		Transaction tx = null;
		List<User> list = new ArrayList<>();
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from User");
			list = query.list();
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public void update(User user) {
		Session session = DBUtill.getSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			User updatebleUser = (User) session.get(User.class, user.getId());
			updatebleUser.setEmail(user.getEmail());
			updatebleUser.setLoginName(user.getLoginName());
			updatebleUser.setName(user.getName());
			updatebleUser.setPhone(user.getPhone());
			updatebleUser.setRole(user.getRole());
			updatebleUser.setStatus(user.getStatus());
			updatebleUser.setPassword(user.getPassword());
			session.update(updatebleUser);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public void delete(User user) {
		Session session = DBUtill.getSession();
		Transaction tx = null;

		try {
			tx = session.getTransaction();
			tx.begin();
			session.delete(user);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}

	}

	public boolean isUserExist(User user) {
		Session session = DBUtill.getSession();
		boolean result = false;
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from User where loginName='" + user.getLoginName() + "'");
			User emp = (User) query.uniqueResult();
			tx.commit();
			if (emp != null)
				result = true;

		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}

		} finally {
			session.close();
		}
		return result;

	}

}
