package backEnd;
import java.util.Date;
import java.io.Serializable;
import java.util.UUID;


public abstract class Transaction implements Serializable {
    protected String transactionId;
    protected Date transactionDate;
    protected double amount;
    protected Account account;
    protected Boolean isExecuted = false;

    public Transaction(Account account, double amount) {
        this.transactionId = UUID.randomUUID().toString();
        this.transactionDate = new Date(); // Current date and time
        this.amount = amount;
        this.account = account;
    }

    // Abstract method to execute the transaction
    public abstract void execute() throws InsufficientFundsException;

    // Getters for transaction details
    public String getTransactionId() {
        return transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public double getAmount() {
        return amount;
    }

    public Account getAccount() {
        return account;
    }

    public String toString() {
        return "Transaction ID: " + transactionId + "\n" +
                "Transaction Date: " + transactionDate + "\n" +
                "Amount: " + amount + "\n" +
                "Account ID: " + account.accountId;
    }
}
