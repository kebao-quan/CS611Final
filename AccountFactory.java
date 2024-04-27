import java.util.Currency;

public class AccountFactory {
    public Account createAccount(String accountType, double balance, Currency currency) {
        switch (accountType) {
            case "Savings":
                return new SavingsAccount(balance, currency);
            case "Checking":
                return new CheckingAccount(balance, currency);
            case "Security":
                return new SecurityAccount(balance, currency);
            default:
                return null;
        } 
    }
}
