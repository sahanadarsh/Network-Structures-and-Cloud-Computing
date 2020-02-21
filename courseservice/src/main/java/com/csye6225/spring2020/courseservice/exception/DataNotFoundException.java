package com.csye6225.spring2020.courseservice.exception;

public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5398315822550271270L;

	public DataNotFoundException(String message) {
		super(message);
	}

}
