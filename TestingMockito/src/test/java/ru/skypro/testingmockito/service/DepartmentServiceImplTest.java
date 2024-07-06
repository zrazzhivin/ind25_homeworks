package ru.skypro.testingmockito.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.testingmockito.model.Employee;
import ru.skypro.testingmockito.service.impl.DepartmentServiceImpl;
import ru.skypro.testingmockito.service.impl.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {

    private final List<Employee> employeeList = new ArrayList<>() {{
        add(new Employee("Ivan", "Petrov1", 100_000, 1));
        add(new Employee("Ivan", "Petrov2", 200_000, 1));
        add(new Employee("Ivan", "Petrov3", 300_000, 1));
        add(new Employee("Ivan", "Petrov4", 100_000, 2));
        add(new Employee("Ivan", "Petrov5", 100_000, 3));
    }};

    private final Map<String, Employee> employees = new HashMap<>();

    @BeforeEach
    public void initMap() {
        for (Employee employee : employeeList) {
            employees.put(employee.getFirstName() + employee.getLastName(), employee);
        }
    }

    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    public void shouldGetEmployees() {
        // given
        Integer departmentId = 1;
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employees);

        List<Employee> expectedEmployees = List.of(employeeList.get(0), employeeList.get(1), employeeList.get(2));

        // when
        List<Employee> actualEmployees = departmentService.getEmployees(departmentId);

        // then
        Assertions
                .assertThat(actualEmployees)
                .containsExactlyInAnyOrderElementsOf(expectedEmployees);
    }

    @Test
    public void shouldGetSalarySum() {
        // given
        Integer departmentId = 1;
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employees);
        Integer expectedSalarySum = employeeList.get(0).getSalary() + employeeList.get(1).getSalary() + employeeList.get(2).getSalary();

        // when
        Integer actualSalarySum = departmentService.getSalarySum(departmentId);

        // then
        Assertions
                .assertThat(actualSalarySum)
                .isEqualTo(expectedSalarySum);
    }

    @Test
    public void shouldGetSalaryMin() {
        // given
        Integer departmentId = 1;
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employees);
        Employee expectedEmployeeWithMinSalary = employeeList.get(0);

        // when
        Employee actualEmployeeWithMinSalary = departmentService.getEmployeeWithMinSalary(departmentId);

        // then
        Assertions
                .assertThat(actualEmployeeWithMinSalary)
                .isEqualTo(expectedEmployeeWithMinSalary);
    }

    @Test
    public void shouldGetSalaryMax() {
        // given
        Integer departmentId = 1;
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employees);
        Employee expectedEmployeeWithMaxSalary = employeeList.get(2);

        // when
        Employee actualEmployeeWithMaxSalary = departmentService.getEmployeeWithMaxSalary(departmentId);

        // then
        Assertions
                .assertThat(actualEmployeeWithMaxSalary)
                .isEqualTo(expectedEmployeeWithMaxSalary);
    }

    @Test
    public void shouldGetGroupedByDepartmentEmployees() {
        // given
        Map<Integer, List<Employee>> expectedGroupedEmployees = new HashMap<>() {{
            put(1, List.of(employeeList.get(0), employeeList.get(1), employeeList.get(2)));
            put(2, List.of(employeeList.get(3)));
            put(3, List.of(employeeList.get(4)));
        }};

        Mockito.when(employeeService.getAllEmployees()).thenReturn(employees);

        // when
        Map<Integer, List<Employee>> actualGroupedEmployees = departmentService.getGroupedByDepartmentEmployees();

        // then
        Assertions.assertThat(actualGroupedEmployees).isEqualTo(expectedGroupedEmployees);
    }
}
