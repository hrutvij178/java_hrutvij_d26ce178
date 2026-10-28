import java.util.ArrayList;
import java.util.List;

public class Practical13 {
    static class Account {
        private String accountNumber;
        private String holder;
        private double balance;

        Account(String accountNumber, String holder,
                double balance) {
            this.accountNumber = accountNumber;
            this.holder = holder;
            this.balance = balance;
        }

        public String toString() {
            return accountNumber + " - " + holder
                + " - Rs. " + balance;
        }
    }

    static class Repository<T> {
        private List<T> items = new ArrayList<>();

        public void add(T item) {
            items.add(item);
        }

        public List<T> getAll() {
            return items;
        }

        public int count() {
            return items.size();
        }
    }

    public static void main(String[] args) {
        Repository<Account> repository = new Repository<>();

        repository.add(new Account("MB101", "Rahul", 5000));
        repository.add(new Account("MB102", "Amit", 8000));
        repository.add(new Account("MB103", "Priya", 3000));

        System.out.println(
            "--- MiniBank Account Repository ---"
        );

        for (Account account : repository.getAll()) {
            System.out.println(account);
        }

        System.out.println(
            "Total Accounts: " + repository.count()
        );
    }
}