import java.util.Scanner;

public class QuotientAndRemainder {
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        if (divisor == 0) {
            System.out.println("Divisor cannot be zero.");
            return new int[]{0, 0};
        }
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[]{quotient, remainder};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = scanner.nextInt();
        System.out.print("Enter divisor: ");
        int divisor = scanner.nextInt();

        int[] result = findRemainderAndQuotient(number, divisor);
        System.out.println("Quotient: " + result[0]);
        System.out.println("Remainder: " + result[1]);
        
        scanner.close();
    }
}
