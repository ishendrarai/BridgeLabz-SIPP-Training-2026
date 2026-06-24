import java.util.Scanner;

class OddEvenArray {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int number = input.nextInt();

        if (number <= 0) {
            System.out.println("Invalid Input");
            input.close();
            return;
        }

        int[] oddNumbers = new int[number / 2 + 1];
        int[] evenNumbers = new int[number / 2 + 1];

        int oddIndex = 0;
        int evenIndex = 0;

        for (int i = 1; i <= number; i++) {

            if (i % 2 == 0) {
                evenNumbers[evenIndex] = i;
                evenIndex++;
            } else {
                oddNumbers[oddIndex] = i;
                oddIndex++;
            }

        }

        System.out.println("Odd Numbers:");

        for (int i = 0; i < oddIndex; i++) {
            System.out.println(oddNumbers[i]);
        }

        System.out.println("Even Numbers:");

        for (int i = 0; i < evenIndex; i++) {
            System.out.println(evenNumbers[i]);
        }

        input.close();
    }
}