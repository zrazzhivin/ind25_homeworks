package ru.skypro.coursework2.service.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ru.skypro.coursework2.model.Question;
import ru.skypro.coursework2.service.QuestionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();

    private final Random random = new Random();

    @PostConstruct
    public void init() {
        add("Какие есть методы?", "Статические и не статические");
        add("Как расшифровывается JDK?", "Java Development Kit");
        add("Где хранятся примитивы?", "Стек");
        add("Какой скоуп у бинов по-умолчанию?", "Синглтон");
        add("Какая структура данных под капотом у LinkedList?", "Двусвязный список");
    }

    @Override
    public Question add(String question, String answer) {
        Question questionToAdd = new Question(question, answer);
        questions.add(questionToAdd);

        return questionToAdd;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);

        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);

        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        int randomIndex = random.nextInt(questions.size());

        return new ArrayList<>(questions).get(randomIndex);
    }
}
