import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Practical12 {
    static class Account {
        String accountNumber;
        String holder;
        double balance;

        Account(String accountNumber, String holder,
                double balance) {
            this.accountNumber = accountNumber;
            this.holder = holder;
            this.balance = balance;
        }

        public String toString() {
            return holder + " - Rs. " + balance;
        }
    }

    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();

        accounts.add(new Account("MB101", "Rahul", 5000));
        accounts.add(new Account("MB102", "Amit", 8000));
        accounts.add(new Account("MB103", "Priya", 3000));
        accounts.add(new Account("MB104", "Neha", 6500));

        System.out.println("Original Accounts:");

        for (Account account : accounts) {
            System.out.println(account);
        }

        Collections.sort(
            accounts,
            Comparator.comparingDouble(a -> a.balance)
        );

        System.out.println("\nSorted by Balance:");

        for (Account account : accounts) {
            System.out.println(account);
        }

        Collections.sort(
            accounts,
            Comparator.comparing(a -> a.holder)
        );

        System.out.println("\nSorted by Holder Name:");

        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}