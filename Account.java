public abstract class Account {
    protected String accountId;
    protected double balance;

    public Account(String accountId, double initialBalance) {
        this.accountId = accountId;
        this.balance = initialBalance;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount) throws InsufficientFundsException;
    public double getBalance() {
        return balance;
    }
}


