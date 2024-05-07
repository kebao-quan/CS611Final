package backEnd;
public class DepositTransaction extends Transaction {

    public DepositTransaction(String accountId, double amount) {
        super(accountId, amount);
    }

    @Override
    public void execute() {
        Database.getInstance().getAccount(accountId).deposit(this.amount);
        isExecuted = true;
        Database.persist();
    }
}
