import java.util.Scanner;

public class SumOfNaturalNumbersRecursive {
    public static int sumRecursive(int n) {
        if (n <= 0) return 0;
        return n + sumRecursive(n - 1);
    }

    public static int sumFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        if (n > 0) {
            int recursiveResult = sumRecursive(n);
            int formulaResult = sumFormula(n);
            System.out.println("Recursive Sum: " + recursiveResult);
            System.out.println("Formula Sum: " + formulaResult);
            
            if (recursiveResult == formulaResult) {
                System.out.println("Both computations yield the correct and same result.");
            } else {
                System.out.println("Computations mismatch.");
            }
        } else {
            System.out.println("Not a natural number.");
        }
        scanner.close();
    }
}
