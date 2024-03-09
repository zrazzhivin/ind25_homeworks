public class Main {
    public static void main(String[] args) {
        // task1
        System.out.println("Task 1");

        int[] array = {100000, 150000, 20000, 500000, 250_000};

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println("Сумма трат за месяц составила " + sum + " рублей");

        // task 2
        System.out.println("Task 2");

        int min = array[0];
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }

        System.out.println("Минимальная сумма трат за неделю составила " + min +" рублей. " +
                "Максимальная сумма трат за неделю составила " + max + " рублей");

        // task 3
        System.out.println("Task 3");

        double average = (double) sum / array.length;
        System.out.println("Средняя сумма трат за месяц составила " + average + " рублей");

        // task 4
        System.out.println("Task 4");

        char[] reverseFullName = { 'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};

        for (int i = 0; i < reverseFullName.length / 2; i++) {
            char temp = reverseFullName[i];
            reverseFullName[i] = reverseFullName[reverseFullName.length - i - 1];
            reverseFullName[reverseFullName.length - i - 1] = temp;
        }

        for (int i = 0; i < reverseFullName.length; i++) {
            System.out.print(reverseFullName[i]);
        }
    }
}