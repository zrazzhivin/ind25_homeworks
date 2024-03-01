public class Main {
    public static void main(String[] args) {

        // task 1
        System.out.println("Task 1");
        int age = 25;
        if (age >= 18) {
            System.out.println("Если возраст человека равен " + age + ", то он совершеннолетний");
        } else {
            System.out.println("Если возраст человека равен " + age + ", то он несовершеннолетний");
        }

        // task 2
        System.out.println("Task 2");
        int temperature = -10;
        if (temperature < 5) {
            System.out.println("На улице холодно, нужно надеть шапку");
        } else {
            System.out.println("Сегодня тепло, можно идти без шапки");
        }

        // task 3
        System.out.println("Task 3");
        int speed = 100;
        if (speed > 60) {
            System.out.println("Если скорость " + speed + ", то придется заплатить штраф");
        } else {
            System.out.println("Если скорость " + speed + ", то можно ездить спокойно");
        }

        // task 4
        System.out.println("Task 4");
        age = 35;
        if (age >= 2 && age <= 6) {
            System.out.println("Человеку " + age + " лет, нужно ходить в детский сад");
        }
        if (age >= 7 && age <= 17) {
            System.out.println("Человеку " + age + " лет, нужно ходить в школу");
        }
        if (age >= 18 && age <= 24) {
            System.out.println("Человеку " + age + " лет, нужно ходить в университет");
        }
        if (age > 24) {
            System.out.println("Человеку " + age + " лет, нужно ходить на работу");
        }

        // task 5
        System.out.println("Task 5");

        age = 10;

        if (age < 5) {
            System.out.println("Если ребенку " + age + " лет, то ему нельзя кататься на аттракционе");
        }
        if (age > 5 && age < 14) {
            System.out.println("Если ребенку " + age + " лет, то ему можно кататься на аттракционе (со взрослым)");
        }
        if (age >= 14) {
            System.out.println("Если ребенку " + age + " лет, то ему можно кататься на аттракционе");
        }

        // task 6
        System.out.println("Task 6");
        int capacity = 102;
        int seatPlaces = 60;

        int people = 70;

        if (people >= capacity) {
            System.out.println("В вагоне нет мест");
        }
        if (people < capacity && people >= seatPlaces) {
            System.out.println("Остались только стоячие места");
        }
        if (people < seatPlaces) {
            System.out.println("Остались сидячие места");
        }

        // task 7
        System.out.println("Task 7");

        int one = 5;
        int two = 15;
        int three = 15;

        // solution 1
        if (one > two && one > three) {
            System.out.println(one);
        }
        if (two > one && two > three) {
            System.out.println(two);
        }
        if (three > one && three > two) {
            System.out.println(three);
        }

        // solution 2
        if (one >= two && one >= three) {
            System.out.println(one);
        } else if (two >= three) {
            System.out.println(two);
        } else {
            System.out.println(three);
        }
    }
}