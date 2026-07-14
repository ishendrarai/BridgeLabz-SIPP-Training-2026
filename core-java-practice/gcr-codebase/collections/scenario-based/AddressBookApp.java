import java.util.*;

public class AddressBookApp {
    static class Contact implements Comparable<Contact> {
        String name, phone, email;
        public Contact(String name, String phone, String email) {
            this.name = name; this.phone = phone; this.email = email;
        }
        @Override
        public int compareTo(Contact other) {
            return this.name.compareToIgnoreCase(other.name);
        }
        @Override
        public String toString() {
            return name + " | " + phone + " | " + email;
        }
    }
    
    private List<Contact> storage = new ArrayList<>();
    private Map<String, Contact> lookup = new HashMap<>();
    private Set<String> phones = new HashSet<>();
    
    public boolean addContact(String name, String phone, String email) {
        if (phones.contains(phone)) return false;
        Contact c = new Contact(name, phone, email);
        storage.add(c);
        lookup.put(name.toLowerCase(), c);
        phones.add(phone);
        return true;
    }
    
    public Contact search(String name) {
        return lookup.get(name.toLowerCase());
    }
    
    public boolean delete(String name) {
        Contact c = lookup.remove(name.toLowerCase());
        if (c != null) {
            storage.remove(c);
            phones.remove(c.phone);
            return true;
        }
        return false;
    }
    
    public void displaySorted() {
        Collections.sort(storage);
        for (Contact c : storage) {
            System.out.println(c);
        }
    }
}
