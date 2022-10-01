package ru.job4j.pojo;

public class Book {
    private String bookTitle;
    private int pageCount;

    public Book(String bookTitle, int pageCount) {
        this.bookTitle = bookTitle;
        this.pageCount = pageCount;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public int getPageCount() {
        return pageCount;
    }
}