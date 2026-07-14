import java.util.Scanner;

class ArraySum {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double[] numbers = new double[10];
        double total = 0.0;

        int index = 0;

        while (true) {

            if (index == 10) {
                break;
            }

            System.out.print("Enter a number: ");
            double number = input.nextDouble();

            if (number <= 0) {
                break;
            }

            numbers[index] = number;
            index++;
        }

        for (int i = 0; i < index; i++) {
            total = total + numbers[i];
        }

        System.out.println("Total Sum = " + total);

        input.close();
    }
}