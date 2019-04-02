package com.yash.tmsapp.serviceimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yash.tmsapp.dao.TrainingDAO;
import com.yash.tmsapp.daoimpl.TrainingDAOImpl;
import com.yash.tmsapp.domain.Training;
import com.yash.tmsapp.exception.TrainingNotFoundException;
import com.yash.tmsapp.service.TrainingService;
import com.yash.tmsapp.util.DBUtill;

import sun.print.PeekGraphics;

public class TrainingServiceImpl extends DBUtill implements TrainingService {

	private TrainingDAO trainingDAO = null;

	public TrainingServiceImpl() {
		trainingDAO = new TrainingDAOImpl();
	}

	@Override
	public void register(Training training) {
		trainingDAO.create(training);

	}

	@Override
	public Training listByid(int TrainingId) throws TrainingNotFoundException {
		List<Training> trainings = new ArrayList<Training>();
		String sql = "SELECT id,userId,title,objective,course,MODE,batchSize,expectation,duration FROM trainings WHERE id=?";
		Training training = null;
		PreparedStatement pstmt = preparedConnection(sql);
		try {
			pstmt.setInt(1, TrainingId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				training = new Training();
				training.setId(rs.getInt("id"));
				training.setUserId(rs.getInt("userId"));
				training.setBatchSize(rs.getInt("batchSize"));
				training.setCourse(rs.getString("course"));
				training.setDuation(rs.getInt("duration"));
				training.setExpectation(rs.getString("expectation"));
				training.setObjective(rs.getString("objective"));
				training.setTitle(rs.getString("title"));
				training.setMode(rs.getInt("mode"));
				trainings.add(training);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return training;
	}

	@Override
	public List<Training> listByUserId(int loggedInUserId) throws TrainingNotFoundException {
		List<Training> trainings = new ArrayList<Training>();
		String sql = "SELECT id,userId,title,objective,course,MODE,batchSize,expectation,duration FROM trainings WHERE userId=?";
		Training training = null;
		PreparedStatement pstmt = preparedConnection(sql);
		try {
			pstmt.setInt(1, loggedInUserId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				training = new Training();
				training.setId(rs.getInt("id"));
				training.setUserId(rs.getInt("userId"));
				training.setBatchSize(rs.getInt("batchSize"));
				training.setCourse(rs.getString("course"));
				training.setDuation(rs.getInt("duration"));
				training.setExpectation(rs.getString("expectation"));
				training.setObjective(rs.getString("objective"));
				training.setTitle(rs.getString("title"));
				training.setMode(rs.getInt("mode"));
				trainings.add(training);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return trainings;
	}

	@Override
	public void delete(int TrainingId,int loggedInUserId) throws TrainingNotFoundException {
		String sql="DELETE FROM trainings WHERE id=? AND userId=?";
		PreparedStatement pstmt = preparedConnection(sql);
		try {
			pstmt.setInt(1, TrainingId);
			pstmt.setInt(2, loggedInUserId);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Training> searchText(int loggedInUserId, String text) {
		List<Training> trainings = new ArrayList<>();
		Training training = null;
		String sql = "Select * from trainings where title like '"+text+"%' or objective like '"+text+"%' or course like '"+text+"%' or MODE like '"+text+"%' or batchSize like '"+text+"%' or expectation like '"+text+"%' or duration like '"+text+"%' and UserId=? ";
		PreparedStatement pstmt = preparedConnection(sql);
		try {
			pstmt.setInt(1, loggedInUserId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				training = new Training();
				training.setId(rs.getInt("id"));
				training.setUserId(rs.getInt("userId"));
				training.setBatchSize(rs.getInt("batchSize"));
				training.setCourse(rs.getString("course"));
				training.setDuation(rs.getInt("duration"));
				training.setExpectation(rs.getString("expectation"));
				training.setObjective(rs.getString("objective"));
				training.setTitle(rs.getString("title"));
				training.setMode(rs.getInt("mode"));
				trainings.add(training);
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
