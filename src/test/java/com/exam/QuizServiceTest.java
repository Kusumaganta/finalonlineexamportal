package com.exam;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.exam.dto.QuizDTO;
import com.exam.entity.Quiz;
import com.exam.exception.QuizNotFoundException;
import com.exam.repository.QuizRepository;
import com.exam.service.QuizServiceImpl;

public class QuizServiceTest {

    @Mock
    private QuizRepository quizRepository;

    @InjectMocks
    private QuizServiceImpl quizService;

    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddQuiz() {
        Quiz quiz = new Quiz();
        quiz.setqId(1L);
        when(quizRepository.save(any(Quiz.class))).thenReturn(quiz);

        Quiz savedQuiz = quizService.addQuiz(quiz);

        Assertions.assertEquals(quiz, savedQuiz);
        verify(quizRepository, times(1)).save(any(Quiz.class));
    }

    @Test
    public void testUpdateQuiz() {
        Quiz quiz = new Quiz();
        quiz.setqId(1L);
        when(quizRepository.save(any(Quiz.class))).thenReturn(quiz);

        Quiz updatedQuiz = quizService.updateQuiz(quiz);

        Assertions.assertEquals(quiz, updatedQuiz);
        verify(quizRepository, times(1)).save(any(Quiz.class));
    }

    @Test
    public void testGetQuiz() throws QuizNotFoundException {
        Quiz quiz = new Quiz();
        quiz.setqId(1L);
        quiz.setTitle("Test Quiz");
        when(quizRepository.findById(anyLong())).thenReturn(Optional.of(quiz));

        QuizDTO quizDTO = quizService.getQuiz(1L);

        Assertions.assertEquals(quiz.getTitle(), quizDTO.getTitle());
        verify(quizRepository, times(1)).findById(anyLong());
    }

    @Test
    public void testDeleteQuiz() throws QuizNotFoundException {
        Quiz quiz = new Quiz();
        quiz.setqId(1L);
        when(quizRepository.findById(anyLong())).thenReturn(Optional.of(quiz));

        quizService.deleteQuiz(1L);

        verify(quizRepository, times(1)).deleteById(anyLong());
    }
}

