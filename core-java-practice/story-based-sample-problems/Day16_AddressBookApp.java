import java.util.*;

public class Day16_AddressBookApp {
    static class Contact implements Comparable<Contact> {
        String name, phone, email;
        public Contact(String name, String phone, String email) {
            this.name = name; this.phone = phone; this.email = email;
        }
        @Override
        public int compareTo(Contact other) { return this.name.compareToIgnoreCase(other.name); }
        @Override
        public String toString() { return name + " | " + phone + " | " + email; }
    }
    
    public static void main(String[] args) {
        List<Contact> storage = new ArrayList<>();
        Map<String, Contact> lookup = new HashMap<>();
        Set<String> phones = new HashSet<>();
        
        // Add
        addContact(storage, lookup, phones, "Alice", "1234567890", "alice@example.com");
        addContact(storage, lookup, phones, "Bob", "0987654321", "bob@example.com");
        addContact(storage, lookup, phones, "Charlie", "1234567890", "charlie@example.com"); // Duplicate phone
        
        // Search
        System.out.println("Search 'Alice': " + lookup.get("alice"));
        
        // Delete
        Contact c = lookup.remove("bob");
        if (c != null) {
            storage.remove(c);
            phones.remove(c.phone);
        }
        
        // Display Sorted
        System.out.println("\n--- Address Book ---");
        Collections.sort(storage);
        for (Contact contact : storage) {
            System.out.println(contact);
        }
    }
    
    static void addContact(List<Contact> list, Map<String, Contact> map, Set<String> set, String name, String phone, String email) {
        if (!set.add(phone)) {
            System.out.println("Phone number " + phone + " already exists!");
            return;
        }
        Contact c = new Contact(name, phone, email);
        list.add(c);
        map.put(name.toLowerCase(), c);
    }
}
