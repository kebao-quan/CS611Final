package backEnd;
import java.util.Date;
import java.io.Serializable;
import java.util.UUID;


public abstract class Transaction implements Serializable {
    protected String transactionId;
    protected Date transactionDate;
    protected double amount;
    protected String accountId;
    protected Boolean isExecuted = false;

    public Transaction(String accountId, double amount) {
        this.transactionId = UUID.randomUUID().toString();
        this.transactionDate = new Date(); // Current date and time
        this.amount = amount;
        this.accountId = accountId;
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

    public String getAccount() {
        return accountId;
    }

    public String toString() {
        return "Transaction ID: " + transactionId + "\n" +
                "Transaction Date: " + transactionDate + "\n" +
                "Amount: " + amount + "\n" +
                "Account ID: " + accountId;
    }
}
