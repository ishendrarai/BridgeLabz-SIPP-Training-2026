import java.util.Scanner;

class MultiplesBelowHundredWhileLoop {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a positive integer less than 100: ");
        int number = input.nextInt();

        if (number > 0 && number < 100) {

            int counter = number;

            System.out.println("Multiples of " + number + " below 100 are:");

            while (counter < 100) {

                if (counter % number == 0) {
                    System.out.println(counter);
                    counter++;
                    continue;
                }

                counter++;
            }

        } else {
            System.out.println("Please enter a positive integer less than 100.");
        }

        input.close();
    }
}