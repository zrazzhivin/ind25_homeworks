package ru.skypro.stream.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Employee {

    private final String fullName;
    private int salary;
    private int department;

    private final int id;

    private static int counter;

    public Employee(String fullName, int salary, int department) {
        this.fullName = StringUtils.capitalize(fullName.toLowerCase());
        this.salary = salary;
        this.department = department;
        id = ++counter;
    }

    public String getFullName() {
        return fullName;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && department == employee.department && id == employee.id && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, salary, department, id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                ", id=" + id +
                '}';
    }
}
