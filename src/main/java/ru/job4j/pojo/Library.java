package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 431);
        Book book2 = new Book("White book", 100);
        Book book3 = new Book("Black book", 200);
        Book book4 = new Book("Another book", 300);
        Book[] books = {book1, book2, book3, book4};
        for (Book book : books) {
            System.out.println("Title: " + book.getBookTitle() + ", pages: " + book.getPageCount());
        }
        System.out.println();
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book book : books) {
            System.out.println("Title: " + book.getBookTitle() + ", pages: " + book.getPageCount());
        }
        System.out.println();
        for (Book book : books) {
            if ("Clean code".equals(book.getBookTitle())) {
                System.out.println("Title: " + book.getBookTitle() + ", pages: " + book.getPageCount());
            }
        }
    }
}