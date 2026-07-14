import java.util.Scanner;

public class FirstNonRepeatingChar {
    public static char findFirstNonRepeating(String text) {
        int[] frequency = new int[256];
        
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        for (int i = 0; i < text.length(); i++) {
            if (frequency[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }
        return '\0'; // Return null character if none found
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = input.nextLine();

        char nonRepeating = findFirstNonRepeating(text);
        if (nonRepeating != '\0') {
            System.out.println("First non-repeating character: " + nonRepeating);
        } else {
            System.out.println("No non-repeating character found.");
        }

        input.close();
    }
}
