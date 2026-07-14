import java.util.Scanner;

public class PalindromeCheck {
    public static boolean checkLogic1(String text) {
        int start = 0;
        int end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean checkLogic2(String text, int start, int end) {
        if (start >= end) return true;
        if (text.charAt(start) != text.charAt(end)) return false;
        return checkLogic2(text, start + 1, end - 1);
    }

    public static char[] reverseString(String text) {
        char[] reversed = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            reversed[i] = text.charAt(text.length() - 1 - i);
        }
        return reversed;
    }

    public static boolean checkLogic3(String text) {
        char[] original = text.toCharArray();
        char[] reversed = reverseString(text);
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = input.nextLine();

        System.out.println("Result using Iteration (Logic 1): " + checkLogic1(text));
        System.out.println("Result using Recursion (Logic 2): " + checkLogic2(text, 0, text.length() - 1));
        System.out.println("Result using Character Arrays (Logic 3): " + checkLogic3(text));

        input.close();
    }
}
