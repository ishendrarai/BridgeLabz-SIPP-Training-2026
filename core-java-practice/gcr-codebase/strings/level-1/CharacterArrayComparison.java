import java.util.Scanner;

class CharacterArrayComparison {

    public static char[] getCharacters(String text) {

        char[] characters = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            characters[i] = text.charAt(i);
        }

        return characters;
    }

    public static boolean compareArrays(char[] firstArray, char[] secondArray) {

        if (firstArray.length != secondArray.length) {
            return false;
        }

        for (int i = 0; i < firstArray.length; i++) {

            if (firstArray[i] != secondArray[i]) {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = input.next();

        char[] userDefinedArray = getCharacters(text);
        char[] builtInArray = text.toCharArray();

        boolean result = compareArrays(userDefinedArray, builtInArray);

        System.out.println("Arrays are equal = " + result);

        input.close();
    }
}