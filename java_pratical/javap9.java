public class Practical09 {
    static class BankAccount {
        private double balance = 5000;

        public synchronized void deposit(double amount) {
            balance += amount;
            System.out.println(
                Thread.currentThread().getName()
                + " deposited Rs. " + amount
            );
        }

        public double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args)
            throws InterruptedException {
        BankAccount account = new BankAccount();

        Thread first = new Thread(
            () -> account.deposit(1000), "Thread-1"
        );

        Thread second = new Thread(
            () -> account.deposit(2000), "Thread-2"
        );

        first.start();
        second.start();

        first.join();
        second.join();

        System.out.println(
            "Final Balance: Rs. " + account.getBalance()
        );
    }
}