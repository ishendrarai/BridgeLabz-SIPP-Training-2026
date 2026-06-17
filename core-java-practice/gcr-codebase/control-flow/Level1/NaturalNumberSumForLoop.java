import java.util.Scanner;

class NaturalNumberSumForLoop {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int number = input.nextInt();

        if (number > 0) {

            int sumUsingFormula = number * (number + 1) / 2;

            int sumUsingForLoop = 0;

            for (int i = 1; i <= number; i++) {
                sumUsingForLoop = sumUsingForLoop + i;
            }

            System.out.println("Sum using formula = " + sumUsingFormula);
            System.out.println("Sum using for loop = " + sumUsingForLoop);

            if (sumUsingFormula == sumUsingForLoop) {
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