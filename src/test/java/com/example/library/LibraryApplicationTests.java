package com.example.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryApplicationTest {

	private Library library;
	private Book book1;
	private Book book2;

	@BeforeEach
	void setUp() {
		library = new Library();
		book1 = new Book("12345", "Effective Java", "Joshua Bloch", 2008);
		book2 = new Book("67890", "Clean Code", "Robert Martin", 2009);
		library.addBook(book1);
		library.addBook(book2);
	}

	@Test
	void testAddBook() {
		assertEquals(2, library.viewAvailableBooks().size());
	}

	@Test
	void testBorrowBook() {
		library.borrowBook("12345");
		assertTrue(library.getAllBooks().get("12345").isBorrowed());
	}

	@Test
	void testReturnBook() {
		library.borrowBook("12345");
		library.returnBook("12345");
		assertFalse(library.getAllBooks().get("12345").isBorrowed());
	}
}
