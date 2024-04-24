public class CheckingAccount extends Account {
    private static final double TRANSACTION_FEE = 1.0;

    public CheckingAccount(String accountId, double initialBalance) {
        super(accountId, initialBalance);
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