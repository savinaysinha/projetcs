package com.yash.tmsapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.PreparedStatement;

/**
 * This will be used to geting PreparedStatement object and will perform shutdown activities
 * @author savinay.sinha
 *
 */
public class DBUtill {

	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public Session getSession() {
		session = sessionFactory.openSession();
		return session;
	}

	public void closeSession() {
		session.close();
	}
}
