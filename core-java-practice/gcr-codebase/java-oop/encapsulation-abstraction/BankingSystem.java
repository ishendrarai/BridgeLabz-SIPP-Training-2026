public class BankingSystem {
    abstract static class BankAccount {
        private String accountNumber;
        private String holderName;
        private double balance;

        public BankAccount(String accountNumber, String holderName, double balance) {
            this.accountNumber = accountNumber;
            this.holderName = holderName;
            this.balance = balance;
        }

        public String getAccountNumber() { return accountNumber; }
        public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

        public String getHolderName() { return holderName; }
        public void setHolderName(String holderName) { this.holderName = holderName; }

        public double getBalance() { return balance; }
        public void setBalance(double balance) { this.balance = balance; }

        public void deposit(double amount) {
            if (amount > 0) balance += amount;
        }

        public void withdraw(double amount) {
            if (amount > 0 && balance >= amount) balance -= amount;
        }

        public void displayAccountDetails() {
            System.out.println("Account: " + accountNumber + " | Holder: " + holderName + " | Balance: $" + balance);
        }

        public abstract double calculateInterest();
    }

    static class SavingsAccount extends BankAccount {
        private double interestRate;

        public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
            super(accountNumber, holderName, balance);
            this.interestRate = interestRate;
        }

        public double getInterestRate() { return interestRate; }
        public void setInterestRate(double interestRate) { this.interestRate = interestRate; }

        @Override
        public double calculateInterest() {
            return getBalance() * interestRate / 100;
        }
    }

    static class CurrentAccount extends BankAccount {
        private double monthlyBonusRate;

        public CurrentAccount(String accountNumber, String holderName, double balance, double monthlyBonusRate) {
            super(accountNumber, holderName, balance);
            this.monthlyBonusRate = monthlyBonusRate;
        }

        public double getMonthlyBonusRate() { return monthlyBonusRate; }
        public void setMonthlyBonusRate(double monthlyBonusRate) { this.monthlyBonusRate = monthlyBonusRate; }

        @Override
        public double calculateInterest() {
            return getBalance() * monthlyBonusRate / 100;
        }
    }

    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SA101", "Alice", 1000, 5);
        CurrentAccount ca = new CurrentAccount("CA202", "Bob", 5000, 2);

        sa.deposit(200);
        sa.withdraw(50);
        sa.displayAccountDetails();
        System.out.println("Interest: $" + sa.calculateInterest());

        ca.withdraw(1000);
        ca.displayAccountDetails();
        System.out.println("Interest: $" + ca.calculateInterest());
    }
}
