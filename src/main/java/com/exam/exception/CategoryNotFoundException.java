package com.exam.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CategoryNotFoundException extends Exception{
	private static final Logger logger =  LoggerFactory.getLogger(CategoryNotFoundException.class);
	private String message;

	public CategoryNotFoundException() {}
	public CategoryNotFoundException(String message) {
		super(message);
		this.message=message;
		logger.info(message);
	}
}