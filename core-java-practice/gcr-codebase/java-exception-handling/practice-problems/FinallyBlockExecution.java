import java.util.Scanner;

public class FinallyBlockExecution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter first integer: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second integer (divisor): ");
            int num2 = scanner.nextInt();

            int result = num1 / num2;
            System.out.println("Result of division: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        } finally {
            System.out.println("Operation completed");
            scanner.close();
        }
    }
}
