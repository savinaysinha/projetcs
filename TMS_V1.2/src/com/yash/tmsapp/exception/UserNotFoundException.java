package com.yash.tmsapp.exception;

/**
 * This UserNotFoundException will be thrown when User will be not found
 * @author savinay.sinha
 *
 */
public class UserNotFoundException extends Exception {
	/**
	 * Constructs an UserNotFoundException with the specified detail message.
	 */
	public UserNotFoundException() {
		
	}
	/**
	 * Constructs an UserNotFoundException with the specified detail errMsg.
	 * @param errMsg to be thrown
	 */
	public UserNotFoundException(String errMsg){
		super(errMsg);
	}

}
