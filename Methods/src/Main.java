import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        isLeapYear(2000);
        isLeapYear(2100);
        isLeapYear(2024);

        System.out.println(checkOS(0, 2000));
        System.out.println(checkOS(1, 2024));

        int distance = calculateTime(50);
        System.out.println("Потребуется дней для доставки: " + distance);
        System.out.println("Потребуется дней для доставки: " + calculateTime(1000));

    }

    public static void isLeapYear(int year) {
        if (year >= 1584 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
            System.out.println(year + " - год високосный");
        } else {
            System.out.println(year + " - год не високосный");
        }
    }

    public static String checkOS(int os, int clientDeviceYear) {
        int currentYear = LocalDate.now().getYear();

        if (os == 0 && clientDeviceYear < currentYear) {
            return "Облегченный iOS";
        } else if (os == 0 && clientDeviceYear >= currentYear) {
            return "Обычный iOS";
        } else if (os == 1 && clientDeviceYear < currentYear) {
            return "Облегченный Android";
        } else if (os == 1 && clientDeviceYear >= currentYear) {
            return "Обычный Anrdoid";
        }

        return "Неверные данные!";
    }

    public static int calculateTime(int distance) {
        if (distance <= 20) {
            return 1;
        } else if (distance > 20 && distance <= 60) {
            return 2;
        } else if (distance > 60 && distance <= 100) {
            return 3;
        }

        return -1;
    }
}