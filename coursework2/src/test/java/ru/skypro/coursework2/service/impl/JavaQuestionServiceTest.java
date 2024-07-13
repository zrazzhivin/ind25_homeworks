package ru.skypro.coursework2.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.skypro.coursework2.model.Question;
import ru.skypro.coursework2.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    private QuestionService questionService;

    @BeforeEach
    public void clear() {
        questionService = new JavaQuestionService();
    }

    @Test
    void shouldAddQuestion() {
        // given
        Question expectedQuestion = new Question("question", "answer");

        // when
        Question actualQuestion1 = questionService.add(expectedQuestion.getQuestion(), expectedQuestion.getAnswer());
        Question actualQuestion2 = questionService.add(expectedQuestion);

        // then
        Assertions.assertEquals(expectedQuestion.getQuestion(), actualQuestion1.getQuestion());
        Assertions.assertEquals(expectedQuestion.getAnswer(), actualQuestion1.getAnswer());

        Assertions.assertEquals(expectedQuestion, actualQuestion2);
    }

    @Test
    void shouldRemoveQuestion() {
        // given
        Question question = new Question("question", "answer");
        questionService.add(question);

        // when
        Question actualQuestion = questionService.remove(question);

        // then
        Assertions.assertEquals(question, actualQuestion);
    }

    @Test
    void getAll() {
        // given
        Question question1 = new Question("question", "answer");
        Question question2 = new Question("question2", "answer2");

        questionService.add(question1);
        questionService.add(question2);

        // when
        Collection<Question> actualQuestions = questionService.getAll();

        // then
        Assertions.assertEquals(Set.of(question1, question2), actualQuestions);
    }

    @Test
    void getRandomQuestion() {
        // given
        Question question1 = new Question("question", "answer");
        Question question2 = new Question("question2", "answer2");

        questionService.add(question1);
        questionService.add(question2);

        // when
        Question randomQuestion = questionService.getRandomQuestion();

        // then
        Assertions.assertTrue(Set.of(question1, question2).contains(randomQuestion));
    }
}