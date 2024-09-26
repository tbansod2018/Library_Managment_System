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
		book1 = new Book("11111", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1997);
		book2 = new Book("22222", "Harry Potter and the Chamber of Secrets", "J.K. Rowling", 1998);
		library.addBook(book1);
		library.addBook(book2);
	}

	@Test
	void testAddBook() {
		assertEquals(2, library.viewAvailableBooks().size());
	}

	@Test
	void testBorrowBook() {
		library.borrowBook("11111");
		assertTrue(library.getAllBooks().get("11111").isBorrowed());
	}

	@Test
	void testReturnBook() {
		library.borrowBook("11111");
		library.returnBook("11111");
		assertFalse(library.getAllBooks().get("11111").isBorrowed());
	}

	@Test
	void testBorrowNonExistentBook() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			library.borrowBook("99999"); // Non-existent ISBN
		});

		String expectedMessage = "Book is not available for borrowing.";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void testReturnNonExistentBook() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			library.returnBook("99999"); // Non-existent ISBN
		});

		String expectedMessage = "Book was not borrowed or doesn't exist.";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void testReturnBookNotBorrowed() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			library.returnBook("11111"); // Book was never borrowed
		});

		String expectedMessage = "Book was not borrowed or doesn't exist.";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
}
