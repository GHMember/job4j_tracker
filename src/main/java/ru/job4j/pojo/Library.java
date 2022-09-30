package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        Book book4 = new Book();
        Book[] books = {book1, book2, book3, book4};
        book1.setBookTitle("Clean code");
        book1.setPageCount(431);
        book2.setBookTitle("White book");
        book2.setPageCount(100);
        book3.setBookTitle("Black book");
        book3.setPageCount(200);
        book4.setBookTitle("Just book");
        book4.setPageCount(300);
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
            if (book.getBookTitle().equals("Clean code")) {
                System.out.println("Title: " + book.getBookTitle() + ", pages: " + book.getPageCount());
            }
        }
    }
}