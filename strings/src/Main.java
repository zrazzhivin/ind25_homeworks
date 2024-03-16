public class Main {
    public static void main(String[] args) {

        // task 1
        String firstName = "Ivan";
        String middleName = "Ivanovich";
        String lastName = "Ivanov";

        String fullName = lastName + " " + firstName + " " + middleName;

        System.out.println("Ф. И. О. сотрудника — " + fullName);

        // task 2
        String fullNameUpperCase = fullName.toUpperCase();
        System.out.println("Данные Ф. И. О. сотрудника для заполнения отчета — " + fullNameUpperCase);

        // task 3
        fullName = "Иванов Семён Семёнович";
        String replacedFullName = fullName.replace("ё", "е");
        System.out.println("Данные Ф. И. О. сотрудника — " + replacedFullName);

    }
}