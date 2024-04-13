import javax.naming.InsufficientResourcesException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // task 5
        System.out.println("Task 5");
        int value = 33;
        System.out.println("Value before: " + value);
        changeValue(value);
        System.out.println("Value after: " + value);

        // task 6
        System.out.println("Task 6");
        Integer value1 = 33;
        System.out.println("Value before: " + value1);
        changeValue(value1);
        System.out.println("Value after: " + value1);

        // task 7
        System.out.println("Task 7");
        Integer[] value2 = new Integer[] {3, 4};
        System.out.println("Value before: " + Arrays.toString(value2));
        changeValue(value2);
        System.out.println("Value after: " + Arrays.toString(value2));

        // task 8
        System.out.println("Task 8");
        Integer[] value3 = new Integer[] {3, 4};
        System.out.println("Value before: " + Arrays.toString(value3));
        changeValue1(value3);
        System.out.println("Value after: " + Arrays.toString(value3));

        // task 9
        System.out.println("Task 9");
        Person person = new Person("Lyapis", "Trubetskoy");
        System.out.println("Value before: " + person);
        changeValue(person);
        System.out.println("Value after: " + person);

        // task 10
        System.out.println("Task 10");
        Person person1 = new Person("Lyapis", "Trubetskoy");
        System.out.println("Value before: " + person1);
        changeValue1(person1);
        System.out.println("Value after: " + person1);
    }

    public static void changeValue(int value) {
        System.out.println("from changeValue before: " + value);
        value = 22;
        System.out.println("from changeValue after: " + value);
    }

    public static void changeValue(Integer value) {
        //value = Integer.valueOf(22);
        System.out.println("from changeValue before: " + value);
        value = 22;
        System.out.println("from changeValue after: " + value);
    }

    public static void changeValue(Integer[] value) {
        System.out.println("from changeValue before: " + Arrays.toString(value));
        value = new Integer[] {1, 2};
        System.out.println("from changeValue after: " + Arrays.toString(value));
    }

    public static void changeValue1(Integer[] value) {
        System.out.println("from changeValue before: " + Arrays.toString(value));
        value[0] = 99;
        System.out.println("from changeValue after: " + Arrays.toString(value));
    }

    public static void changeValue(Person person) {
        System.out.println("from changeValue before: " + person);
        person = new Person("Ilya", "Lagutenko");
        System.out.println("from changeValue after: " + person);
    }

    public static void changeValue1(Person person) {
        System.out.println("from changeValue before: " + person);
        person.setName("Ilya");
        person.setSurname("Lagutenko");
        System.out.println("from changeValue after: " + person);
    }
}