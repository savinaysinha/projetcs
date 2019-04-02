package com.yash.tmsapp.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yash.tmsapp.dao.TrainingDAO;
import com.yash.tmsapp.domain.Training;
import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.exception.TrainingNotFoundException;
import com.yash.tmsapp.util.DBUtill;

import sun.dc.pr.PRError;

public class TrainingDAOImpl extends DBUtill implements TrainingDAO {
	private String sql;
	private PreparedStatement pstmt=null;
	@Override
	public void create(Training training) {
		sql="INSERT INTO trainings(userId,title,objective,course,MODE,batchSize,expectation,duration) VALUES(?,?,?,?,?,?,?,?)";
		pstmt = preparedConnection(sql);
		try {
			pstmt.setInt(1, training.getUserId());
			pstmt.setString(2, training.getTitle());
			pstmt.setString(3, training.getObjective());
			pstmt.setString(4, training.getCourse());
			pstmt.setInt(5, training.getMode());
			pstmt.setInt(6, training.getBatchSize());
			pstmt.setString(7, training.getExpectation());
			pstmt.setInt(8, training.getDuration());
			pstmt.execute();
			
		} catch (SQLException e) {	
			e.printStackTrace();
		}
	}
	@Override
	public void update(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Training training) {
		String sql="UPDATE trainings SET title=?,objective=?,course=?,MODE=?,batchSize=?,expectation=?,duration=? WHERE id=?";
		PreparedStatement pstmt = preparedConnection(sql);
		try {
			pstmt.setString(1, training.getTitle());
			pstmt.setString(2, training.getObjective());
			pstmt.setString(3, training.getCourse());
			pstmt.setInt(4, training.getMode());
			pstmt.setInt(5, training.getBatchSize());
			pstmt.setString(6, training.getExpectation());
			pstmt.setInt(7, training.getDuration());
			pstmt.setInt(8, training.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	@Override
	public void delete(int trainingId) throws TrainingNotFoundException {
		String sql="DELETE FROM trainings WHERE id=?";
		PreparedStatement pstmt = preparedConnection(sql);
		try {
			pstmt.setInt(1, trainingId);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Training> listTraining() {
		List<Training> list = new ArrayList<Training>();
		String sql="SELECT * FROM trainings";
		pstmt =  preparedConnection(sql);
		
		try {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Training training = new Training();
				training.setBatchSize(rs.getInt("batchSize"));
				training.setCourse(rs.getString("course"));
				training.setDuation(rs.getInt("duration"));
				training.setExpectation(rs.getString("expectation"));
				training.setObjective(rs.getString("objective"));
				training.setTitle(rs.getString("title"));
				training.setMode(rs.getInt("mode"));
				list.add(training);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
