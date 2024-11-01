package src;


import src.models.Author;
import src.models.Book;
import src.models.Employee;
import src.models.Periodical;
import src.models.Student;
import src.services.Library;

public class Demo {
    public static void main(String[] args) {
        Library library = new Library();

        // Add authors
        Author author1 = new Author("J.K. Rowling", "1965-07-31");
        Author author2 = new Author("George Orwell", "1903-06-25");

        // Add items
        Book book1 = new Book(1, "Harry Potter", author1, "12345", "Bloomsbury", 5, "Printed");
        Periodical periodical1 = new Periodical(2, "NatGeo", author2, "67890", "NatGeo", 3, true);

        library.addItem(book1);
        library.addItem(periodical1);

        // Add patrons
        Student student = new Student("Alice", "123 Main St", "555-1234");
        Employee employee = new Employee("Bob", "456 Elm St", "555-5678");

        library.addPatron(student);
        library.addPatron(employee);

        // Borrow and return demonstration
        student.borrowItem(book1);
        student.returnItem(book1);
    }
}
