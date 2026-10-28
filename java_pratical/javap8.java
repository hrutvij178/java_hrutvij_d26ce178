class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String message) {
        super(message);
    }
}

public class Practical08 {
    static class BankAccount {
        private double balance;

        BankAccount(double balance) {
            this.balance = balance;
        }

        public void withdraw(double amount)
                throws InsufficientBalanceException {
            if (amount > balance) {
                throw new InsufficientBalanceException(
                    "Insufficient balance for withdrawal of Rs. "
                    + amount
                );
            }

            balance -= amount;
            System.out.println(
                "Withdrawal successful: Rs. " + amount
            );
        }

        public double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000);

        try {
            account.withdraw(2000);
            account.withdraw(4000);
        } catch (InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println(
            "Final Balance: Rs. " + account.getBalance()
        );
    }
}