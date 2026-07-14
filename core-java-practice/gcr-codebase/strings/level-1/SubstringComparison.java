import java.util.Scanner;

class SubstringComparison {

    public static String createSubstring(String text, int startIndex, int endIndex) {

        String result = "";

        for (int i = startIndex; i < endIndex; i++) {
            result = result + text.charAt(i);
        }

        return result;
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
        String text = input.next();

        System.out.print("Enter start index: ");
        int startIndex = input.nextInt();

        System.out.print("Enter end index: ");
        int endIndex = input.nextInt();

        String customSubstring = createSubstring(text, startIndex, endIndex);
        String builtInSubstring = text.substring(startIndex, endIndex);

        boolean result = compareStrings(customSubstring, builtInSubstring);

        System.out.println("Custom Substring = " + customSubstring);
        System.out.println("Built-in Substring = " + builtInSubstring);
        System.out.println("Comparison Result = " + result);

        input.close();
    }
}