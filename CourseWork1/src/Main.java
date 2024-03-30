public class Main {

    private final static int EMPLOYEE_NUMBER = 10;

    private static Employee[] employees = new Employee[EMPLOYEE_NUMBER];

    public static void main(String[] args) {

        employees[0] = new Employee("Иван Петров 1", 100_000, 1);
        employees[1] = new Employee("Иван Петров 2", 200_000, 1);
        employees[2] = new Employee("Иван Петров 3", 150_000, 2);
        employees[3] = new Employee("Иван Петров 4", 50_000, 2);
        employees[4] = new Employee("Иван Петров 5", 300_000, 3);
        employees[5] = new Employee("Иван Петров 6", 500_000, 3);
        employees[6] = new Employee("Иван Петров 7", 2_000_000, 4);
        employees[7] = new Employee("Иван Петров 8", 10_000, 4);
        employees[8] = new Employee("Иван Петров 9", 15_000, 5);
        employees[9] = new Employee("Иван Петров 10", 120_000, 5);

        printEmployees();

        int salarySum = getSalarySum();
        System.out.println("Сумма всех зарплат = " + salarySum);

        System.out.println("Сотрудник с минимальной зарплатой: " + getEmployeeWithMinSalary());

        System.out.println("Сотрудник с максимальной зарплатой: " + getEmployeeWithMaxSalary());

        System.out.println("Средняя зарплата: " + getAverageSalary());

        printEmployeesFullNames();

    }

    private static void printEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static int getSalarySum() {
        int sum = 0;

        for (int i = 0; i < employees.length; i++) {
            sum += employees[i].getSalary();
        }

        return sum;
    }

    private static Employee getEmployeeWithMinSalary() {
        Employee employeeWithMinSalary = employees[0];

        for (Employee employee : employees) {
            if (employee.getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employee;
            }
        }

        return employeeWithMinSalary;
    }

    private static Employee getEmployeeWithMaxSalary() {
        Employee employeeWithMaxSalary = employees[0];

        for (Employee employee : employees) {
            if (employee.getSalary() > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = employee;
            }
        }

        return employeeWithMaxSalary;
    }

    private static double getAverageSalary() {
        return (double) getSalarySum() / employees.length;
    }

    private static void printEmployeesFullNames() {
        for (Employee employee : employees) {
            System.out.println("ФИО сотрудника: " + employee.getFullName());
        }
    }
}