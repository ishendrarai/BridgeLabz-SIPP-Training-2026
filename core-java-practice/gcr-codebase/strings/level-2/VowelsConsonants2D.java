import java.util.Scanner;

public class VowelsConsonants2D {
    public static String checkCharacterType(char c) {
        if (c >= 'A' && c <= 'Z') {
            c = (char) (c + 32);
        }
        if (c >= 'a' && c <= 'z') {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return "Vowel";
            }
            return "Consonant";
        }
        return "Not a Letter";
    }

    public static String[][] getCharacterTypes(String text) {
        String[][] result = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            result[i][0] = String.valueOf(text.charAt(i));
            result[i][1] = checkCharacterType(text.charAt(i));
        }
        return result;
    }

    public static void display2DArray(String[][] arr) {
        System.out.println("Character\tType");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + "\t\t" + arr[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = input.nextLine();

        String[][] charTypes = getCharacterTypes(text);
        display2DArray(charTypes);

        input.close();
    }
}
