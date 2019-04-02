package com.yash.tmsapp.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



/**
 * This will be used to geting PreparedStatement object and will perform shutdown activities
 * @author savinay.sinha
 *
 */
public class DBUtill {

	private static final SessionFactory sessionFactory;

	static {
		try {
		sessionFactory = new Configuration().configure().buildSessionFactory();
		}catch(Throwable ex){
			System.err.println("Initial SessionFactory Creation Failure : "+ex);
			throw new ExceptionInInitializerError(ex);
		}
		
		}

	public static Session getSession() {
		
		return sessionFactory.openSession();
		
	}	
}
