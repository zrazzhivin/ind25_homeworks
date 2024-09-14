package ru.hogwarts.school.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.service.StudentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final StudentRepository studentRepository;

    private final Object lock1 = new Object();

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student read(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student update(Long id, Student student) {
        return studentRepository.findById(id).map(studentFromDb -> {
            studentFromDb.setName(student.getName());
            studentFromDb.setAge(student.getAge());
            studentRepository.save(studentFromDb);
            return studentFromDb;
        }).orElse(null);
    }

    @Override
    public Student delete(Long id) {
        return studentRepository.findById(id).map(student -> {
            studentRepository.deleteById(id);
            return student;
        }).orElse(null);
    }

    @Override
    public List<Student> filterByAge(int age) {
        return studentRepository.findAllByAge(age);
    }

    @Override
    public List<Student> findAllByAgeBetween(int fromAge, int toAge) {
        return studentRepository.findAllByAgeBetween(fromAge, toAge);
    }

    @Override
    public Faculty getFaculty(Long studentId) {
        return studentRepository.findById(studentId)
                .map(Student::getFaculty)
                .orElse(null);
    }

    @Override
    public List<String> startsWithA() {
        return studentRepository.findAll()
                .stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .filter(it -> it.startsWith("A"))
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public double getAverageAge() {
        return studentRepository.findAll()
                .stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0);
    }

    @Override
    public void printParallel() {
        List<Student> students = studentRepository.findAll();

        LOGGER.info(students.get(0).getName());
        LOGGER.info(students.get(1).getName());

        new Thread(() -> {
            LOGGER.info(students.get(2).getName());
            LOGGER.info(students.get(3).getName());
        }).start();

        new Thread(() -> {
            LOGGER.info(students.get(4).getName());
            LOGGER.info(students.get(5).getName());
        }).start();
    }

    @Override
    public void printSynchronized() {
        List<Student> students = studentRepository.findAll();

        printName(students.get(0));
        printName(students.get(1));

        Object lock = new Object();

        new Thread(() -> {
            synchronized (lock) {
                printName(students.get(2));
                printName(students.get(3));
            }
        }).start();

        new Thread(() -> {
            synchronized (lock) {
                printName(students.get(4));
                printName(students.get(5));
            }
        }).start();
    }

    private void printName(Student student) {
        LOGGER.info(student.getName());
    }
}
