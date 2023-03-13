
package com.exam.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
	@Value(value="${message1}")
	private String message1;
	@Value(value="${message2}")
	private String message2;
	@Value(value="${message3}")
	private String message3;
	@Value(value="${message4}")
	private String message4;
	@Value(value="${message5}")
	private String message5;
	@Value(value="${message6}")
	private String message6;
	
	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity userNotFound(UserNotFoundException ex) {
		return new ResponseEntity(message1,HttpStatus.CONFLICT);
		}
	
	@ExceptionHandler(value=UserAlreadyExistsException.class)
	public ResponseEntity userAlreadyExists(UserAlreadyExistsException ex) {
		return new ResponseEntity(message2,HttpStatus.CONFLICT);
		}
	
	@ExceptionHandler(value=CategoryNotFoundException.class)
	public ResponseEntity categoryNotFound(CategoryNotFoundException ex) {
		return new ResponseEntity(message3,HttpStatus.CONFLICT);
		}
	
	@ExceptionHandler(value=CategoryAlreadyExistsException.class)
	public ResponseEntity categoryAlreadyExists(CategoryAlreadyExistsException ex) {
		return new ResponseEntity(message4,HttpStatus.CONFLICT);
		}
	
	@ExceptionHandler(value=QuizNotFoundException.class)
	public ResponseEntity quizNotFound(QuizNotFoundException ex) {
		return new ResponseEntity(message5,HttpStatus.CONFLICT);
		}
	@ExceptionHandler(value=QuestionNotFoundException.class)
	public ResponseEntity questionNotFound(QuestionNotFoundException ex) {
		return new ResponseEntity(message6,HttpStatus.CONFLICT);
		}
	
	}