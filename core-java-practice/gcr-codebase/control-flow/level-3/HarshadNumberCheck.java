import java.util.Scanner;

class HarshadNumberCheck {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int originalNumber = number;
        int sum = 0;

        while (originalNumber != 0) {
            int digit = originalNumber % 10;
            sum = sum + digit;
            originalNumber = originalNumber / 10;
        }

        if (number % sum == 0) {
            System.out.println(number + " is a Harshad Number.");
        } else {
            System.out.println(number + " is not a Harshad Number.");
        }

        input.close();
    }
}