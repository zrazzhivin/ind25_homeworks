package ru.skypro.stream.service;

import ru.skypro.stream.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    Employee getEmployeeWithMinSalary(int department);

    Employee getEmployeeWithMaxSalary(int department);

    List<Employee> getAllEmployees(int department);

    Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartment();

    Employee createEmployee(String fullName, int salary, int department);
}
