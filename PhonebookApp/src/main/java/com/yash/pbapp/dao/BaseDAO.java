package com.yash.pbapp.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

/**
 * This BaseDAO is not managed by Spring so dont user @service , @Controller, @Repository @Component
 * this should not used as an object, it should always serve to provide datasource to DAO implementation
 * @author savinay.sinha
 *
 */
public abstract class BaseDAO extends NamedParameterJdbcDaoSupport {

	@Autowired
	public void setDataSource2(DataSource dataSource) {
		super.setDataSource(dataSource);
		
	}
}
