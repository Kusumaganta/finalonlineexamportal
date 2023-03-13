package com.exam.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.exam.service.QuestionServiceImpl;

public class UserNotFoundException extends Exception{
	private static final Logger logger =  LoggerFactory.getLogger(UserNotFoundException.class);
private String message;

public UserNotFoundException() {}
public UserNotFoundException(String message) {
	super(message);
	this.message=message;
	logger.info(message);
}
	
	
}
