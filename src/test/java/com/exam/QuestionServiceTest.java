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

import com.exam.dto.QuestionDTO;
import com.exam.entity.Question;
import com.exam.exception.QuestionNotFoundException;
import com.exam.repository.QuestionRepository;
import com.exam.service.QuestionServiceImpl;

public class QuestionServiceTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionServiceImpl questionService;

    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddQuestion() {
        Question question = new Question();
        question.setQuesId(1L);
        when(questionRepository.save(any(Question.class))).thenReturn(question);

        Question savedQuestion = questionService.addQuestion(question);

        Assertions.assertEquals(question, savedQuestion);
        verify(questionRepository, times(1)).save(any(Question.class));
    }

    @Test
    public void testUpdateQuestion() {
        Question question = new Question();
        question.setQuesId(1L);
        when(questionRepository.save(any(Question.class))).thenReturn(question);

        Question updatedQuestion = questionService.updateQuestion(question);

        Assertions.assertEquals(question, updatedQuestion);
        verify(questionRepository, times(1)).save(any(Question.class));
    }

    @Test
    public void testGetQuestion() throws QuestionNotFoundException {
        Question question = new Question();
        question.setQuesId(1L);
        question.setContent("Test question");
        when(questionRepository.findById(anyLong())).thenReturn(Optional.of(question));

        QuestionDTO questionDTO = questionService.getQuestion(1L);

        Assertions.assertEquals(question.getContent(), questionDTO.getContent());
        verify(questionRepository, times(1)).findById(anyLong());
    }

    @Test
    public void testDeleteQuestion() throws QuestionNotFoundException {
        Question question = new Question();
        question.setQuesId(1L);
        when(questionRepository.findById(anyLong())).thenReturn(Optional.of(question));

        questionService.deleteQuestion(1L);

        verify(questionRepository, times(1)).deleteById(anyLong());
    }
}

