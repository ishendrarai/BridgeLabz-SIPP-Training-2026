import java.util.Scanner;

public class CharacterFrequency {
    public static String[][] getCharacterFrequencies(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) uniqueCount++;
        }

        String[][] result = new String[uniqueCount][2];
        int index = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (freq[c] > 0) {
                result[index][0] = String.valueOf(c);
                result[index][1] = String.valueOf(freq[c]);
                freq[c] = 0; // Prevent duplicate entries
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = input.nextLine();

        String[][] frequencies = getCharacterFrequencies(text);

        System.out.println("Character\tFrequency");
        for (int i = 0; i < frequencies.length; i++) {
            System.out.println("'" + frequencies[i][0] + "'\t\t" + frequencies[i][1]);
        }

        input.close();
    }
}
