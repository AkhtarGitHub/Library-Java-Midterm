// Periodical.java
package src.models;

public class Periodical extends LibraryItem {
    private boolean isPrinted;

    public Periodical(int id, String title, Author author, String isbn, String publisher, int copies, boolean isPrinted) {
        super(id, title, author, isbn, publisher, copies);
        this.isPrinted = isPrinted;
    }

    @Override
    public String toString() {
        String type = isPrinted ? "Printed" : "Electronic";
        return super.toString() + " - " + type + " Periodical";
    }
}
