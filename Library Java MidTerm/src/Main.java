package src;


import src.models.Author;
import src.models.Book;
import src.models.Employee;
import src.models.LibraryItem;
import src.models.Patron;
import src.models.Periodical;
import src.models.Student;
import src.services.Library;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();  // Create a new library instance

        loadSampleData(library);  // Load sample data into the library

        System.out.println("\n--- Library Management System ---");
        System.out.println(library);  // Display the summary of library content

        // Test searching for an item by title
        System.out.println("\n--- Searching for 'The Hobbit' ---");
        LibraryItem searchedItem = library.searchItemByTitle("The Hobbit");
        if (searchedItem != null) {
            System.out.println("Item found: " + searchedItem);
        } else {
            System.out.println("Item not found.");
        }

        // Borrowing books and periodicals
        Patron alice = library.getPatronByName("Alice");
        Patron bob = library.getPatronByName("Bob");

        if (alice != null) {
            System.out.println("\n--- Alice is borrowing 'Harry Potter' ---");
            alice.borrowItem(library.searchItemByTitle("Harry Potter"));
        }

        if (bob != null) {
            System.out.println("\n--- Bob is borrowing 'Time Magazine' ---");
            bob.borrowItem(library.searchItemByTitle("Time Magazine"));
        }

        // Returning borrowed items
        if (alice != null) {
            System.out.println("\n--- Alice is returning 'Harry Potter' ---");
            alice.returnItem(library.searchItemByTitle("Harry Potter"));
        }

        // List all patrons and their borrowed items
        System.out.println("\n--- Listing all patrons and borrowed items ---");
        for (Patron patron : library.getAllPatrons()) {
            System.out.println(patron);
        }
    }

    /**
     * Loads sample data into the library for testing purposes.
     *
     * @param library the library instance to populate with data
     */
    private static void loadSampleData(Library library) {
        // Add authors
        Author jkRowling = new Author("J.K. Rowling", "1965-07-31");
        Author georgeOrwell = new Author("George Orwell", "1903-06-25");
        Author jrrTolkien = new Author("J.R.R. Tolkien", "1892-01-03");

        // Add books (5 records)
        Book book1 = new Book(1, "Harry Potter", jkRowling, "12345", "Bloomsbury", 5, "Printed");
        Book book2 = new Book(2, "1984", georgeOrwell, "67890", "Secker & Warburg", 3, "Electronic");
        Book book3 = new Book(3, "Animal Farm", georgeOrwell, "11111", "Penguin", 2, "Audio");
        Book book4 = new Book(4, "The Hobbit", jrrTolkien, "22222", "HarperCollins", 4, "Printed");
        Book book5 = new Book(5, "The Lord of the Rings", jrrTolkien, "33333", "Allen & Unwin", 2, "Electronic");

        // Add periodicals (3 records)
        Periodical periodical1 = new Periodical(6, "National Geographic", georgeOrwell, "44444", "NatGeo", 7, true);
        Periodical periodical2 = new Periodical(7, "Time Magazine", jkRowling, "55555", "Time Inc.", 4, false);
        Periodical periodical3 = new Periodical(8, "Science Daily", jrrTolkien, "66666", "Science Org", 5, true);

        // Add books and periodicals to the library
        library.addItem(book1);
        library.addItem(book2);
        library.addItem(book3);
        library.addItem(book4);
        library.addItem(book5);
        library.addItem(periodical1);
        library.addItem(periodical2);
        library.addItem(periodical3);

        // Add patrons (3 records)
        Student alice = new Student("Alice", "123 Main St", "555-1234");
        Employee bob = new Employee("Bob", "456 Elm St", "555-5678");
        Student charlie = new Student("Charlie", "789 Pine St", "555-6789");

        // Add patrons to the library
        library.addPatron(alice);
        library.addPatron(bob);
        library.addPatron(charlie);

        // Borrow items to demonstrate borrowing functionality
        alice.borrowItem(book1);  // Alice borrows "Harry Potter"
        bob.borrowItem(book2);    // Bob borrows "1984"
        charlie.borrowItem(periodical1);  // Charlie borrows "National Geographic"

        System.out.println("\nSample data loaded successfully!");
    }
}
