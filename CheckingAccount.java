import java.util.Currency;


public class CheckingAccount extends Account {
    private static final double TRANSACTION_FEE = 1.0;

    public CheckingAccount(double initialBalance, Currency currency) {
        super(initialBalance, currency);
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
}