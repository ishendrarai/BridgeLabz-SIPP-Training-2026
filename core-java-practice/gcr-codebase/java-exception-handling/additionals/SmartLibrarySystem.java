public class SmartLibrarySystem {
    private static String[] books = {"Java", "Python", null, "C++"};

    public static int getBookLength(int index) {
        try {
            return books[index].length();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception: Invalid index requested.");
        } catch (NullPointerException e) {
            System.out.println("Exception: Book entry contains null.");
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Length at index 5: " + getBookLength(5));
        System.out.println("Length at index 2: " + getBookLength(2));
    }
}
