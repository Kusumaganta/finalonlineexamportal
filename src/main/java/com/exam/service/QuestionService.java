package com.exam.service;

import java.util.Set;

import com.exam.dto.QuestionDTO;
import com.exam.entity.Question;
import com.exam.entity.Quiz;
import com.exam.exception.QuestionNotFoundException;
import com.exam.exception.QuizNotFoundException;


public interface QuestionService {

	public Question addQuestion(Question question);
	public Question updateQuestion(Question question);
	public Set<Question> getQuestions()throws QuestionNotFoundException;
	public QuestionDTO getQuestion(Long questionId) throws QuestionNotFoundException;
	public Set<Question> getQuestionOfQuiz(Quiz quiz)throws QuizNotFoundException;
	public void deleteQuestion(long questionId)throws QuestionNotFoundException;
	
}
