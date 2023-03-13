package com.exam.service;

import java.util.Set;

import com.exam.dto.QuizDTO;
import com.exam.entity.Quiz;
import com.exam.exception.QuizNotFoundException;


public interface QuizService {

	public Quiz addQuiz(Quiz quiz);
	public Quiz updateQuiz(Quiz quiz);
	public Set<Quiz> getQuizzes();
	public QuizDTO getQuiz(Long quizId)throws QuizNotFoundException;
	public void deleteQuiz(long quizId) throws QuizNotFoundException;
	
}