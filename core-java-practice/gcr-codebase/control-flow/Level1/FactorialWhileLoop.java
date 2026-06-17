import java.util.Scanner;

class FactorialWhileLoop {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        if (number > 0) {

            int factorial = 1;
            int counter = 1;

            while (counter <= number) {
                factorial = factorial * counter;
                counter++;
            }

            System.out.println("The factorial of " + number + " is " + factorial);

        } else {
            System.out.println("The entered number is not a positive integer.");
        }

        input.close();
    }
}