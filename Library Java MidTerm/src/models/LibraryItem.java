// LibraryItem.java
package src.models;

public abstract class LibraryItem {
    protected int id;
    protected String title;
    protected Author author;
    protected String isbn;
    protected String publisher;
    protected int copiesAvailable;

    public LibraryItem(int id, String title, Author author, String isbn, String publisher, int copies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.copiesAvailable = copies;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void borrowItem() {
        if (copiesAvailable > 0) {
            copiesAvailable--;
        } else {
            System.out.println("Item is currently not available.");
        }
    }

    public void returnItem() {
        copiesAvailable++;
    }

    @Override
    public String toString() {
        return title + " by " + author.getName() + " (ISBN: " + isbn + ")";
    }
}
