import java.util.Scanner;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class HospitalBillingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] patients = {"John Doe", "Jane Smith", "Alice Johnson"};
        
        try {
            System.out.print("Enter patient index (0-2): ");
            int index = Integer.parseInt(scanner.nextLine());
            String patientName = patients[index];
            
            System.out.print("Enter total bill amount: ");
            double totalBill = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Enter number of items in bill: ");
            int itemsCount = Integer.parseInt(scanner.nextLine());
            
            double averageCost = totalBill / itemsCount; // could cause ArithmeticException for integers, but with doubles it's Infinity. We'll explicitly check.
            if (itemsCount == 0) {
                throw new ArithmeticException("Division by zero");
            }
            
            System.out.println("Patient: " + patientName);
            System.out.println("Average cost per item: " + averageCost);
            
            System.out.print("Enter payment amount: ");
            double payment = Double.parseDouble(scanner.nextLine());
            if (payment < totalBill) {
                throw new InsufficientFundsException("Payment is less than the total bill.");
            }
            System.out.println("Payment successful. Thank you!");
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid patient index.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format. Please enter numeric values.");
        } catch (ArithmeticException e) {
            System.out.println("Error: Bills with zero items are not valid.");
        } catch (InsufficientFundsException e) {
            System.out.println("Payment Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
