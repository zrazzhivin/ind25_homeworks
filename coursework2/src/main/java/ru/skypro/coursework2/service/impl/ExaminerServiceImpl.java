package ru.skypro.coursework2.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.coursework2.exception.NotEnoughQuestionsException;
import ru.skypro.coursework2.model.Question;
import ru.skypro.coursework2.service.ExaminerService;
import ru.skypro.coursework2.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        int size = questionService.getAll().size();
        if (amount > size) {
            throw new NotEnoughQuestionsException("Запросили " + amount + "вопросов, а доступно " + size + "вопросов");
        }

        Set<Question> questions = new HashSet<>();

        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }

        return questions;
    }
}
