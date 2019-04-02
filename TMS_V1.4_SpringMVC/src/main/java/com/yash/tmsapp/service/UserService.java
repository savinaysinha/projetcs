package com.yash.tmsapp.service;

import com.yash.tmsapp.domain.User;

/**
 * This will perform all service related logic for user
 * 
 * @author savinay.sinha
 *
 */
public interface UserService {

	/**
	 * role of the user as business
	 */
	Integer ROLE_BUSINESS = 2;

	/**
	 * role of the user as L&D
	 */
	Integer ROLE_LD = 1;

	/**
	 * status of the user as active
	 */
	Integer STATUS_ACTIVE = 1;

	/**
	 * status of the user as blocked
	 */
	Integer STATUS_BLOCKED = 2;

	/**
	 * this will register a new user
	 * 
	 * @param user
	 *            to be registered
	 */
	void register(User user);

	/**
	 * this will authenticate the user
	 * 
	 * @param username
	 *            to be checked
	 * @param password
	 *            to be checked
	 * @return user details
	 * @throws UserNotFoundException
	 */
	User authenticate(String loginName, String password);

}
