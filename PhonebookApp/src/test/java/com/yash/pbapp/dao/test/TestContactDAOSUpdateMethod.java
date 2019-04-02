package com.yash.pbapp.dao.test;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yash.pbapp.configuration.SpringRootConfig;
import com.yash.pbapp.dao.ContactDAO;
import com.yash.pbapp.dao.UserDAO;
import com.yash.pbapp.exception.ContactNotFoundException;
import com.yash.pbapp.exception.UserNotFoundException;
import com.yash.pbapp.model.Contact;
import com.yash.pbapp.model.User;

public class TestContactDAOSUpdateMethod {

	public static void main(String[] args) throws UserNotFoundException, ContactNotFoundException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO contactDAO = ctx.getBean(ContactDAO.class);
		Contact contact = new Contact();
		contact.setId(4);
		contact.setUserId(3);
		contact.setName("Ravi Kumar");
		contact.setCgroup("collegue");
		contact.setPhone("9914360114");
		contact.setAddress("Bhopal");
		contactDAO.update(contact);		
		
		System.out.println("Contact updated Succesfully");

	}

}
