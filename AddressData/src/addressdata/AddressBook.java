package addressdata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddressBook {
    private List<AddressEntry> entries;
    // Constructo r initializes an empty list of AddressEntry objects
    public AddressBook() {
        entries = new ArrayList<>();
    }
    // Method to add an AddressEntry to the AddressBook
    public void addEntry(AddressEntry entry) {
        entries.add(entry);
    }
    // Method to remove an AddressEntry from the AddressBook
    public void removeEntry(AddressEntry entry) {
        entries.remove(entry);
    }
    // Method to search for AddressEntries by last name
    public List<AddressEntry> searchEntries(String lastName) {
        List<AddressEntry> searchResults = new ArrayList<>();
        
        // Iterate through the entries and add matching entries to the search results list
        for (AddressEntry entry : entries) {
            if (entry.getlastName().startsWith(lastName, 0)) {
                searchResults.add(entry);
            }
        }
        return searchResults;
    }
    // Method to retrieve all the AddressEntries in the AddressBook
    public List<AddressEntry> getAllEntries() {
        return entries;
    }
     // Method to sort the AddressEntries in the AddressBook by last name
    public void ordinationEntries() {
        Collections.sort(entries, (entry1, entry2) -> entry1.getlastName().compareToIgnoreCase(entry2.getlastName()));
    }
}