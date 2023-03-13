package com.exam.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.entity.Question;
import com.exam.entity.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	Set<Question> findByQuiz(Quiz quiz);

}
