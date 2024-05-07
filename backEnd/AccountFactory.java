package backEnd;
import java.util.Currency;

public class AccountFactory {
    public Account createAccount(String username, String accountType, double balance, Currency currency) {
        switch (accountType) {
            case "Saving":
                return new SavingsAccount(username, balance, currency);
            case "Checking":
                return new CheckingAccount(username, balance, currency);
            case "Securities":
                return new SecurityAccount(username, balance, currency);
            default:
                return null;
        } 
    }
}
