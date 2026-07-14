public class Day10_BankAccountSystem {
    static class BankAccount {
        private String accountNumber;
        private String holder;
        private double balance;
        private static int totalAccounts = 0;
        
        public BankAccount(String accNo, String holder, double initialBalance) {
            this.accountNumber = accNo;
            this.holder = holder;
            this.balance = initialBalance;
            totalAccounts++;
        }
        
        public void deposit(double amount) {
            if (amount > 0) balance += amount;
        }
        
        public void withdraw(double amount) {
            if (balance - amount < 0) {
                System.out.println("Overdraft Alert! Cannot withdraw " + amount + " from " + holder + "'s account.");
            } else {
                balance -= amount;
            }
        }
        
        public String getStatement() {
            return "Account: " + accountNumber + " | Holder: " + holder + " | Balance: $" + balance;
        }
        
        public static int getTotalAccounts() {
            return totalAccounts;
        }
    }
    
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("A101", "Alice", 1000);
        BankAccount acc2 = new BankAccount("A102", "Bob", 500);
        BankAccount acc3 = new BankAccount("A103", "Charlie", 2000);
        
        System.out.println("Total Accounts Created: " + BankAccount.getTotalAccounts());
        
        acc1.deposit(200); acc1.withdraw(500); acc1.withdraw(1000); acc1.deposit(100); acc1.withdraw(50);
        acc2.deposit(100); acc2.deposit(100); acc2.withdraw(800); acc2.deposit(50); acc2.withdraw(20);
        acc3.withdraw(100); acc3.withdraw(200); acc3.withdraw(300); acc3.deposit(500); acc3.deposit(1000);
        
        System.out.println(acc1.getStatement());
        System.out.println(acc2.getStatement());
        System.out.println(acc3.getStatement());
    }
}
