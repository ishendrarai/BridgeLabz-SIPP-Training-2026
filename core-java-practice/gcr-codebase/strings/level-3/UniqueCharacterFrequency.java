import java.util.Scanner;

public class UniqueCharacterFrequency {
    public static char[] findUniqueCharacters(String text) {
        int[] freq = new int[256];
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (freq[text.charAt(i)] == 0) {
                freq[text.charAt(i)] = 1;
                count++;
            }
        }
        
        char[] unique = new char[count];
        int index = 0;
        for (int i = 0; i < text.length(); i++) {
            if (freq[text.charAt(i)] == 1) {
                unique[index++] = text.charAt(i);
                freq[text.charAt(i)] = 0;
            }
        }
        return unique;
    }

    public static String[][] getFrequenciesUsingUnique(String text) {
        char[] uniqueChars = findUniqueCharacters(text);
        String[][] result = new String[uniqueChars.length][2];

        for (int i = 0; i < uniqueChars.length; i++) {
            int count = 0;
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(j) == uniqueChars[i]) {
                    count++;
                }
            }
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(count);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = input.nextLine();

        String[][] frequencies = getFrequenciesUsingUnique(text);

        System.out.println("Character\tFrequency");
        for (int i = 0; i < frequencies.length; i++) {
            System.out.println("'" + frequencies[i][0] + "'\t\t" + frequencies[i][1]);
        }

        input.close();
    }
}
