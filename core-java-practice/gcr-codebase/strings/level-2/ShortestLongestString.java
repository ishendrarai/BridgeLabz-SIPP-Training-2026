import java.util.Scanner;

public class ShortestLongestString {
    public static int getStringLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
        }
        return count;
    }

    public static String[] splitText(String text) {
        return text.split(" ");
    }

    public static String[][] getWordLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getStringLength(words[i]));
        }
        return result;
    }

    public static String[] findShortestAndLongest(String[][] wordLengths) {
        if (wordLengths.length == 0) return new String[]{"", ""};
        
        String shortest = wordLengths[0][0];
        String longest = wordLengths[0][0];
        int shortestLen = Integer.parseInt(wordLengths[0][1]);
        int longestLen = Integer.parseInt(wordLengths[0][1]);

        for (int i = 1; i < wordLengths.length; i++) {
            int len = Integer.parseInt(wordLengths[i][1]);
            if (len < shortestLen) {
                shortestLen = len;
                shortest = wordLengths[i][0];
            }
            if (len > longestLen) {
                longestLen = len;
                longest = wordLengths[i][0];
            }
        }
        return new String[]{shortest, longest};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = input.nextLine();

        String[] words = splitText(text);
        String[][] wordLengths = getWordLengths(words);
        String[] result = findShortestAndLongest(wordLengths);

        System.out.println("Shortest word: " + result[0]);
        System.out.println("Longest word: " + result[1]);

        input.close();
    }
}
