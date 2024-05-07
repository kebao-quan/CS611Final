package backEnd;
import java.util.Currency;


public class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.02;
    private static final String ACCOUNT_TYPE = "Saving";

    public SavingsAccount(String username, double initialBalance, Currency currency) {
        super(username, initialBalance, currency);
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Not enough funds.");
        }
        this.balance -= amount;
    }

    @Override
    public String getAccountType() {
        return ACCOUNT_TYPE;
    }

    public void applyInterest() {
        this.balance += this.balance * INTEREST_RATE;
    }
}
