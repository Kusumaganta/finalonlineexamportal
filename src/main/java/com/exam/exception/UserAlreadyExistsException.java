package com.exam.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserAlreadyExistsException extends Exception{
	private static final Logger logger =  LoggerFactory.getLogger(UserAlreadyExistsException.class);
private String message;
public UserAlreadyExistsException() {}
public UserAlreadyExistsException(String message) {
	super(message);
	this.message=message;
	logger.info(message);
}
}