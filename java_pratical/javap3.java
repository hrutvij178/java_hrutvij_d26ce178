public class Practical03 {
    static class Account implements Cloneable {
        private String accountNumber;
        private String holder;
        private double balance;

        public Account(String accountNumber, String holder,
                       double balance) {
            this.accountNumber = accountNumber;
            this.holder = holder;
            this.balance = balance;
        }

        public Account clone() {
            try {
                return (Account) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Account)) return false;

            Account other = (Account) obj;
            return accountNumber.equals(other.accountNumber);
        }

        public String toString() {
            return accountNumber + " - " + holder
                    + " - Rs. " + balance;
        }
    }

    static class BankBranch {
        private String branchName;

        BankBranch(String branchName) {
            this.branchName = branchName;
        }

        public void display() {
            System.out.println("Branch: " + branchName);
        }
    }

    public static void main(String[] args) {
        Account first = new Account("MB101", "Rahul", 5000);
        Account second = new Account("MB101", "Rahul", 5000);
        Account copy = first.clone();

        System.out.println(first);
        System.out.println(
            "First equals second: " + first.equals(second)
        );
        System.out.println(
            "First equals clone by reference: " + (first == copy)
        );

        BankBranch branch =
            new BankBranch("Jamnagar Main Branch");
        branch.display();
    }
}