import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class Practical11 {
    private static final Logger logger =
        Logger.getLogger(Practical11.class.getName());

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

        public String toString() {
            return "Account Number: " + accountNumber
                + ", Holder: " + holder
                + ", Balance: Rs. " + balance;
        }
    }

    public static void main(String[] args) {
        Account account = new Account("MB101", "Rahul", 5000);

        try {
            try (ObjectOutputStream out =
                    new ObjectOutputStream(
                        new FileOutputStream("account.ser"))) {
                out.writeObject(account);
            }

            System.out.println(
                "Account serialized successfully."
            );
            logger.info("Account serialized.");

            Account loaded;

            try (ObjectInputStream in =
                    new ObjectInputStream(
                        new FileInputStream("account.ser"))) {
                loaded = (Account) in.readObject();
            }

            System.out.println("Deserialized Account:");
            System.out.println(loaded);

            Path path = Paths.get("minibank.txt");
            Files.write(
                path,
                "MiniBank NIO file operation successful."
                    .getBytes()
            );

            System.out.println(
                "NIO File Content: "
                + new String(Files.readAllBytes(path))
            );

            logger.info("NIO file operation completed.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}