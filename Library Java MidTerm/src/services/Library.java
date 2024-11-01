// Library.java
package src.services;

import java.util.ArrayList;

import src.models.LibraryItem;
import src.models.Patron;

public class Library {
    private ArrayList<LibraryItem> items;
    private ArrayList<Patron> patrons;

    public Library() {
        items = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    public LibraryItem searchItemByTitle(String title) {
        for (LibraryItem item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        return null;
    }

    public Patron getPatronByName(String name) {
        for (Patron patron : patrons) {
            if (patron.getName().equalsIgnoreCase(name)) {
                return patron;
            }
        }
        return null;
    }
    
    public ArrayList<Patron> getAllPatrons() {
        return patrons;
    }

}
