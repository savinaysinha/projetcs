package com.yash.tmsapp.serviceimpl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yash.tmsapp.dao.UserDAO;
import com.yash.tmsapp.daoimpl.UserDAOImpl;
import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.exception.UserNotFoundException;
import com.yash.tmsapp.service.UserService;
import com.yash.tmsapp.util.CipherUtill;
import com.yash.tmsapp.util.DBUtill;

public class UserServiceImpl extends DBUtill implements UserService {

	private UserDAO userDAO = null;;

	public UserServiceImpl() {
		userDAO = new UserDAOImpl();
	}

	@Override
	public void register(User user) {
		user.setRole(UserService.ROLE_BUSINESS);
		user.setStatus(UserService.STATUS_ACTIVE);
		userDAO.insert(user);

	}

	@Override
	public User authenticate(String loginName, String password) throws UserNotFoundException {
		User user = new User();
		Session session = DBUtill.getSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query1 = session.createQuery("from User where loginName = :loginName");
			query1.setParameter("loginName", loginName);
			user = (User) query1.list().get(0);
			tx.commit();
			String decriptedText = CipherUtill.decrypt(user.getPassword(), "S@cr@t!@#");
			System.out.println(decriptedText);
			if (decriptedText.equals(password)) {
				user.setPassword(decriptedText);
			} else {
				user = null;
			}

		} catch (Exception ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

}
