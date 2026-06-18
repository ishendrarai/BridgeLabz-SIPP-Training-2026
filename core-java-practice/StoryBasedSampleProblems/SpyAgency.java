import java.util.Scanner;

public class SpyAgency {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the secret message:- ");
        String message = sc.nextLine();

        String reversedMessage = "";

        for (int i = message.length() - 1; i >= 0; i--) {
            reversedMessage += message.charAt(i);
        }

        System.out.println("Reversed Message:- " + reversedMessage);

        if (message.equalsIgnoreCase(reversedMessage)) {
            System.out.println("The message is a palindrome.");
        } else {
            System.out.println("The message is not a palindrome.");
        }

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < message.length(); i++) {
            char ch = Character.toLowerCase(message.charAt(i));

            if (Character.isLetter(ch)) {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels:- " + vowels);
        System.out.println("Consonants:- " + consonants);

        System.out.print("Enter first intercept:- ");
        String intercept1 = sc.nextLine();

        System.out.print("Enter second intercept:- ");
        String intercept2 = sc.nextLine();

        if (intercept1.length() != intercept2.length()) {
            System.out.println("Not Anagrams");
        } else {

            char[] arr1 = intercept1.toLowerCase().toCharArray();
            char[] arr2 = intercept2.toLowerCase().toCharArray();

            for (int i = 0; i < arr1.length - 1; i++) {
                for (int j = i + 1; j < arr1.length; j++) {
                    if (arr1[i] > arr1[j]) {
                        char temp = arr1[i];
                        arr1[i] = arr1[j];
                        arr1[j] = temp;
                    }

                    if (arr2[i] > arr2[j]) {
                        char temp = arr2[i];
                        arr2[i] = arr2[j];
                        arr2[j] = temp;
                    }
                }
            }

            boolean isAnagram = true;

            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    isAnagram = false;
                    break;
                }
            }

            if (isAnagram) {
                System.out.println("Anagrams");
            } else {
                System.out.println("Not Anagrams");
            }
        }

        System.out.print("Enter surveillance log:- ");
        String log = sc.nextLine();

        char firstNonRepeating = '\0';

        for (int i = 0; i < log.length(); i++) {

            int count = 0;

            for (int j = 0; j < log.length(); j++) {
                if (log.charAt(i) == log.charAt(j)) {
                    count++;
                }
            }

            if (count == 1) {
                firstNonRepeating = log.charAt(i);
                break;
            }
        }

        if (firstNonRepeating != '\0') {
            System.out.println("First Non-Repeating Character:- " + firstNonRepeating);
        } else {
            System.out.println("No Non-Repeating Character Found");
        }

        sc.close();
    }
}