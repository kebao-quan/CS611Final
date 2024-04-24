import java.util.Date;


public abstract class Transaction {
    protected String transactionId;
    protected Date transactionDate;
    protected double amount;
    protected Account account;

    public Transaction(String transactionId, Account account, double amount) {
        this.transactionId = transactionId;
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
}
