import java.util.Scanner;

public class NestedTryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {100, 200, 300, 400, 500};

        System.out.print("Enter index: ");
        int index = scanner.nextInt();
        System.out.print("Enter divisor: ");
        int divisor = scanner.nextInt();

        try {
            try {
                int value = arr[index];
                try {
                    int result = value / divisor;
                    System.out.println("Result: " + result);
                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero!");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }
        } finally {
            scanner.close();
        }
    }
}
