package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.List;

public interface FacultyService {

    Faculty create(Faculty student);

    Faculty read(Long id);

    Faculty update(Long id, Faculty faculty);

    Faculty delete(Long id);

    List<Faculty> filterByColor(String color);

    List<Faculty> findAllByNameIgnoreCaseOrColorIgnoreCase(String name, String color);

    List<Student> getStudents(Long facultyId);

    String getLongestName();
}
