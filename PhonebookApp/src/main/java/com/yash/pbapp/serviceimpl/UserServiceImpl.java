package com.yash.pbapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.yash.pbapp.dao.BaseDAO;
import com.yash.pbapp.dao.UserDAO;
import com.yash.pbapp.exception.BlockedUserException;
import com.yash.pbapp.exception.UserNotFoundException;
import com.yash.pbapp.model.User;
import com.yash.pbapp.rowmapper.UserRowMapper;
import com.yash.pbapp.service.UserService;

@Service
public class UserServiceImpl extends BaseDAO implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public User authenticate(String loginname, String password) throws BlockedUserException{
		User user=null;
		String sql = "select * from users where loginname=? and password=?";
		try {
		user = getJdbcTemplate().queryForObject(sql, new UserRowMapper(), loginname, password);
		if(user.getStatus().equals(UserService.STATUS_BLOCKED)) {
			throw new BlockedUserException("You are blocked user, Please contact Administrator for help");
		}
		}catch (EmptyResultDataAccessException e) {
			user = null;
		}
		return user;

	}

	public void register(User user) {
		if(isUserExist(user)) {
			userDAO.save(user);
		}else {
			throw new RuntimeException("User Already Exist");
		}
		
	}

	/**
	 * This will check if user is exists in DB or not
	 * @param user to be checked
	 * @return false if found other wise return true;
	 */
	private boolean isUserExist(User user) {
		boolean status=true;
		String sql = "select * from users where email=? or phone=? ";
		try {
			user = getJdbcTemplate().queryForObject(sql, new UserRowMapper(),user.getEmail(),user.getPhone());
			status=false;
			}catch (Exception e) {
				status=true;
			}
		return status;
	}

	public void update(User user) {
		userDAO.update(user);
	}

	public void delete(User user) {
		userDAO.delete(user);
	}

	public void delete(Integer id) {
		userDAO.delete(id);		
	}

	public List<User> findAll() {
		return userDAO.findAll();
	}

	public List<User> findByProperty(String propertyName, Object propertyValue) {
		return userDAO.findByProperty(propertyName, propertyValue);
	}

	public User findById(Integer id) {
		return userDAO.findById(id);
	}
	
	

}
