import java.util.Scanner;

class StringComparison {

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

        System.out.print("Enter first string: ");
        String firstString = input.next();

        System.out.print("Enter second string: ");
        String secondString = input.next();

        boolean charAtResult = compareStrings(firstString, secondString);
        boolean equalsResult = firstString.equals(secondString);

        System.out.println("Result using charAt() = " + charAtResult);
        System.out.println("Result using equals() = " + equalsResult);

        input.close();
    }
}