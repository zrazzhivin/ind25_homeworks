package ru.hogwarts.school.service.impl;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.service.StudentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

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
}
