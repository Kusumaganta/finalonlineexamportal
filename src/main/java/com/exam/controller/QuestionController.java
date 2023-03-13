package com.exam.controller;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.dto.QuestionDTO;
import com.exam.dto.QuizDTO;
import com.exam.entity.Question;
import com.exam.entity.Quiz;
import com.exam.exception.QuestionNotFoundException;
import com.exam.exception.QuizNotFoundException;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;


@RestController
@RequestMapping("/question")
public class QuestionController {
	@Autowired
	private QuestionService Service;
	
	@Autowired
	private QuizService quizservice;// quiz load
	
	// add question service 
	@PostMapping("/")
	public ResponseEntity<Question> add(@RequestBody Question question)
	{
		return ResponseEntity.ok(this.Service.addQuestion(question));
	}
	//update question
	@PutMapping("/")
	public ResponseEntity<Question> update(@RequestBody Question question)
	{
		return ResponseEntity.ok(this.Service.updateQuestion(question));
		
	}
	//getting  all question of any quid
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("qid") long qid) throws QuizNotFoundException
	{
//		Quiz quiz = new Quiz();
//		quiz.setqId(qid);
//		
//		Set<Question> questionOfQuiz= this.Service.getQuestionOfQuiz(quiz);
//		return ResponseEntity.ok(questionOfQuiz);
		QuizDTO quiz = this.quizservice.getQuiz(qid);// we want only those which we want like no of question
		Set<Question> qusetions = quiz.getQuetsions();
		List list=new ArrayList(qusetions);
		if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions()));
		{
			list=list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions()+1));
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
		
	}
		// get single question
	@GetMapping("/{quesid}")
	public  QuestionDTO get(@PathVariable("quesid") long quesid) throws QuestionNotFoundException{
		{
			return  this.Service.getQuestion( quesid);
		}
	}

	// delete the quiz 
	@DeleteMapping("/{quesid}")
	public void delete(@PathVariable("quesid") long quesid) throws QuestionNotFoundException
	{
		this.Service.deleteQuestion(quesid);
	}
	
	
}

