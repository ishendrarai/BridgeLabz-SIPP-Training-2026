import java.util.Scanner;

public class UniqueCharacters {
    public static int findLength(String text) {
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

    public static char[] findUniqueCharacters(String text) {
        int length = findLength(text);
        char[] temp = new char[length];
        int uniqueCount = 0;

        for (int i = 0; i < length; i++) {
            char current = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < uniqueCount; j++) {
                if (temp[j] == current) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                temp[uniqueCount++] = current;
            }
        }

        char[] uniqueChars = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueChars[i] = temp[i];
        }
        return uniqueChars;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = input.nextLine();

        char[] uniqueChars = findUniqueCharacters(text);
        System.out.print("Unique characters: ");
        for (int i = 0; i < uniqueChars.length; i++) {
            System.out.print(uniqueChars[i] + " ");
        }
        System.out.println();

        input.close();
    }
}
