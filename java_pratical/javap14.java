import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Practical14 {
    static class Account implements Serializable {
        private static final long serialVersionUID = 1L;

        private String accountNumber;
        private String holder;
        private double balance;

        Account(String accountNumber, String holder,
                double balance) {
            this.accountNumber = accountNumber;
            this.holder = holder;
            this.balance = balance;
        }

        public double getBalance() {
            return balance;
        }

        public String toString() {
            return accountNumber + " - " + holder
                + " - Rs. " + String.format("%.2f", balance);
        }
    }

    static class BankService {
        private List<Account> accounts = new ArrayList<>();

        public void addAccount(Account account) {
            accounts.add(account);
        }

        public List<Account> getAccounts() {
            return accounts;
        }
    }

    static class Persistence {
        public static void saveAccounts(
                List<Account> accounts, String filename)
                throws IOException {
            try (ObjectOutputStream out =
                    new ObjectOutputStream(
                        new FileOutputStream(filename))) {
                out.writeObject(new ArrayList<>(accounts));
            }
        }

        @SuppressWarnings("unchecked")
        public static List<Account> loadAccounts(String filename)
                throws IOException, ClassNotFoundException {
            try (ObjectInputStream in =
                    new ObjectInputStream(
                        new FileInputStream(filename))) {
                return (List<Account>) in.readObject();
            }
        }
    }

    static class Report {
        public static void generate(List<Account> accounts) {
            System.out.println("\n--- MiniBank Account Report ---");

            double total = 0;

            for (Account account : accounts) {
                System.out.println(account);
                total += account.getBalance();
            }

            System.out.println(
                "Total Accounts: " + accounts.size()
            );

            System.out.printf(
                "Total Bank Balance: Rs. %.2f%n", total
            );
        }
    }

    public static void main(String[] args) {
        String filename = "minibank_accounts.ser";

        BankService service = new BankService();

        service.addAccount(
            new Account("MB101", "Rahul", 5000)
        );
        service.addAccount(
            new Account("MB102", "Amit", 8000)
        );
        service.addAccount(
            new Account("MB103", "Priya", 3000)
        );

        try {
            Persistence.saveAccounts(
                service.getAccounts(), filename
            );

            System.out.println("Accounts saved successfully.");

            List<Account> loadedAccounts =
                Persistence.loadAccounts(filename);

            System.out.println("Accounts loaded successfully.");

            Report.generate(loadedAccounts);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}