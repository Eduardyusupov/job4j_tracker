package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book firstBook = new Book(100, "HowToDrive");
        Book secondBook = new Book(320, null);
        Book thirdBook = new Book(240, "How to cook");
        Book fourthBook = new Book(100000, "War and peace");
        Book[] books = new Book[4];
        books[0] = firstBook;
        books[1] = secondBook;
        books[2] = thirdBook;
        books[3] = fourthBook;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println("Number of pages = " + book.getPageNumbers() + " Book name = " + book.getName());
        }
        books[0] = fourthBook;
        books[3] = firstBook;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println("Number of pages = " + book.getPageNumbers() + " Book name = " + book.getName());
        }
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if ("Clean Code".equals(book.getName())) {
                System.out.println("Number of pages = " + book.getPageNumbers() + " Book name = " + book.getName());
            }
        }
    }
}
