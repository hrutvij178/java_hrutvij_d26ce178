import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@interface BankField {
    String value();
}

class CustomerAccount {
    @BankField("Account Number")
    private String accountNumber = "MB1001";

    @BankField("Current Balance")
    private double balance = 7500;
}

public class Practical07 {
    public static void main(String[] args) throws Exception {
        CustomerAccount account = new CustomerAccount();
        Class<?> cls = account.getClass();

        for (Field field : cls.getDeclaredFields()) {
            field.setAccessible(true);
            BankField annotation =
                field.getAnnotation(BankField.class);

            if (annotation != null) {
                System.out.println(
                    annotation.value() + ": " + field.get(account)
                );
            }
        }
    }
}