public class Main {
    public static void main(String[] args) {

        // task 1
        System.out.println("Task 1");
        int var1 = 5;
        byte var2 = 3;
        short var3 = 10;
        long var4 = 1_000_000_000;

        float var5 = 36.6F;
        double var6 = 100.0;

        System.out.println("Значение переменной var1 с типом int равно " + var1);
        System.out.println("Значение переменной var2 с типом byte равно " + var2);
        System.out.println("Значение переменной var3 с типом short равно " + var3);
        System.out.println("Значение переменной var4 с типом long равно " + var4);
        System.out.println("Значение переменной var5 с типом float равно " + var5);
        System.out.println("Значение переменной var6 с типом double равно " + var6);

        // task 2
        float var7 = 27.12f;
        long var8 = 987_678_965_549L;

        float var9 = 2.786F;
        short var10 = 569;
        short var11 = -159;
        short var12 = 27897;
        byte var13 = 67;

        // task 3
        System.out.println("Task 3");
        int studentsTeacher1 = 23;
        int studentsTeacher2 = 27;
        int studentsTeacher3 = 30;
        int paperCount = 480;

        System.out.println("На каждого ученика рассчитано " + (paperCount / (studentsTeacher1 + studentsTeacher2 + studentsTeacher3)) + " листов бумаги");

        // task 4
        System.out.println("Task 4");
        int initialPerformance = 16;
        int performancePerMinute = initialPerformance / 2;

        int minutesCountIn3Days = 3 * 24 * 60;
        int performanceIn3Days = minutesCountIn3Days * performancePerMinute;

        int minutesCountInMonth = 30 * 24 * 60;
        int performanceInMonth = minutesCountInMonth * performancePerMinute;

        System.out.println("За 20 минут машина произвела " + (performancePerMinute * 20) + " штук бутылок");
        System.out.println("За сутки машина произвела " + (24 * 60 * performancePerMinute) + " штук бутылок");
        System.out.println("За 3 дня машина произвела " + performanceIn3Days + " штук бутылок");
        System.out.println("За 1 месяц машина произвела " + performanceInMonth + " штук бутылок");

        // task 5
        System.out.println("Task 5");
        int bottleColor = 120;
        int whitePerClass = 2;
        int brownPerClass = 4;

        int totalPerClass = whitePerClass + brownPerClass;
        int classesNumber = bottleColor / totalPerClass;

        System.out.println("В школе, где " + classesNumber + " классов, " +
                "нужно " + (classesNumber * whitePerClass) + " банок белой краски " +
                "и " + (classesNumber * brownPerClass) + " банок коричневой краски");

        // task 6
        System.out.println("Task 6");
        int bananasGm = 80 * 5;
        int milkGm = 200 / 100 * 105;
        int iceCreamGm = 100 * 2;
        int eggsGm = 70 * 4;

        int totalGm = bananasGm + milkGm + iceCreamGm + eggsGm;

        System.out.println("Сумма в граммах = " + totalGm);
        System.out.println("Сумма в килограммах = " + (double) totalGm / 1000);

        // task 7
        System.out.println("Task 7");
        int loseKg = 7;
        int loseGm = loseKg * 1000;
        int minGmPerDay = 250;
        int maxGmPerDay = 500;

        int averageGmPerDay = (minGmPerDay + maxGmPerDay) / 2;

        int minGmDaysCounts = loseGm / minGmPerDay;
        int maxGmDaysCounts = loseGm / maxGmPerDay;
        int averageGmDaysCounts = loseGm / averageGmPerDay;

        System.out.println("Дней при минимуме: " + minGmDaysCounts);
        System.out.println("Дней при максимуме: " + maxGmDaysCounts);
        System.out.println("Дней в среднем: " + averageGmDaysCounts);

        // task 8
        System.out.println("Task 8");
        int mashaSalary = 67760;
        int denisSalary = 83690;
        int kristinaSalary = 76230;

        int mashaSalaryPerYear = mashaSalary * 12;
        int denisSalaryPerYear = denisSalary * 12;
        int kristinaSalaryPerYear = kristinaSalary * 12;



        int increasedMashaSalary = mashaSalary + (mashaSalary * 10 / 100);
        int increasedDenisSalary = (int) (denisSalary * 1.1);
        int increasedKristinaSalary = (int) (kristinaSalary * 1.1);

        int increasedMashaSalaryPerYear = increasedMashaSalary * 12;
        int increasedDenisSalaryPerYear = increasedDenisSalary * 12;
        int increasedKristinaSalaryPerYear = increasedKristinaSalary * 12;

        System.out.println("Маша теперь получает " + increasedMashaSalary + " рублей. " +
                "Годовой доход вырос на " + (increasedMashaSalaryPerYear - mashaSalaryPerYear) + " рублей");
        System.out.println("Денис теперь получает " + increasedDenisSalary + " рублей. " +
                "Годовой доход вырос на " + (increasedDenisSalaryPerYear - denisSalaryPerYear) + " рублей");
        System.out.println("Кристина теперь получает " + increasedKristinaSalary + " рублей. " +
                "Годовой доход вырос на " + (increasedKristinaSalaryPerYear - kristinaSalaryPerYear) + " рублей");
    }
}