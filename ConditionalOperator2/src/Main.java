public class Main {
    public static void main(String[] args) {
        // task 1
        System.out.println("Task 1");

        int os = 0;
        if (os == 0) {
            System.out.println("Приложения для iOS");
        } else if (os == 1) {
            System.out.println("Приложения для Android");
        } else {
            System.out.println("Неверные данные!");
        }

        // task 2
        System.out.println("Task 1");

        os = 0;
        int clientDeviceYear = 2010;

        // solution 1
        if (os == 0 && clientDeviceYear < 2015) {
            System.out.println("Облегченный iOS");
        } else if (os == 0 && clientDeviceYear >= 2015) {
            System.out.println("Обычный iOS");
        } else if (os == 1 && clientDeviceYear < 2015) {
            System.out.println("Облегченный Android");
        } else if (os == 1 && clientDeviceYear >= 2015) {
            System.out.println("Обычный Anrdoid");
        }

        // solution 2
        if (os == 0) {
            if (clientDeviceYear < 2015) {
                System.out.println("Облегченный iOS");
            } else {
                System.out.println("Обычный iOS");
            }
        } else if (os == 1) {
            if (clientDeviceYear < 2015) {
                System.out.println("Облегченный Android");
            } else {
                System.out.println("Обычный Android");
            }
        } else {
            System.out.println("Неверные данные!");
        }

        // task 3
        System.out.println("Task 3");

        int year = 1900;

        if (year >= 1584 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
            System.out.println("Год високосный");
        } else {
            System.out.println("Год не високосный");
        }

        // task 4
        System.out.println("Task 4");

        int deliveryDistance = 30;
        int days;
        if (deliveryDistance <= 20) {
            days = 1;
        } else if (deliveryDistance > 20 && deliveryDistance <= 60) {
            days = 2;
        } else if (deliveryDistance > 60 && deliveryDistance <= 100) {
            days = 3;
        } else {
            days = -1;
        }
        System.out.println("Потребуется дней: " + days);

        // task 5
        System.out.println("Task 5");

        int monthNumber = 15;

        switch (monthNumber) {
            case 12:
            case 1:
            case 2:
                System.out.println("Зима");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Весна");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Лето");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Осень");
                break;
            default:
                System.out.println("Неверный месяц!");
        }
    }
}