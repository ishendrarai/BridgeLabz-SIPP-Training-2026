import java.util.Scanner;

class ReverseNumberArray {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int tempNumber = number;
        int digitCount = 0;

        while (tempNumber != 0) {
            digitCount++;
            tempNumber = tempNumber / 10;
        }

        int[] digits = new int[digitCount];

        tempNumber = number;

        for (int i = 0; i < digitCount; i++) {
            digits[i] = tempNumber % 10;
            tempNumber = tempNumber / 10;
        }

        System.out.print("Reversed Number = ");

        for (int i = 0; i < digitCount; i++) {
            System.out.print(digits[i]);
        }

        System.out.println();

        input.close();
    }
}