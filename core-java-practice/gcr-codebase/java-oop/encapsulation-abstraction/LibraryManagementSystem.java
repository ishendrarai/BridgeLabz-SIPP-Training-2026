public class LibraryManagementSystem {
    abstract static class LibraryItem {
        private String itemId;
        private String title;
        private String author;

        public LibraryItem(String itemId, String title, String author) {
            this.itemId = itemId;
            this.title = title;
            this.author = author;
        }

        public String getItemId() { return itemId; }
        public void setItemId(String itemId) { this.itemId = itemId; }

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getAuthor() { return author; }
        public void setAuthor(String author) { this.author = author; }

        public abstract int getLoanDuration();

        public void displayItemDetails() {
            System.out.println("ID: " + itemId + " | Title: " + title + " | Author: " + author + " | Loan Duration: " + getLoanDuration() + " days");
        }
    }

    static class Book extends LibraryItem {
        public Book(String itemId, String title, String author) {
            super(itemId, title, author);
        }

        @Override
        public int getLoanDuration() {
            return 14;
        }
    }

    static class Magazine extends LibraryItem {
        public Magazine(String itemId, String title, String author) {
            super(itemId, title, author);
        }

        @Override
        public int getLoanDuration() {
            return 7;
        }
    }

    static class DVD extends LibraryItem {
        public DVD(String itemId, String title, String author) {
            super(itemId, title, author);
        }

        @Override
        public int getLoanDuration() {
            return 3;
        }
    }

    public static void main(String[] args) {
        Book book = new Book("B101", "Java Programming", "James Gosling");
        Magazine mag = new Magazine("M202", "Tech Today", "Tech Editors");
        DVD dvd = new DVD("D303", "Java Tutorial", "Codecademy");

        book.displayItemDetails();
        mag.displayItemDetails();
        dvd.displayItemDetails();
    }
}
