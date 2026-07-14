import java.util.Scanner;

public class SplitStringLength2D {
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
        
        if (spacesCount == 0 && length == 0) return new String[0];

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

    public static String[][] getWordLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getStringLength(words[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = input.nextLine();

        String[] words = splitText(text);
        String[][] wordLengths = getWordLengths(words);

        System.out.println("Word\tLength");
        for (int i = 0; i < wordLengths.length; i++) {
            System.out.println(wordLengths[i][0] + "\t" + Integer.parseInt(wordLengths[i][1]));
        }

        input.close();
    }
}
