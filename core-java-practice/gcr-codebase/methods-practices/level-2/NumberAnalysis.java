import java.util.Scanner;

public class NumberAnalysis {
    public static boolean isPositive(int number) {
        return number >= 0;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int compare(int num1, int num2) {
        if (num1 > num2) return 1;
        if (num1 < num2) return -1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("\nAnalysis:");
        for (int i = 0; i < 5; i++) {
            if (isPositive(numbers[i])) {
                System.out.print("Number " + numbers[i] + " is Positive and ");
                if (isEven(numbers[i])) {
                    System.out.println("Even.");
                } else {
                    System.out.println("Odd.");
                }
            } else {
                System.out.println("Number " + numbers[i] + " is Negative.");
            }
        }

        int comp = compare(numbers[0], numbers[4]);
        if (comp == 1) {
            System.out.println("First element is greater than the last element.");
        } else if (comp == -1) {
            System.out.println("First element is less than the last element.");
        } else {
            System.out.println("First element is equal to the last element.");
        }

        scanner.close();
    }
}
