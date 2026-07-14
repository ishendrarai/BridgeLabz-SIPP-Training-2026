import java.util.Scanner;

public class MultipleCatchBlocks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {10, 20, 30, 40, 50}; // initialize array

        try {
            System.out.print("Enter index: ");
            int index = scanner.nextInt();
            System.out.println("Value at index " + index + ": " + arr[index]);
            
            // To simulate NullPointerException, uncomment the following line:
            // arr = null;
            // System.out.println(arr[0]);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } finally {
            scanner.close();
        }
    }
}
