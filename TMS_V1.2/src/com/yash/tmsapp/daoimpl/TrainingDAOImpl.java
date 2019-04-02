package com.yash.tmsapp.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.yash.tmsapp.dao.TrainingDAO;
import com.yash.tmsapp.domain.Training;
import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.exception.TrainingNotFoundException;
import com.yash.tmsapp.util.DBUtill;

import sun.dc.pr.PRError;

public class TrainingDAOImpl extends DBUtill implements TrainingDAO {
	private Session session = null;

	public TrainingDAOImpl() {
		session = getSession();
	}

	@Override
	public void create(Training training) {
		try {
			session.beginTransaction();
			session.save(training);
			session.getTransaction().commit();
		} catch (Throwable t) {
			session.getTransaction().rollback();
			throw t;
		}
	}

	@Override
	public void update(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Training training) {
		try {
			session.beginTransaction();
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
			session.getTransaction().commit();
		} catch (Throwable t) {
			session.getTransaction().rollback();
			throw t;
		}
	}

	@Override
	public void delete(int id) throws TrainingNotFoundException {
		try {
			session.beginTransaction();
			Training training = (Training)session.load(Training.class,id);
		    session.delete(training);
			session.getTransaction().commit();
		} catch (Throwable t) {
			session.getTransaction().rollback();
			throw t;
		}

	}

	@Override
	public List<Training> listTraining() {
		List<Training> trainings = new ArrayList<Training>();
		try {
			
			session.beginTransaction();
			Query query = session.createQuery("from Training");
			trainings = query.list();
			session.getTransaction().commit();
		} catch (Throwable t) {
			session.getTransaction().rollback();
			throw t;
		}

		return trainings;
	}

}
