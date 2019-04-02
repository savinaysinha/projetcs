package com.yash.pbapp.configuration;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * this class is used for service and repository related bean configuration all
 * beans are managed by Spring
 * 
 * @author savinay.sinha
 *
 */
@Configuration
@ComponentScan(basePackages = { "com.yash.pbapp.daoimpl", "com.yash.pbapp.serviceimpl" })
public class SpringRootConfig {

	// TODO: service,DAO, data source , Email sender, SMS sender, or some other
	// beans related to business logic
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/pbdb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setMaxTotal(2);
		dataSource.setInitialSize(1);
		dataSource.setTestOnBorrow(true);
		dataSource.setValidationQuery("SELECT 1");
		dataSource.setDefaultAutoCommit(true);
		return dataSource;
	}

}
