import java.util.Scanner;

class CountDigits {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int count = 0;
        int tempNumber = number;

        while (tempNumber != 0) {
            tempNumber = tempNumber / 10;
            count++;
        }

        if (number == 0) {
            count = 1;
        }

        System.out.println("The number of digits in " + number + " is " + count);

        input.close();
    }
}