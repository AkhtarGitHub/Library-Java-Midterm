// Patron.java
package src.models;

import java.util.ArrayList;

public abstract class Patron {
    protected String name;
    protected String address;
    protected String phoneNumber;
    protected ArrayList<LibraryItem> borrowedItems;

    public Patron(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.borrowedItems = new ArrayList<>();
    }

    public void borrowItem(LibraryItem item) {
        if (item.getCopiesAvailable() > 0) {
            borrowedItems.add(item);
            item.borrowItem();
            System.out.println(name + " borrowed " + item.getTitle());
        } else {
            System.out.println(item.getTitle() + " is not available.");
        }
    }

    public void returnItem(LibraryItem item) {
        if (borrowedItems.contains(item)) {
            borrowedItems.remove(item);
            item.returnItem();
            System.out.println(name + " returned " + item.getTitle());
        } else {
            System.out.println(name + " did not borrow " + item.getTitle());
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Patron: " + name + ", Phone: " + phoneNumber;
    }
}
