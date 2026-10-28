abstract class BankAccount {
    protected String accountNumber;
    protected double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    abstract double calculateInterest();

    public void display() {
        System.out.printf(
            "Account: %s, Balance: Rs. %.2f%n",
            accountNumber, balance
        );
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    SavingsAccount(String accountNumber, double balance,
                   double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    double calculateInterest() {
        return balance * interestRate / 100;
    }
}

public class Practical05 {
    public static void main(String[] args) {
        SavingsAccount account =
            new SavingsAccount("MB101", 10000, 5);

        account.display();
        System.out.printf(
            "Interest at 5%%: Rs. %.2f%n",
            account.calculateInterest()
        );
    }
}