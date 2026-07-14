import java.util.Scanner;

class NumberArrayAnalysis {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] > 0) {

                if (numbers[i] % 2 == 0) {
                    System.out.println(numbers[i] + " is Positive and Even");
                } else {
                    System.out.println(numbers[i] + " is Positive and Odd");
                }

            } else if (numbers[i] < 0) {
                System.out.println(numbers[i] + " is Negative");
            } else {
                System.out.println(numbers[i] + " is Zero");
            }

        }

        if (numbers[0] == numbers[numbers.length - 1]) {
            System.out.println("First and Last elements are Equal");
        } else if (numbers[0] > numbers[numbers.length - 1]) {
            System.out.println("First element is Greater than Last element");
        } else {
            System.out.println("First element is Less than Last element");
        }

        input.close();
    }
}