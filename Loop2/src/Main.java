public class Main {
    public static void main(String[] args) {

        // task1
        System.out.println("Task 1");

        int money = 0;
        int moneyPerMonth = 15000;
        int totalMoney = 2459000;
        int month = 1;

        while (money <= totalMoney) {
            money += moneyPerMonth;
            money *= 1.01;
            System.out.println("Месяц " + month + ", сумма накоплений равна " + money + " рублей");
            ++month;
        }
        System.out.println();

        // task 2
        System.out.println("Task 2");

        int i = 1;
        while (i <= 10) {
            System.out.print(i + " ");
            ++i;
        }
        System.out.println();
        for (i = 10; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();

        // task 3
        System.out.println("Task 3");
        int population = 12_000_000;
        int birthRate = 17;
        int deathRate = 8;

        for (int year = 1; year <= 10; year++) {

            int diff = population / 1000 * birthRate - population / 1000 * deathRate;
            //int diff = (birthRate - deathRate) * population / 1000;
            population = population + diff;

            System.out.println("Год " + year + ", численность составляет " + population);
        }
        System.out.println();

        // task 4
        System.out.println("Task 4");
        int balance = 15000;
        totalMoney = 12_000_000;
        month = 1;

        while (balance <= totalMoney) {
            balance *= 1.07;
            System.out.println("Месяц " + month + ", сумма накоплений = " + balance);
            ++month;
        }
        System.out.println();

        // task 5
        System.out.println("Task 5");
        balance = 15000;
        totalMoney = 12_000_000;
        month = 1;

        while (balance <= totalMoney) {
            balance *= 1.07;
            if (month % 6 == 0) {
                System.out.println("Месяц " + month + ", сумма накоплений = " + balance);
            }
            ++month;
        }
        System.out.println();

        // task 6
        System.out.println("Task 6");
        balance = 15000;
        for (int j = 1; j < 9 * 12; j++) {
            balance *= 1.07;
            if (j % 6 == 0) {
                System.out.println("Месяц " + j + ", сумма накоплений = " + balance);
            }
        }
        System.out.println();

        // task 7
        System.out.println("Task 7");
        for (int friday = 3; friday <= 31; friday += 7) {
            System.out.println("Сегодня пятница, " + friday + "-е число. Необходимо подготовить отчет");
        }

        // task 8
        System.out.println("Task 8");
        int currentYear = 2024;
        int startYear = currentYear - 200;
        int finishYear = currentYear + 100;

        for (int year = startYear; year <= finishYear; ++year) {
            if (year % 79 == 0) {
                System.out.println(year);
            }
        }
    }
}