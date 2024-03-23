public class Main {
    public static void main(String[] args) {
        Author author1 = new Author("Лев", "Толстой");
        Book book1 = new Book("Война и Мир", 1866, author1);

        System.out.println("Год публикации: " + book1.getPublicationYear());

        book1.setPublicationYear(1867);
        System.out.println("Год публикации: " + book1.getPublicationYear());
        System.out.println(book1.getAuthor());

        System.out.println("Книга: " + book1);


        Author author2 = new Author("Лев", "Толстой");

        if (author1.equals(author2)) {
            System.out.println("Авторы равны!");
        } else {
            System.out.println("Авторы не равны!");
        }

        System.out.println("Хэш код автора: " + author1.hashCode());
    }
}