public class LibraryBooksAuthors {
    static class Book {
        String title;
        int publicationYear;

        public Book(String title, int publicationYear) {
            this.title = title;
            this.publicationYear = publicationYear;
        }
    }

    static class Author extends Book {
        String name;
        String bio;

        public Author(String title, int publicationYear, String name, String bio) {
            super(title, publicationYear);
            this.name = name;
            this.bio = bio;
        }

        public void displayInfo() {
            System.out.println("Book: " + title + " (" + publicationYear + ")");
            System.out.println("Author: " + name + " | Bio: " + bio);
        }
    }

    public static void main(String[] args) {
        Author author = new Author("Effective Java", 2008, "Joshua Bloch", "Java expert and former Google engineer.");
        author.displayInfo();
    }
}
