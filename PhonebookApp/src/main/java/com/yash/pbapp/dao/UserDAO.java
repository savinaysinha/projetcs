package com.yash.pbapp.dao;

import java.util.List;

import com.yash.pbapp.exception.UserNotFoundException;
import com.yash.pbapp.model.User;

/**
 * This will perform the CRUD operation User
 * @author savinay.sinha
 *
 */
public interface UserDAO {
	
	/**
	 * Save the User in DB
	 * @param user to be Saved
	 * @throws UserNotFoundException
	 */
	void save(User user);
	
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
