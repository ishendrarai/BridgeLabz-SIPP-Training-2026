public class BankAccountSystem {
    static class BankAccount {
        String accountNumber;
        String holder;
        double balance;
        static int totalAccounts = 0;

        public BankAccount(String accountNumber, String holder, double balance) {
            this.accountNumber = accountNumber;
            this.holder = holder;
            this.balance = balance;
            totalAccounts++;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                this.balance += amount;
                System.out.println("Deposited: " + amount + " to " + accountNumber);
            }
        }

        public void withdraw(double amount) {
            if (amount > 0) {
                if (this.balance - amount >= -500) { // Assuming $500 overdraft limit
                    this.balance -= amount;
                    System.out.println("Withdrew: " + amount + " from " + accountNumber);
                } else {
                    System.out.println("Overdraft limit exceeded for " + accountNumber);
                }
            }
        }

        public void getStatement() {
            System.out.println("Account: " + accountNumber + " | Holder: " + holder + " | Balance: $" + balance);
        }
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("A100", "Alice", 1000);
        BankAccount acc2 = new BankAccount("A200", "Bob", 500);
        BankAccount acc3 = new BankAccount("A300", "Charlie", 2000);

        System.out.println("Total Accounts: " + BankAccount.totalAccounts);

        acc1.deposit(200);
        acc1.withdraw(50);
        acc1.withdraw(1200);
        acc1.deposit(100);
        acc1.getStatement();

        acc2.withdraw(600);
        acc2.deposit(300);
        acc2.withdraw(100);
        acc2.getStatement();

        acc3.deposit(500);
        acc3.withdraw(200);
        acc3.withdraw(2500);
        acc3.getStatement();
    }
}
