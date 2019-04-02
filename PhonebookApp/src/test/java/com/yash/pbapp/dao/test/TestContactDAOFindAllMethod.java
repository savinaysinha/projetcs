package com.yash.pbapp.dao.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yash.pbapp.configuration.SpringRootConfig;
import com.yash.pbapp.dao.ContactDAO;
import com.yash.pbapp.exception.UserNotFoundException;
import com.yash.pbapp.model.Contact;

public class TestContactDAOFindAllMethod {

	public static void main(String[] args) throws UserNotFoundException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO contactDAO = ctx.getBean(ContactDAO.class);
		List<Contact> contacts = contactDAO.findAll();
		for (Contact contact : contacts) {
			System.out.println(contact.getName());
		}

	}

}
