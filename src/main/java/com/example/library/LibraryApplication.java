package com.example.library;
import java.util.Scanner;

public class LibraryApplication {

	public static void main(String[] args) {
		Library library = new Library();
		Scanner scanner = new Scanner(System.in);
		boolean running = true;

		while (running) {
			System.out.println("\nLibrary Management System");
			System.out.println("1. Add Book");
			System.out.println("2. Borrow Book");
			System.out.println("3. Return Book");
			System.out.println("4. View Available Books");
			System.out.println("5. Exit");
			System.out.print("Choose an option: ");
			int option = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character

			switch (option) {
				case 1:
					System.out.print("Enter ISBN: ");
					String isbn = scanner.nextLine();
					System.out.print("Enter Title: ");
					String title = scanner.nextLine();
					System.out.print("Enter Author: ");
					String author = scanner.nextLine();
					System.out.print("Enter Publication Year: ");
					int year = scanner.nextInt();
					library.addBook(new Book(isbn, title, author, year));
					System.out.println("Book added!");
					break;

				case 2:
					System.out.print("Enter ISBN to borrow: ");
					isbn = scanner.nextLine();
					try {
						library.borrowBook(isbn);
						System.out.println("Book borrowed!");
					} catch (IllegalArgumentException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 3:
					System.out.print("Enter ISBN to return: ");
					isbn = scanner.nextLine();
					try {
						library.returnBook(isbn);
						System.out.println("Book returned!");
					} catch (IllegalArgumentException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 4:
					System.out.println("Available books:");
					library.viewAvailableBooks();
					break;

				case 5:
					running = false;
					System.out.println("Exiting the system.");
					break;

				default:
					System.out.println("Invalid option. Please try again.");
			}
		}
		scanner.close();
	}

}
