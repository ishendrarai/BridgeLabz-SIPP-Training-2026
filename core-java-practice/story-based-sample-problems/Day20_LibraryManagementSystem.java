import java.util.*;

public class Day20_LibraryManagementSystem {
    
    interface Borrowable {
        void borrowItem();
        void returnItem();
    }
    
    interface Reservable {
        void reserveItem();
    }
    
    static abstract class Book implements Borrowable, Reservable {
        String title;
        String author;
        boolean isAvailable = true;
        
        public Book(String t, String a) { title = t; author = a; }
        @Override
        public void borrowItem() {
            if (isAvailable) {
                isAvailable = false;
                System.out.println(title + " borrowed successfully.");
            } else {
                System.out.println(title + " is currently unavailable.");
            }
        }
        @Override
        public void returnItem() {
            isAvailable = true;
            System.out.println(title + " returned.");
        }
        @Override
        public void reserveItem() { System.out.println(title + " reserved."); }
    }
    
    static class PhysicalBook extends Book {
        int weight;
        public PhysicalBook(String t, String a, int w) { super(t, a); weight = w; }
    }
    
    static class EBook extends Book {
        int fileSize;
        public EBook(String t, String a, int fs) { super(t, a); fileSize = fs; }
        @Override
        public void borrowItem() { System.out.println(title + " downloaded instantly."); }
        @Override
        public void returnItem() { System.out.println(title + " local copy deleted."); }
    }
    
    static class Member {
        String name;
        public Member(String name) { this.name = name; }
    }
    
    static class PremiumMember extends Member {
        public PremiumMember(String name) { super(name); }
        public void accessPremiumLounge() { System.out.println(name + " accessed premium lounge."); }
    }
    
    public static void main(String[] args) {
        List<Book> catalog = new ArrayList<>();
        catalog.add(new PhysicalBook("Java Fundamentals", "John Doe", 500));
        catalog.add(new EBook("Advanced Algorithms", "Jane Smith", 15));
        
        Map<String, Member> members = new HashMap<>();
        members.put("M01", new Member("Alice"));
        members.put("M02", new PremiumMember("Bob"));
        
        System.out.println("--- Library System ---");
        for (Book b : catalog) {
            b.borrowItem();
            b.returnItem();
        }
        
        ((PremiumMember) members.get("M02")).accessPremiumLounge();
    }
}
