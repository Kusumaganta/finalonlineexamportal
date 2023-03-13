package com.exam.service;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.exam.dto.QuizDTO;
import com.exam.entity.Quiz;
import com.exam.exception.QuizNotFoundException;
import com.exam.repository.QuizRepository;

@Service
public class QuizServiceImpl  implements QuizService{

	
	@Autowired
	private QuizRepository quizRepository;
	private static final Logger logger =  LoggerFactory.getLogger(QuizServiceImpl.class);
	@Override
	public Quiz addQuiz(Quiz quiz) {
		logger.info("add Quiz");
		return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		logger.info("update Quiz");
		return this.quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizzes() {
		logger.info("get AllQuizzes");
		return new HashSet<>(this.quizRepository.findAll());
	}

	@Override
	public QuizDTO getQuiz(Long quizId) throws QuizNotFoundException{
		java.util.Optional<Quiz> optional = quizRepository.findById(quizId);
		Quiz quiz = optional.orElseThrow(()-> new QuizNotFoundException());
		QuizDTO quiz2 = new QuizDTO();
		quiz2.setqId(quiz.getqId());
		quiz2.setActive(quiz.isActive());
		quiz2.setTitle(quiz.getTitle());
		quiz2.setDescriptionString(quiz.getDescriptionString());
		quiz2.setQuetsions(quiz.getQuetsions());
		quiz2.setMaxMarks(quiz.getMaxMarks());
		quiz2.setCategory(quiz.getCategory());
		logger.info("get Quiz");
		return quiz2;
	}
	
	@Override
	public void deleteQuiz(long quizId) throws QuizNotFoundException{
		java.util.Optional<Quiz> optional = quizRepository.findById(quizId);
		Quiz quiz = optional.orElseThrow(()-> new QuizNotFoundException());
		Quiz quiz1 = new Quiz();
		quiz1.setqId(quizId);
		this.quizRepository.deleteById(quizId);
		logger.info("delete Quiz");
		
		
	}

}
