package other;

import java.util.*;

public class BookLinkedList {

	public static void main(String[] args) {
		//Creating linked list/variables
		LinkedList<String> books = new LinkedList<String>();
		boolean run = true;
		Scanner console = new Scanner(System.in);
		String menu = "";
		String newBook = "";
		
		//Add starting books
		books.add("To Kill A Mockingbird");
		books.add("The Great Gatsby");
		books.add("Lord of the Flies");
		books.add("The Catcher in the Rye");
		books.add("The Scarlet Letter");
		books.add("A Tale of Two Cities");

		// Main menu
		while (run) {
			System.out.println("*** BOOK LIST ***");
			System.out.println("(1) Display your books list");
			System.out.println("(2) Add new book to top of list");
			System.out.println("(3) Add new book to bottom of list");
			System.out.println("(4) Insert new book to list index");
			System.out.println("(5) Remove first book from list");
			System.out.println("(6) Remove last book from list");
			System.out.println("(7) Remove book by list index");
			System.out.println("(8) Exit program");
			System.out.print("Select option: ");
			menu = console.nextLine();
			// Check book list
			if (menu.equals("1")) {
				System.out.println();
				System.out.println("YOUR BOOK LIST:");
				for(int x = 1; x < books.size() + 1; x++) {
					System.out.println(x + ": " + books.get(x - 1));
				}
			}
			// Add book to top
			else if (menu.equals("2")) {
				System.out.print("Enter title of book: ");
				newBook = console.nextLine();
				books.addFirst(newBook);
				System.out.println("Added: " + newBook);
			}
			// Add book to bottom
			else if (menu.equals("3")) {
				System.out.print("Enter title of book: ");
				newBook = console.nextLine();
				books.add(newBook);
				System.out.println("Added: " + newBook);
			}
			// Insert new book to index
			else if (menu.equals("4")) {
				System.out.println();
				System.out.println("YOUR BOOK LIST:");
				for(int x = 1; x < books.size() + 1; x++) {
					System.out.println(x + ": " + books.get(x - 1));
				}
				System.out.print("Insert new book to which index? ");
				while (!console.hasNextInt()) {
					System.out.println(" *** ERROR *** ");
					System.out.println("Please enter a number.");
					console.next();
					System.out.print("Insert new book to which index? ");
				}
				int index = console.nextInt();
				if(index < 0 || index > books.size()) {
					System.out.println(" *** ERROR *** ");
					System.out.println("Invalid index. Try again.");
					console.nextLine();
				}
				else {
					console.nextLine();
					System.out.print("Enter title of book: ");
					newBook = console.nextLine();
					books.add(index - 1, newBook);
					System.out.println("Added: " + newBook);
				}
			}
			// Remove first book
			else if (menu.equals("5")) {
				if(books.size() > 0) {
					System.out.println("Removed: " + books.getFirst());
					books.removeFirst();
				}
				else {
					System.out.println("There are no books to remove!");
				}
			}
			// Remove last book
			else if (menu.equals("6")) {
				if(books.size() > 0) {
					System.out.println("Removed: " + books.getLast());
					books.removeLast();
				}
				else {
					System.out.println("There are no books to remove!");
				}
			}
			// Remove book by index
			else if (menu.equals("7")) {
				if(books.size() > 0) {
					System.out.println();
					System.out.println("YOUR BOOK LIST:");
					for(int x = 1; x < books.size() + 1; x++) {
						System.out.println(x + ": " + books.get(x - 1));
					}
					System.out.print("Remove which book? ");
					// Handle InputMismatchException and prompt again
					while (!console.hasNextInt()) {
						System.out.println(" *** ERROR *** ");
						System.out.println("Please enter a number.");
						console.next();
						System.out.print("Remove which book? ");
					}
					int index = console.nextInt();
					if(index < 0 || index > books.size()) {
						System.out.println(" *** ERROR *** ");
						System.out.println("Invalid index. Try again.");
					}
					else {
						System.out.println("Removed: " + books.get(index - 1));
						books.remove(index - 1);
					}
					console.nextLine();
				}
				else {
					System.out.println("There are no books to remove!");
				}
			}
			// Exit program
			else if (menu.equals("8")) {
				// Set flag, close Scanner
				run = false;
				console.close();
			}
			// Handle InputMismatchException
			else {
				System.out.println(" *** ERROR ***");
				System.out.println("Invalid option.");
			}
			// Formatting
			System.out.println();
		}
		// Exit main
		System.out.println("*** SYSTEM ***");
		System.out.println("Program finished.");
	}

}
