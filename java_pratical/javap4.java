import java.util.regex.Pattern;

public class Practical04 {
    public static void main(String[] args) {
        String name = "Rahul Sharma";
        String email = "rahul@example.com";
        String accountNumber = "MB1001";

        boolean validName =
            Pattern.matches("[A-Za-z ]+", name);

        boolean validEmail = Pattern.matches(
            "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}",
            email
        );

        boolean validAccount =
            Pattern.matches("MB[0-9]{4}", accountNumber);

        System.out.println("Name valid: " + validName);
        System.out.println("Name uppercase: " + name.toUpperCase());
        System.out.println("Name length: " + name.length());
        System.out.println("Email valid: " + validEmail);
        System.out.println(
            "Email domain: " +
            email.substring(email.indexOf('@') + 1)
        );
        System.out.println(
            "Account number valid: " + validAccount
        );
    }
}