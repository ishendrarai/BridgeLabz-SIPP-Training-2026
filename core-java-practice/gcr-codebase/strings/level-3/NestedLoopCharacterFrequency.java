import java.util.Scanner;

public class NestedLoopCharacterFrequency {
    public static String[][] getFrequenciesUsingNestedLoops(String text) {
        char[] chars = text.toCharArray();
        int[] freq = new int[text.length()];

        for (int i = 0; i < text.length(); i++) {
            freq[i] = 1;
            for (int j = i + 1; j < text.length(); j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // mark as visited
                }
            }
        }

        int uniqueCount = 0;
        for (int i = 0; i < text.length(); i++) {
            if (chars[i] != '0' && chars[i] != ' ') {
                uniqueCount++;
            }
        }

        String[][] result = new String[uniqueCount][2];
        int index = 0;
        for (int i = 0; i < text.length(); i++) {
            if (chars[i] != '0' && chars[i] != ' ') {
                result[index][0] = String.valueOf(chars[i]);
                result[index][1] = String.valueOf(freq[i]);
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = input.nextLine();

        String[][] frequencies = getFrequenciesUsingNestedLoops(text);

        System.out.println("Character\tFrequency");
        for (int i = 0; i < frequencies.length; i++) {
            System.out.println("'" + frequencies[i][0] + "'\t\t" + frequencies[i][1]);
        }

        input.close();
    }
}
