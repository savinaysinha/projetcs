package com.yash.tmsapp.dao;

import java.util.List;

import com.yash.tmsapp.domain.User;

/**
 * this will do the all the CRUD related operation with the User 
 * @author savinay.sinha
 *
 */
public interface UserDAO {
	
	/**
	 * this will create a user in the database
	 * @param user to be created
	 */
	void create(User user);
	
	/**
	 * this will update the user on the basis of id
	 * @param id to be updated
	 */
	
	void update(User user);
	
	
	/**
	 * this will list the user 
	 * @return a list of all the available user
	 */
	List<User> listUser();

	/**
	 * This will delete a user 
	 * @param user to be deleted
	 */
	void delete(User user);
	
	
}
