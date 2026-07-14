class InsufficientBalanceExceptionATM extends Exception {
    public InsufficientBalanceExceptionATM(String message) {
        super(message);
    }
}

public class ATMWithdrawalSystem {
    public static void main(String[] args) {
        double balance = 5000.0;
        double withdrawalRequest = 8000.0; // from scenario

        try {
            if (withdrawalRequest > balance) {
                throw new InsufficientBalanceExceptionATM("Insufficient balance! Withdrawal request exceeds current balance.");
            }
            balance -= withdrawalRequest;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } catch (InsufficientBalanceExceptionATM e) {
            System.out.println("Exception handled in main: " + e.getMessage());
        }
    }
}
