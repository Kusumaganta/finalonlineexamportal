package com.exam.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuizNotFoundException extends Exception{
	private static final Logger logger =  LoggerFactory.getLogger(QuizNotFoundException.class);
	private String message;

	public QuizNotFoundException() {}
	public QuizNotFoundException(String message) {
		super(message);
		this.message=message;
		logger.info(message);
	}

}
