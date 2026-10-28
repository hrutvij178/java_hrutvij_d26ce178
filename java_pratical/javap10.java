import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Practical10 {
    static class Transaction {
        String type;
        double amount;

        Transaction(String type, double amount) {
            this.type = type;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        BlockingQueue<Transaction> queue =
            new LinkedBlockingQueue<>();

        ExecutorService executor =
            Executors.newFixedThreadPool(2);

        double[] balance = {5000};

        Runnable producer = () -> {
            try {
                queue.put(new Transaction("DEPOSIT", 1000));
                queue.put(new Transaction("WITHDRAW", 500));
                queue.put(new Transaction("DEPOSIT", 2000));
                queue.put(new Transaction("STOP", 0));

                System.out.println(
                    "Producer: transactions added."
                );
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable consumer = () -> {
            try {
                while (true) {
                    Transaction transaction = queue.take();

                    if (transaction.type.equals("STOP")) {
                        break;
                    }

                    if (transaction.type.equals("DEPOSIT")) {
                        balance[0] += transaction.amount;
                    } else if (
                        transaction.type.equals("WITHDRAW")
                    ) {
                        balance[0] -= transaction.amount;
                    }

                    System.out.println(
                        "Consumer processed " + transaction.type
                        + " Rs. " + transaction.amount
                        + ", Balance: Rs. " + balance[0]
                    );
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        executor.submit(consumer);
        executor.submit(producer);
        executor.shutdown();

        while (!executor.isTerminated()) {
            Thread.yield();
        }

        System.out.println(
            "Final Balance: Rs. " + balance[0]
        );
    }
}