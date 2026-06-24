import java.util.Scanner;

class DigitFrequency {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = input.nextLong();

        long tempNumber = number;

        int digitCount = 0;

        while (tempNumber != 0) {
            digitCount++;
            tempNumber = tempNumber / 10;
        }

        int[] digits = new int[digitCount];

        tempNumber = number;

        int index = 0;

        while (tempNumber != 0) {
            digits[index] = (int)(tempNumber % 10);
            tempNumber = tempNumber / 10;
            index++;
        }

        int[] frequency = new int[10];

        for (int i = 0; i < digits.length; i++) {
            frequency[digits[i]]++;
        }

        System.out.println("Digit Frequencies:");

        for (int i = 0; i < frequency.length; i++) {

            if (frequency[i] > 0) {
                System.out.println(i + " = " + frequency[i]);
            }

        }

        input.close();
    }
}