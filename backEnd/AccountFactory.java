package backEnd;
import java.util.Currency;

public class AccountFactory {
    public Account createAccount(String accountType, double balance, Currency currency) {
        switch (accountType) {
            case "Saving":
                return new SavingsAccount(balance, currency);
            case "Checking":
                return new CheckingAccount(balance, currency);
            case "Securities":
                return new SecurityAccount(balance, currency);
            default:
                return null;
        } 
    }
}
