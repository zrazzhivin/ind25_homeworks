public class Main {
    public static void main(String[] args) {

        // task 1
        System.out.println("Task 1");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // task 2
        System.out.println("Task 2");
        for (int i = 10; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();

        // task 3
        System.out.println("Task 3");
        for (int i = 2; i < 17; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();

        // task 4
        System.out.println("Task 4");
        for (int i = 10; i >= -10; i--) {
            System.out.print(i + " ");
        }
        System.out.println();

        // task 5
        System.out.println("Task 5");
        for (int i = 1904; i <= 2096; i += 4) {
            System.out.println(i + " год является високосным");
        }
        System.out.println();

        // task 6
        System.out.println("Task 6");
        for (int i = 7; i <= 98; i += 7) {
            System.out.print(i + " ");
        }
        System.out.println();

        // task 7
        System.out.println("Task 7");
        for (int i = 1; i <= 512; i *= 2) {
            System.out.print(i + " ");
        }
        System.out.println();

        // task 8
        System.out.println("Task 8");
        int money = 0;
        int moneyPerMonth = 29000;
        for (int i = 1; i <= 12; i++) {
            money += moneyPerMonth;
            System.out.println("Месяц " + i + ", сумма накоплений равна " + money + " рублей");
        }

        // task 9
        System.out.println("Task 9");
        money = 0;
        for (int i = 1; i <= 12; i++) {
            money += moneyPerMonth;
            moneyPerMonth *= 1.01;
            System.out.println("Месяц " + i + ", сумма накоплений равна " + money + " рублей");
        }

        // task 10
        System.out.println("Task 10");
        for (int i = 1; i <= 10; i++) {
            System.out.println("2 * " + i + " = " + (2 * i));
        }
    }
}