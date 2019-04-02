package com.yash.tmsapp.exception;

public class TrainingNotFoundException extends Exception {
	public TrainingNotFoundException() {}
	public TrainingNotFoundException(String errMsg) {
		super(errMsg);
	}
}
