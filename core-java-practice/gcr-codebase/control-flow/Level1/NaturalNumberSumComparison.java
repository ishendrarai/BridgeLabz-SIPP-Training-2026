import java.util.Scanner;

class NaturalNumberSumComparison {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int number = input.nextInt();

        if (number > 0) {

            int sumUsingFormula = number * (number + 1) / 2;

            int sumUsingWhileLoop = 0;
            int counter = 1;

            while (counter <= number) {
                sumUsingWhileLoop = sumUsingWhileLoop + counter;
                counter++;
            }

            System.out.println("Sum using formula = " + sumUsingFormula);
            System.out.println("Sum using while loop = " + sumUsingWhileLoop);

            if (sumUsingFormula == sumUsingWhileLoop) {
                System.out.println("Both computations are correct.");
            } else {
                System.out.println("The computations are not equal.");
            }

        } else {
            System.out.println("The entered number is not a natural number.");
        }

        input.close();
    }
}