class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class HospitalBillingSystem {

    public static void processPayment(double balance, double amount)
            throws InsufficientFundsException {

        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Payment Failed: Insufficient Funds");
        }

        System.out.println("Payment Successful");
    }

    public static void main(String[] args) {

        try {

            int totalBill = 1000;
            int items = 0;

            int costPerItem = totalBill / items;

            System.out.println("Cost Per Item: " + costPerItem);

        } catch (ArithmeticException e) {

            System.out.println(
                    "Error: Cannot divide by zero. Number of items cannot be zero.");

        } finally {

            System.out.println("Billing calculation completed.");
        }

        try {

            String[] patients = {"Rahul", "Aman", "Priya"};

            System.out.println(patients[5]);

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println(
                    "Error: Invalid patient index entered.");
        }

        try {

            String input = "ABC123";

            int number = Integer.parseInt(input);

            System.out.println(number);

        } catch (NumberFormatException e) {

            System.out.println(
                    "Error: Invalid number format.");
        }

        try {

            processPayment(5000, 7000);

        } catch (InsufficientFundsException e) {

            System.out.println(e.getMessage());
        }
    }
}