package com.example.demo.data;

import com.example.demo.entity.Book;

import java.util.List;

public class BookData {

    private List<Book> books;
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}