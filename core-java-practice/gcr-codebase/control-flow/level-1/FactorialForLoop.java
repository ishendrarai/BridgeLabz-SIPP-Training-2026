import java.util.Scanner;

public class FactorialForLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();
        
        if (number >= 0) {
            long factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
            System.out.println("Factorial of " + number + " is " + factorial);
        } else {
            System.out.println("Please enter a positive integer.");
        }
        
        scanner.close();
    }
}
