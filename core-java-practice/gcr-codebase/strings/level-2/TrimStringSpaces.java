import java.util.Scanner;

public class TrimStringSpaces {
    public static int[] getTrimIndexes(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }
        return new int[]{start, end};
    }

    public static String createSubstring(String text, int start, int end) {
        if (start > end) return "";
        String result = "";
        for (int i = start; i <= end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text with spaces: ");
        String text = input.nextLine();

        int[] indexes = getTrimIndexes(text);
        String customTrim = createSubstring(text, indexes[0], indexes[1]);
        String builtInTrim = text.trim();

        boolean isEqual = compareStrings(customTrim, builtInTrim);

        System.out.println("Custom Trim: '" + customTrim + "'");
        System.out.println("Built-in Trim: '" + builtInTrim + "'");
        System.out.println("Are they equal? " + isEqual);

        input.close();
    }
}
