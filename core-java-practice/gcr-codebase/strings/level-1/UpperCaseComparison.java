import java.util.Scanner;

class UpperCaseComparison {

    public static String convertToUpperCase(String text) {

        String upperCaseText = "";

        for (int i = 0; i < text.length(); i++) {

            char character = text.charAt(i);

            if (character >= 'a' && character <= 'z') {
                character = (char)(character - 32);
            }

            upperCaseText = upperCaseText + character;
        }

        return upperCaseText;
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

        String userDefinedUpperCase = convertToUpperCase(text);
        String builtInUpperCase = text.toUpperCase();

        boolean result = compareStrings(userDefinedUpperCase, builtInUpperCase);

        System.out.println("User Defined Uppercase = " + userDefinedUpperCase);
        System.out.println("Built-in Uppercase = " + builtInUpperCase);
        System.out.println("Comparison Result = " + result);

        input.close();
    }
}