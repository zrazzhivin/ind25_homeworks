package ru.skypro.stream.service.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ru.skypro.stream.model.Employee;
import ru.skypro.stream.service.EmployeeService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees = new HashMap<>();

    @PostConstruct
    public void init() {
        employees.put("employee1", new Employee("employee1", 100_000, 1));
        employees.put("employee2", new Employee("employee2", 200_000, 1));
        employees.put("employee3", new Employee("employee3", 300_000, 1));
        employees.put("employee4", new Employee("employee4", 400_000, 2));
        employees.put("employee5", new Employee("employee5", 500_000, 2));
        employees.put("employee6", new Employee("employee6", 150_000, 3));
        employees.put("employee7", new Employee("employee7", 240_000, 3));
    }

    @Override
    public Employee getEmployeeWithMinSalary(int department) {
        return employees.values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);

    }

    @Override
    public Employee getEmployeeWithMaxSalary(int department) {
        return employees.values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees(int department) {
        return employees.values()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .toList();
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDepartment() {

//        Collection<Employee> values = employees.values();
//        Map<Integer, List<Employee>> employeeMap = new HashMap<>();
//
//        for (Employee employee : values) {
//
//            if (!employeeMap.containsKey(employee.getDepartment())) {
//                employeeMap.put(employee.getDepartment(), new ArrayList<>());
//            }
//
//            employeeMap.get(employee.getDepartment()).add(employee);
//        }
//
//        return employeeMap;

        return employees.values()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    @Override
    public Employee createEmployee(String fullName, int salary, int department) {
        Employee employee = new Employee(fullName, salary, department);
        employees.put(employee.getFullName(), employee);
        return employees.get(employee.getFullName());
    }
}
