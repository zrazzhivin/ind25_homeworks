package ru.skypro.coursework2.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.coursework2.exception.NotEnoughQuestionsException;
import ru.skypro.coursework2.model.Question;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void shouldCollectRequestedNumberOfQuestions() {
        // given
        int amount = 2;
        List<Question> questionList = List.of(
                new Question("question1", "answer1"),
                new Question("question2", "answer2"),
                new Question("question3", "answer3")
        );

        when(javaQuestionService.getAll()).thenReturn(questionList);
        when(javaQuestionService.getRandomQuestion()).thenReturn(
                questionList.get(0),
                questionList.get(0),
                questionList.get(0),
                questionList.get(1)
        );

        // when
        Collection<Question> actualQuestions = examinerService.getQuestion(amount);

        // then
        Assertions.assertEquals(Set.of(questionList.get(0), questionList.get(1)), actualQuestions);

        Mockito.verify(javaQuestionService, times(4)).getRandomQuestion();
    }

    @Test
    void shouldThrowNotEnoughQuestionsExceptionWhenThereAreNoEnoughQuestions() {
        // given
        int amount = 5;
        List<Question> questionList = List.of(
                new Question("question1", "answer1"),
                new Question("question2", "answer2"),
                new Question("question3", "answer3")
        );

        when(javaQuestionService.getAll()).thenReturn(questionList);

        // when
        // then
        Assertions.assertThrows(
                NotEnoughQuestionsException.class,
                () -> examinerService.getQuestion(amount)
        );
    }
}