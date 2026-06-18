import java.util.Scanner;

class PowerOfNumberWhileLoop {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = input.nextInt();

        System.out.print("Enter the power: ");
        int power = input.nextInt();

        if (number > 0 && power >= 0) {

            int result = 1;
            int counter = 0;

            while (counter < power) {
                result = result * number;
                counter++;
            }

            System.out.println(number + " raised to the power " + power + " is " + result);

        } else {
            System.out.println("Please enter valid positive values.");
        }

        input.close();
    }
}