package com.yash.pbapp.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.yash.pbapp.dao.BaseDAO;
import com.yash.pbapp.dao.ContactDAO;
import com.yash.pbapp.exception.ContactNotFoundException;
import com.yash.pbapp.model.Contact;
import com.yash.pbapp.model.User;
import com.yash.pbapp.rowmapper.ContactRowMapper;
import com.yash.pbapp.rowmapper.UserRowMapper;

@Repository
public class ContactDAOImpl extends BaseDAO implements ContactDAO {

	public void save(Contact contact) throws ContactNotFoundException {
		String sql = "Insert into contacts(name,userid,phone,cgroup,address,email,remark, updated_By,created_By,created_At,updated_At) value("
				+ ":name, :userid,:phone,:cgroup,:address,:email, :remark, :updated_By, :created_By,:created_At, :updated_At )";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", contact.getName());
		params.put("phone", contact.getPhone());
		params.put("userid", contact.getUserId());
		params.put("email", contact.getEmail());
		params.put("cgroup", contact.getCgroup());
		params.put("address", contact.getAddress());
		params.put("remark", contact.getRemark());
		params.put("created_At", contact.getCreated_At());
		params.put("updated_At", contact.getUpdated_At());
		params.put("updated_By", contact.getUpdated_By());
		params.put("created_By", contact.getCreated_By());
		SqlParameterSource parameterSource = new MapSqlParameterSource(params);
		KeyHolder kh = new GeneratedKeyHolder();
		getNamedParameterJdbcTemplate().update(sql, parameterSource, kh);
		Integer id = kh.getKey().intValue();
		contact.setId(id);

	}

	public void update(Contact contact) {
		String sql = "update contacts set name=:name,userid=:userid,phone=:phone,cgroup=:cgroup,address=:address,email=:email,remark=:remark,updated_By=:updated_By,created_By=:created_By,updated_At=:updated_At,created_At=:created_At where id=:id ";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", contact.getId());
		params.put("name", contact.getName());
		params.put("phone", contact.getPhone());
		params.put("userid", contact.getUserId());
		params.put("email", contact.getEmail());
		params.put("cgroup", contact.getCgroup());
		params.put("address", contact.getAddress());
		params.put("remark", contact.getRemark());
		params.put("created_At", contact.getCreated_At());
		params.put("updated_At", contact.getUpdated_At());
		params.put("updated_By", contact.getUpdated_By());
		params.put("created_By", contact.getCreated_By());
		SqlParameterSource parameterSource = new MapSqlParameterSource(params);
		getNamedParameterJdbcTemplate().update(sql, parameterSource);

	}


	public void delete(Contact contact) {
		delete(contact.getId());

	}

	public void delete(int id) {
		getJdbcTemplate().update("delete from contacts where id=?", id);

	}

	public List<Contact> findAll() {
		return getJdbcTemplate().query("select * from contacts", new ContactRowMapper());
	}

	public List<Contact> findByProperty(String propertyName, Object propertyValue) {
		if (propertyValue.getClass().equals("class java.lang.Integer")) {
			return getJdbcTemplate().query(
					"select * from contacts where " + propertyName + " =" + propertyValue + " ", new ContactRowMapper());
		} else {
			String property = propertyValue.toString();
			return getJdbcTemplate().query(
					
					"select * from contacts where " + propertyName + " ='" + property + "' ", new ContactRowMapper());
		}
	}

	public Contact FindById(int id) {
		return getJdbcTemplate().queryForObject("select * from contacts", new ContactRowMapper());
	}

}
