// Author.java
package src.models;

import java.util.ArrayList;

public class Author {
    private String name;
    private String dateOfBirth;
    private ArrayList<LibraryItem> itemsWritten;

    public Author(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.itemsWritten = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        itemsWritten.add(item);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Author: " + name + ", DOB: " + dateOfBirth;
    }
}


