package backEnd;
public class TransferTransaction extends Transaction {
    private String toAccountId;

    public TransferTransaction(String fromAccountId, String toAccountId, double amount) {
        super(fromAccountId, amount);
        this.toAccountId = toAccountId;
        this.amount = amount;
    }

    public void execute() throws InsufficientFundsException {
        Database.getInstance().getAccount(accountId).withdraw(this.amount);
        Database.persist();
        
        Database.getInstance().getAccount(toAccountId).deposit(this.amount);
        isExecuted = true;
        Database.persist();
    }
}
