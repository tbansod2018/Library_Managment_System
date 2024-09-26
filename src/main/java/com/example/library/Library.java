package com.example.library;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Library {
    private final Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public void borrowBook(String isbn) {
        Book book = books.get(isbn);
        if (book != null && !book.isBorrowed()) {
            book.setBorrowed(true);
        } else {
            throw new IllegalArgumentException("Book is not available for borrowing.");
        }
    }

    public void returnBook(String isbn) {
        Book book = books.get(isbn);
        if (book != null && book.isBorrowed()) {
            book.setBorrowed(false);
        } else {
            throw new IllegalArgumentException("Book was not borrowed or doesn't exist.");
        }
    }

    public List<Book> viewAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books.values()) {
            if (!book.isBorrowed()) {
                availableBooks.add(book);
            }
        }
        if (availableBooks.isEmpty()) {
            System.out.println("No available books.");
        } else {
            System.out.println("Available Books:");
            for (Book book : availableBooks) {
                System.out.println(book);
            }
        }

        return availableBooks;
    }

    public Map<String, Book> getAllBooks() {
        return books;
    }
}
