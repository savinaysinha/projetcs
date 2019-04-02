package com.yash.pbapp.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.PropertyValue;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.yash.pbapp.dao.BaseDAO;
import com.yash.pbapp.dao.UserDAO;
import com.yash.pbapp.exception.UserNotFoundException;
import com.yash.pbapp.model.User;
import com.yash.pbapp.rowmapper.UserRowMapper;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {

	public void save(User user){
		String sql = "Insert into users(name,email,status,role,loginname,password,created_At,updated_At) value("
				+ ":name, :email, :status, :role, :loginname, :password, :created_At, :updated_At )";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", user.getName());
		params.put("email", user.getEmail());
		params.put("status", user.getStatus());
		params.put("role", user.getRole());
		params.put("loginname", user.getLoginname());
		params.put("password", user.getPassword());
		params.put("created_At", user.getCreated_At());
		params.put("updated_At", user.getUpdated_At());
		SqlParameterSource parameterSource = new MapSqlParameterSource(params);
		KeyHolder kh = new GeneratedKeyHolder();
		getNamedParameterJdbcTemplate().update(sql, parameterSource, kh);
		Integer id = kh.getKey().intValue();
		user.setId(id);

	}

	public void update(User user) {
		String sql = "update users set name=:name,phone=:phone,address=:address,email=:email,status=:status,role=:role,loginname=:loginname,password=:password,created_At=:created_At,updated_At=:updated_At where id=:id ";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", user.getId());
		params.put("phone", user.getPhone());
		params.put("address", user.getAddress());
		params.put("name", user.getName());
		params.put("email", user.getEmail());
		params.put("status", user.getStatus());
		params.put("role", user.getRole());
		params.put("loginname", user.getLoginname());
		params.put("password", user.getPassword());
		params.put("created_At", user.getCreated_At());
		params.put("updated_At", user.getUpdated_At());
		SqlParameterSource parameterSource = new MapSqlParameterSource(params);
		getNamedParameterJdbcTemplate().update(sql, parameterSource);

	}

	public void delete(User user) {
		delete(user.getId());

	}

	public void delete(Integer id) {
		getJdbcTemplate().update("delete from users where id=?", id);

	}

	public List<User> findAll() {
		return getJdbcTemplate().query("select * from users", new UserRowMapper());
	}

	public List<User> findByProperty(String propertyName, Object propertyValue) {
			String sql = "select * from users where pbdb.users." + propertyName + " ='" + propertyValue + "' ";
			return getJdbcTemplate().query(sql, new UserRowMapper());
	}

	public User findById(Integer id) {
		return getJdbcTemplate().queryForObject("select * from users where id=?", new UserRowMapper(), id);
	}

}
