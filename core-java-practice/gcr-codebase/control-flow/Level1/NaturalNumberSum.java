import java.util.Scanner;

class NaturalNumberSum {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        if (number > 0) {
            int sumOfNaturalNumbers = number * (number + 1) / 2;

            System.out.println("The sum of " + number + " natural numbers is " + sumOfNaturalNumbers);
        } else {
            System.out.println("The number " + number + " is not a natural number");
        }

        input.close();
    }
}