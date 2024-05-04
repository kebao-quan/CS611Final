package backEnd;
import java.io.Serializable;
import java.util.Currency;
import java.util.UUID;

public abstract class Account implements Serializable{
    protected String accountId;
    protected double balance;
    protected Currency currency;

    public Account(double initialBalance, Currency currency) {
        this.accountId = UUID.randomUUID().toString();
        this.balance = initialBalance;
        this.currency = currency;
    }

    public String getAccountId() {
        return accountId;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return "Generic Account";
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount) throws InsufficientFundsException;

    @Override
    public String toString() {
        return "Account ID: " + accountId + "   " +
                "Balance: " + balance + "   " +
                "Currency: " + currency + "   " +
                "Account Type: " + getAccountType();
    }
}

