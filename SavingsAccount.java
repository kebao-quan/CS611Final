import java.util.Currency;


public class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.02;

    public SavingsAccount(double initialBalance, Currency currency) {
        super(initialBalance, currency);
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

    public void applyInterest() {
        this.balance += this.balance * INTEREST_RATE;
    }
}
