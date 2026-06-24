import java.util.Scanner;

class LowerCaseComparison {

    public static String convertToLowerCase(String text) {

        String lowerCaseText = "";

        for (int i = 0; i < text.length(); i++) {

            char character = text.charAt(i);

            if (character >= 'A' && character <= 'Z') {
                character = (char)(character + 32);
            }

            lowerCaseText = lowerCaseText + character;
        }

        return lowerCaseText;
    }

    public static boolean compareStrings(String firstString, String secondString) {

        if (firstString.length() != secondString.length()) {
            return false;
        }

        for (int i = 0; i < firstString.length(); i++) {

            if (firstString.charAt(i) != secondString.charAt(i)) {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = input.nextLine();

        String userDefinedLowerCase = convertToLowerCase(text);
        String builtInLowerCase = text.toLowerCase();

        boolean result = compareStrings(userDefinedLowerCase, builtInLowerCase);

        System.out.println("User Defined Lowercase = " + userDefinedLowerCase);
        System.out.println("Built-in Lowercase = " + builtInLowerCase);
        System.out.println("Comparison Result = " + result);

        input.close();
    }
}