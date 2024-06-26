/**
 * Account class is an abstract class that represents a generic account.
 * It contains the basic information of an account such as the account ID, balance, currency, and username.
 */



package backEnd;
import java.io.Serializable;
import java.util.Currency;
import java.util.UUID;

public abstract class Account implements Serializable{
    protected static double TRANSACTION_FEE = 1.0;
    protected String username;
    protected String accountId;
    protected double balance;
    protected Currency currency;

    public Account(String username, double initialBalance, Currency currency) {
        this.accountId = UUID.randomUUID().toString();
        this.balance = initialBalance;
        this.currency = currency;
        this.username = username;
    }

    public static double getTransactionFee() {
        return TRANSACTION_FEE;
    }

    public String getUsername() {
        return username;
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


