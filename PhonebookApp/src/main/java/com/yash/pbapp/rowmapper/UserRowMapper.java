package com.yash.pbapp.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.yash.pbapp.model.User;

public class UserRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setLoginname(rs.getString("loginname"));
		user.setPassword(rs.getString("password"));
		user.setRole(rs.getInt("role"));
		user.setStatus(rs.getInt("status"));
		user.setCreated_At(rs.getDate("created_At"));
		user.setAddress(rs.getString("address"));
		user.setPhone(rs.getString("phone"));
		user.setUpdated_At(rs.getDate("updated_At"));
		return user;
	}

}
