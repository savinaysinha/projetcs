package com.yash.pbapp.service;

import java.util.List;

import com.yash.pbapp.exception.BlockedUserException;
import com.yash.pbapp.exception.UserNotFoundException;
import com.yash.pbapp.model.User;

/**
 * 
 * @author savinay.sinha
 *
 */
public interface UserService {
	
	/**
	 * role of the user as business
	 */
	Integer ROLE_ADMIN = 1;

	/**
	 * role of the user as L&D
	 */
	Integer ROLE_USER = 2;

	/**
	 * status of the user as active
	 */
	Integer STATUS_ACTIVE = 1;

	/**
	 * status of the user as blocked
	 */
	Integer STATUS_BLOCKED = 2;

	/**
	 * this will authenticate the user if user is valid it will return the user if
	 * user is blocked then it will thorw BlockedUserException but if user is not
	 * found it will return null
	 * @param username
	 *            to be checked
	 * @param password
	 *            to be checked
	 * @return user if found otherwise return null
	 * @throws UserNotFoundException if user not found
	 */
	User authenticate(String loginname, String password) throws BlockedUserException;
	
	/**
	 * this will register a new user
	 * 
	 * @param user
	 *            to be registered
	 */
	void register(User user);
	
	/**
	 * Update the User in DB
	 * @param user to be updated
	 */
	void update(User user);
	
	
	/**
	 * Delete a User in DB
	 * @param user to be deleted
	 */
	void delete(User user);
	
	/**
	 * Delete a User in DB
	 * @param id of the user to be deleted
	 */
	void delete(Integer id);
	
	/**
	 * find all the existing User
	 * @return List of User 
	 */
	List<User> findAll();
	
	/**
	 * Find User on the basis of property
	 * @param propertyName of the User
	 * @param propertyValue of the User
	 * @return List of User
	 */
	List<User> findByProperty(String propertyName, Object propertyValue);
	
	/**
	 * this will fetch a user
	 * @param id is used to fetch the user
	 * @return a user
	 */
	User findById(Integer id);
	

}
