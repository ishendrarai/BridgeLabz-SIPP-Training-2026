import java.util.Scanner;
import java.util.Arrays;

public class SplitStringCompare {
    public static int getStringLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
        }
        return count;
    }

    public static String[] splitText(String text) {
        int length = getStringLength(text);
        int spacesCount = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spacesCount++;
            }
        }

        int[] spaces = new int[spacesCount];
        int spaceIndex = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                spaces[spaceIndex++] = i;
            }
        }

        String[] words = new String[spacesCount + 1];
        int start = 0;
        for (int i = 0; i < spaces.length; i++) {
            words[i] = text.substring(start, spaces[i]);
            start = spaces[i] + 1;
        }
        words[spacesCount] = text.substring(start, length);
        return words;
    }

    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = input.nextLine();

        String[] customSplit = splitText(text);
        String[] builtInSplit = text.split(" ");

        boolean isEqual = compareStringArrays(customSplit, builtInSplit);

        System.out.println("Custom Split: " + Arrays.toString(customSplit));
        System.out.println("Built-in Split: " + Arrays.toString(builtInSplit));
        System.out.println("Are they equal? " + isEqual);

        input.close();
    }
}
