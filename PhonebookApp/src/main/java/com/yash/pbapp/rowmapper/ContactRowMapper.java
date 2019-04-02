package com.yash.pbapp.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;

import com.yash.pbapp.model.Contact;

public class ContactRowMapper implements RowMapper {

	public Object mapRow(ResultSet rs, int arg1) throws SQLException, DataAccessException {
		Contact contact = new Contact();
		contact.setAddress(rs.getString("address"));
		contact.setCgroup(rs.getString("cgroup"));
		contact.setCreated_At(rs.getDate("created_At"));
		contact.setCreated_By(rs.getInt("created_By"));
		contact.setEmail(rs.getString("email"));
		contact.setId(rs.getInt("id"));
		contact.setName(rs.getString("name"));
		contact.setPhone(rs.getString("phone"));
		contact.setRemark(rs.getString("remark"));
		contact.setUpdated_At(rs.getDate("updated_At"));
		contact.setUpdated_By(rs.getInt("updated_By"));
		contact.setUserId(rs.getInt("userid"));
		return contact;
	}

}
