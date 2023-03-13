package com.exam.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CategoryAlreadyExistsException extends Exception{
	private static final Logger logger =  LoggerFactory.getLogger(CategoryAlreadyExistsException.class);
	private String message;
	public CategoryAlreadyExistsException() {}
	public CategoryAlreadyExistsException(String message) {
		super(message);
		this.setMessage(message);
		logger.info(message);
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	}
