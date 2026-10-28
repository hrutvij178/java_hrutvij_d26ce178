public class Practical02 {
    static class Account {
        private String accountNumber;
        private String holder;
        private double balance;

        public Account(String accountNumber, String holder,
                       double balance) {
            this.accountNumber = accountNumber;
            this.holder = holder;
            this.balance = balance;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getHolder() {
            return holder;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
            } else {
                System.out.println("Invalid withdrawal.");
            }
        }

        public void display() {
            System.out.printf(
                "Account: %s, Holder: %s, Balance: Rs. %.2f%n",
                accountNumber, holder, balance
            );
        }
    }

    public static void main(String[] args) {
        Account account = new Account("MB101", "Rahul", 5000);
        account.display();

        account.deposit(1500);
        System.out.println("After deposit of Rs. 1500:");
        account.display();

        account.withdraw(1000);
        System.out.println("After withdrawal of Rs. 1000:");
        account.display();
    }
}