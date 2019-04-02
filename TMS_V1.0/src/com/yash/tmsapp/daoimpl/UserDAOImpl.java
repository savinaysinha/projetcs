package com.yash.tmsapp.daoimpl;

import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yash.tmsapp.dao.UserDAO;
import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.util.DBUtill;

public class UserDAOImpl extends DBUtill implements UserDAO {
	
	private String sql;
	private PreparedStatement pstmt=null;
	
	@Override
	public void create(User user) {
		
	 	sql="INSERT INTO users(NAME,email,loginName,PASSWORD,phone,role,status) VALUES(?,?,?,?,?,?,?)";
		pstmt = preparedConnection(sql);
		try {
			pstmt.setString(1,user.getName());
			pstmt.setString(2,user.getEmail());
			pstmt.setString(3,user.getLoginName());
			pstmt.setString(4,user.getPassword());
			pstmt.setString(5, user.getPhone());
			pstmt.setInt(6, user.getRole());
			pstmt.setInt(7, user.getStatus());
			pstmt.execute();
		} catch (SQLException e) {	
			e.printStackTrace();
		}
	}

	@Override
	public List<User> listUser() {
		List<User> list = new ArrayList<>();
		
		String sql="select * from users";
		pstmt = preparedConnection(sql);
		try {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setLoginName(rs.getString("loginName"));
			user.setPassword(rs.getString("password"));
			user.setRole(rs.getInt("role"));
			user.setStatus(rs.getInt("status"));
			list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return list;
	}
	@Override
	public void update(User user) {
		sql="UPDATE users SET NAME=?, phone=?, email=?, loginName=?, password=?, role=?, status=? WHERE id=?;";
		pstmt=preparedConnection(sql);
		try {
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPhone());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getLoginName());
			pstmt.setString(5, user.getPassword());
			pstmt.setInt(6, user.getRole());
			pstmt.setInt(7, user.getStatus());
			pstmt.setInt(8,user.getId());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public User freeSeach(String str) {
		// TODO Auto-generated method stub
		return null;
	}

}
