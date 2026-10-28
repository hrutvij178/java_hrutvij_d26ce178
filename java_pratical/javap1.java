import java.util.Scanner;

public class Practical01 {
    enum MenuOption {
        DEPOSIT, BALANCE, EXIT
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 5000.0;
        boolean running = true;

        System.out.println("===== MiniBank =====");
        System.out.println("Welcome to MiniBank");

        while (running) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Check Balance");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double amount = sc.nextDouble();
                    if (amount > 0) {
                        balance += amount;
                        System.out.printf(
                            "Deposit successful. Balance: Rs. %.2f%n",
                            balance
                        );
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;
                case 2:
                    System.out.printf(
                        "Current Balance: Rs. %.2f%n", balance
                    );
                    break;
                case 3:
                    running = false;
                    System.out.println(
                        "Thank you for using MiniBank."
                    );
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}