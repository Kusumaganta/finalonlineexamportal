package com.exam.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dto.QuestionDTO;
import com.exam.entity.Question;
import com.exam.entity.Quiz;
import com.exam.exception.QuestionNotFoundException;
import com.exam.exception.QuizNotFoundException;
import com.exam.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {
    
	@Autowired
	private QuestionRepository questionRepository;
	private static final Logger logger =  LoggerFactory.getLogger(QuestionServiceImpl.class);
	@Override
	public Question addQuestion(Question question) {
		logger.info("add Question");
		return this.questionRepository.save(question);
		
	}

	@Override
	public Question updateQuestion(Question question) {
		logger.info("update Question");
		return this.questionRepository.save(question);
	}

	@Override
	public Set<Question> getQuestions() {
		logger.info("get AllQuestions");
		return new HashSet<>(this.questionRepository.findAll());
	}
	@Override
	public QuestionDTO getQuestion(Long questionId) throws QuestionNotFoundException{
		java.util.Optional<Question> optional = questionRepository.findById(questionId);
		Question question = optional.orElseThrow(()-> new QuestionNotFoundException());
		QuestionDTO question2 = new QuestionDTO();
		question2.setAnswer(question.getAnswer());
		question2.setContent(question.getContent());
		question2.setOption1(question.getOption1());
		question2.setOption2(question.getOption2());
		question2.setOption3(question.getOption3());
		question2.setOption4(question.getOption4());
		question2.setQuesId(question.getQuesId());
		question2.setQuiz(question.getQuiz());
		logger.info("get Question");
		return question2;
	}

	@Override
	public Set<Question> getQuestionOfQuiz(Quiz quiz) {
		logger.info("get QuestionOfQuiz");
		return this.questionRepository.findByQuiz(quiz);
	}

	@Override
	public void deleteQuestion(long questionId) throws QuestionNotFoundException{
		
		
			Optional<Question> optional = questionRepository.findById(questionId);
			Question question = optional.orElseThrow(()-> new QuestionNotFoundException());
		Question questions = new Question();
		question.setQuesId(questionId);
		this.questionRepository.deleteById(questionId);
		logger.info("delete Question");
	}

}
