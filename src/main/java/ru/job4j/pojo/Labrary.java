package ru.job4j.pojo;

public class Labrary {
    public static void main(String[] args) {
        Book[] books = {
                new Book("Peter Pen", (short)100),
                new Book("Harry Potter",(short)800),
                new Book("Master of Rings", (short)2500),
                new Book("Clean code", (short)150)
        };
        for (int i = 0; i < books.length; i++) {
            System.out.printf("Book \"%s\", pages %d\n", books[i].getName(), books[i].getPageNumber());
        }
        Book temp = books[3];
        books[3] = books[0];
        books[0] = temp;
        for (int i = 0; i < books.length; i++) {
            System.out.printf("Book \"%s\", pages %d\n", books[i].getName(), books[i].getPageNumber());
        }
        for (int i = 0; i < books.length; i++) {
            if (books[i].getName().equals("Clean code")) {
                System.out.printf("Book \"%s\", pages %d\n", books[i].getName(), books[i].getPageNumber());
            }
        }
    }
}
