package com.yash.pbapp.dao;

import java.util.List;

import com.yash.pbapp.exception.ContactNotFoundException;
import com.yash.pbapp.exception.UserNotFoundException;
import com.yash.pbapp.model.Contact;

/**
 * This will perform the CRUD operation Contact
 * @author savinay.sinha
 *
 */
public interface ContactDAO {
	
	/**
	 * Save the Contact in DB
	 * @param user to be Saved
	 * @throws UserNotFoundException
	 */
	void save(Contact contact) throws ContactNotFoundException;
	
	/**
	 * Update the Contact in DB
	 * @param user to be updated
	 */
	void update(Contact contact);
	
	
	/**
	 * Delete a Contact in DB
	 * @param user to be deleted
	 */
	void delete(Contact contact);
	
	/**
	 * Delete a Contact in DB
	 * @param id of the user to be deleted
	 */
	void delete(int id);
	
	/**
	 * find all the existing User
	 * @return List of User 
	 */
	List<Contact> findAll();
	
	/**
	 * Find Contact on the basis of property
	 * @param propertyName of the Contact
	 * @param propertyValue of the Contact
	 * @return List of User
	 */
	List<Contact> findByProperty(String propertyName, Object propertyValue);
	
	Contact FindById(int id);


}
