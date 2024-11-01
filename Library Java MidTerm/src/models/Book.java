// Book.java
package src.models;

public class Book extends LibraryItem {
    private String formatType; // Printed, Electronic, Audio

    public Book(int id, String title, Author author, String isbn, String publisher, int copies, String formatType) {
        super(id, title, author, isbn, publisher, copies);
        this.formatType = formatType;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + formatType + " Book";
    }
}
