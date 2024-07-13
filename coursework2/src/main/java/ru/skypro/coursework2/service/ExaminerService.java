package ru.skypro.coursework2.service;

import ru.skypro.coursework2.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestion(int amount);

}
