public class Day07_HospitalBillingSystem {
    
    static class InsufficientFundsException extends Exception {
        public InsufficientFundsException(String msg) {
            super(msg);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("--- Hospital Billing System ---");
        
        // 1. Division by zero
        try {
            int totalBill = 5000;
            int items = 0;
            int avgPerItem = totalBill / items;
            System.out.println("Average per item: " + avgPerItem);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot compute average per item. Bill has zero items.");
        }
        
        // 2. Array out of bounds
        try {
            String[] patients = {"Alice", "Bob", "Charlie"};
            System.out.println("Patient 4: " + patients[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid patient index.");
        }
        
        // 3. Number format
        try {
            String badInput = "5000A";
            int amount = Integer.parseInt(badInput);
            System.out.println("Parsed amount: " + amount);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input format. Please enter a valid number.");
        }
        
        // 4. Custom Exception
        try {
            processPayment(1000, 500);
        } catch (InsufficientFundsException e) {
            System.out.println("Payment Failed: " + e.getMessage());
        }
    }
    
    public static void processPayment(double bill, double paid) throws InsufficientFundsException {
        if (paid < bill) {
            throw new InsufficientFundsException("Paid amount is less than the total bill.");
        }
        System.out.println("Payment successful. Change: $" + (paid - bill));
    }
}
