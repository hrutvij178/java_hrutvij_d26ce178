interface Transaction {
    void deposit(double amount);
    void withdraw(double amount);
}

public class Practical06 {
    static class BankAccount implements Transaction {
        private double balance;

        BankAccount(double balance) {
            this.balance = balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.printf(
                    "Deposited: Rs. %.2f%n", amount
                );
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.printf(
                    "Withdrawn: Rs. %.2f%n", amount
                );
            } else {
                System.out.println("Transaction failed.");
            }
        }

        public void showBalance() {
            System.out.printf(
                "Current Balance: Rs. %.2f%n", balance
            );
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000);
        account.deposit(1000);
        account.withdraw(1500);
        account.showBalance();
    }
}