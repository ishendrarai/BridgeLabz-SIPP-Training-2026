import java.util.Scanner;

public class StringLength {
    public static int getStringLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Reached the end of the string
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = input.next();

        int userDefinedLength = getStringLength(text);
        int builtInLength = text.length();

        System.out.println("User-defined length: " + userDefinedLength);
        System.out.println("Built-in length: " + builtInLength);

        input.close();
    }
}
