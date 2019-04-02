package com.yash.tmsapp.daoimpl;

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
import com.yash.tmsapp.domain.Training;
import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.exception.TrainingNotFoundException;
import com.yash.tmsapp.util.DBUtill;

import sun.dc.pr.PRError;

public class TrainingDAOImpl extends DBUtill implements TrainingDAO {
	
	@Override
	public void create(Training training) {
		Session session = DBUtill.getSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			session.save(training);
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
	public void update(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Training training) {
		Session session = DBUtill.getSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Training updatebleTraining = (Training) session.get(Training.class, training.getId());
			updatebleTraining.setBatchSize(training.getBatchSize());
			updatebleTraining.setCourse(training.getCourse());
			updatebleTraining.setDuation(training.getDuration());
			updatebleTraining.setExpectation(training.getExpectation());
			updatebleTraining.setMode(training.getMode());
			updatebleTraining.setObjective(training.getObjective());
			updatebleTraining.setTitle(training.getTitle());
			updatebleTraining.setUserId(training.getUserId());
			session.update(updatebleTraining);
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
	public void delete(int id) throws TrainingNotFoundException {
		Session session = DBUtill.getSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Training training = (Training)session.load(Training.class,id);
		    session.delete(training);
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
	public List<Training> listTraining() {
		List<Training> trainings = new ArrayList<Training>();
		Session session = DBUtill.getSession();
		Transaction tx = null;
		try {
			tx = session.getTransaction();
			tx.begin();
			Query query = session.createQuery("from Training");
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

}
