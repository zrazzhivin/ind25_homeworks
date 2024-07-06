package ru.skypro.testingmockito.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.skypro.testingmockito.exception.EmployeeAlreadyAddedException;
import ru.skypro.testingmockito.exception.EmployeeNotFoundException;
import ru.skypro.testingmockito.exception.EmployeeStorageIsFullException;
import ru.skypro.testingmockito.model.Employee;
import ru.skypro.testingmockito.service.impl.EmployeeServiceImpl;

public class EmployeeServiceImplTest {

    private final int EMPLOYEES_STORAGE_SIZE = 5;

    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void clear() {
        employeeService = new EmployeeServiceImpl();
    }

    @Test
    public void shouldCorrectlyAddEmployee() {
        // given
        Employee expectedEmployee = new Employee("Ivan", "Petrov", 100_000, 1);


        // when
        Employee actualEmployee = employeeService.addEmployee(
                expectedEmployee.getFirstName(),
                expectedEmployee.getLastName(),
                expectedEmployee.getSalary(),
                expectedEmployee.getDepartment()
        );

        // then
        Assertions.assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    public void shouldThrowEmployeeAlreadyAddedExceptionWhenSuchEmployeeIsAlreadyPresented() {
        // given
        employeeService.addEmployee("Ivan", "Petrov", 100_000, 1);

        // when
        // then
        Assertions.assertThrows(
                EmployeeAlreadyAddedException.class,
                () -> employeeService.addEmployee("Ivan", "Petrov", 100_000, 1)
        );
    }

    @Test
    public void shouldThrowEmployeeStorageIsFullExceptionWhenStorageIsFull() {
        // given
        for (int i = 0; i < EMPLOYEES_STORAGE_SIZE; i++) {
            employeeService.addEmployee("Ivan" + i, "Petrov", 100_000, 1);
        }

        // when
        // then
        Assertions.assertThrows(
                EmployeeStorageIsFullException.class,
                () -> employeeService.addEmployee("Ivan", "Petrov", 100_000, 1)
        );
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenThereIsNoSuchEmployeeDuringRemoving() {
        // given
        // when
        // then
        Assertions.assertThrows(
                EmployeeNotFoundException.class,
                () -> employeeService.removeEmployee("Ivan", "Petrov")
        );
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenThereIsNoSuchEmployeeDuringFinding() {
        // given
        // when
        // then
        Assertions.assertThrows(
                EmployeeNotFoundException.class,
                () -> employeeService.findEmployee("Ivan", "Petrov")
        );
    }

    @Test
    public void shouldFindEmployee() {
        // given
        Employee expectedEmployee = employeeService.addEmployee(
                "Ivan", "Petrov", 100_000, 1
        );

        // when
        Employee actualEmployee = employeeService.findEmployee(expectedEmployee.getFirstName(), expectedEmployee.getLastName());

        // then
        Assertions.assertEquals(expectedEmployee, actualEmployee);
    }
}
