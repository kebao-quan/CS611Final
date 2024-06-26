package backEnd;
import java.util.Currency;


public class CheckingAccount extends Account {
    private static final String ACCOUNT_TYPE = "Checking";

    public CheckingAccount(String username, double initialBalance, Currency currency) {
        super(username, initialBalance, currency);
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount - TRANSACTION_FEE;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount + TRANSACTION_FEE > balance) {
            throw new InsufficientFundsException("Not enough funds.");
        }
        this.balance -= (amount + TRANSACTION_FEE);
    }

    @Override
    public String getAccountType() {
        return ACCOUNT_TYPE;
    }
}