package com.exam.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuestionNotFoundException extends Exception {
	private static final Logger logger =  LoggerFactory.getLogger(QuestionNotFoundException.class);
	private String message;

	public QuestionNotFoundException() {}
	public QuestionNotFoundException(String message) {
		super(message);
		this.message=message;
		logger.info(message);
	}
}
