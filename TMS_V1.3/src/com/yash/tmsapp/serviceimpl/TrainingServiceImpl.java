package com.yash.tmsapp.serviceimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yash.tmsapp.dao.TrainingDAO;
import com.yash.tmsapp.daoimpl.TrainingDAOImpl;
import com.yash.tmsapp.domain.Training;
import com.yash.tmsapp.exception.TrainingNotFoundException;
import com.yash.tmsapp.service.TrainingService;
import com.yash.tmsapp.util.DBUtill;

import sun.print.PeekGraphics;

public class TrainingServiceImpl extends DBUtill implements TrainingService {

	private TrainingDAO trainingDAO = null;
	private Session session = null;

	public TrainingServiceImpl() {
		trainingDAO = new TrainingDAOImpl();
		session = getSession();

	}

	@Override
	public void register(Training training) {
		trainingDAO.create(training);

	}

	@Override
	public Training listByid(int id) throws TrainingNotFoundException {
		Training training = new Training();
		Session session = DBUtill.getSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from Training where id = :uid");
			query.setParameter("uid", id);
			training = (Training) query.list().get(0);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return training;
	}

	@Override
	public List<Training> listByUserId(int userId) throws TrainingNotFoundException {

		List<Training> trainings = new ArrayList<Training>();
		Session session = DBUtill.getSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from Training where userId = :uid");
			query.setParameter("uid", userId);
			trainings = query.list();
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return trainings;
	}


	@Override
	public List<Training> searchText(int userId, String text) {
		List<Training> trainings = new ArrayList<>();
		Training training = null;
		String sql = "from Training where title like '" + text + "%' or objective like '" + text
				+ "%' or course like '" + text + "%' or MODE like '" + text + "%' or batchSize like '" + text
				+ "%' or expectation like '" + text + "%' or duration like '" + text + "%' and userId= :uid ";
		
		Session session = DBUtill.getSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery(sql);
			query.setParameter("uid", userId);
			trainings = query.list();
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			ex.printStackTrace();
		} finally {
			session.close();
		}

		return trainings;

	}

	@Override
	public void delete(int trainingId) throws TrainingNotFoundException {
		trainingDAO.delete(trainingId);

	}

	@Override
	public void update(Training training) {
		trainingDAO.update(training);
	}

}
