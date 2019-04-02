package com.yash.tmsapp.serviceimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yash.tmsapp.dao.UserDAO;
import com.yash.tmsapp.daoimpl.UserDAOImpl;
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
		String sql="SELECT * FROM users WHERE loginName=? AND PASSWORD=?;";
		User user = new User();
		PreparedStatement pstmt = preparedConnection(sql);
		try {
			pstmt.setString(1, loginName);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setLoginName(rs.getString("loginName"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setRole(rs.getInt("role"));
				user.setStatus(rs.getInt("status"));
			}
			else {
				throw new UserNotFoundException("Username and password is not match, check your credential");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

}
